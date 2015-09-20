package com.velmurugan.certifier.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.entity.COption;
import com.velmurugan.certifier.entity.CQuestion;
import com.velmurugan.certifier.entity.CTest;
import com.velmurugan.certifier.entity.Vendor;
import com.velmurugan.certifier.model.OptionBean;
import com.velmurugan.certifier.model.QuestionBean;
import com.velmurugan.certifier.sax.parser.SaxHandler;
import com.velmurugan.certifier.service.TestService;
import com.velmurugan.certifier.service.VendorService;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * Handles requests for the application home page.
 * 
 * { enabled:true }
 * 
 *
 */
@Controller
@RequestMapping("/tests")
public class StandardTestController {

	@Autowired
	VendorService vendorService;

	@Autowired
	TestService testService;

	private static final Logger logger = LoggerFactory
			.getLogger(StandardTestController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getAll() {
		return "tests.";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getTest(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		return "testDetail.";
	}

	@RequestMapping(value = "/{id}/add", method = RequestMethod.POST, produces = {
			"application/json" })
	public @ResponseBody String addQuestion(@PathVariable Long id,
			HttpServletRequest request) {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		CQuestion question = new CQuestion();
		Integer totalOptions = Integer
				.valueOf(request.getParameter("totalOptions"));
		for (int i = 1; i <= totalOptions; i++) {
			COption option = new COption();
			option.setChoices(request.getParameter("option" + i));
			String isCorrect = request.getParameter("isCorrect" + i);
			if (StringUtils.equals("on", isCorrect)) {
				option.setCorrect(Boolean.TRUE);
			}

			else {
				option.setCorrect(Boolean.FALSE);
			}
			option.setExplanation(request.getParameter("description" + i));
			question.addCOption(option);

		}
		question.setQuestion(request.getParameter("question"));
		testService.addQuestionToTest(question, id);
		System.out.println("question is " + question);
		JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
		JsonArray value = arrayBuilder.add(factory.createObjectBuilder()
				.add("cQuestionsId", question.getCQuestionsId())
				.add("question", question.getQuestion())).build();
		return value.toString();
	}

	@RequestMapping(value = "/{id}/data", method = RequestMethod.GET)
	public @ResponseBody String getQuestionById(@PathVariable Long id,
			Locale locale, Model model,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "offset", defaultValue = "0") int offset,
			@RequestParam(value = "order", defaultValue = "asc") String order) {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);

		Set<CQuestion> questionList = testService.find(id).getCQuestions();
		JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
		for (CQuestion question : questionList) {
			Iterator<COption> iterator = question.getCOptions().iterator();
			String option = "";
			while (iterator.hasNext()) {
				option = option + iterator.next().getChoices();
			}
			arrayBuilder.add(factory.createObjectBuilder()
					.add("cQuestionsId", question.getCQuestionsId())
					.add("question", question.getQuestion())
					.add("options", option));
		}
		JsonObject value = factory.createObjectBuilder()
				.add("total", questionList.size()).add("rows", arrayBuilder)
				.build();

		return value.toString();
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = {
			"application/json" })
	public @ResponseBody String data(Locale locale, Model model,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "offset", defaultValue = "0") int offset,
			@RequestParam(value = "order", defaultValue = "asc") String order) {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		Page page = new Page(offset, limit);
		Long count = testService.count();
		List<CTest> testList = testService.findAll(page);
		JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
		for (CTest test : testList) {
			arrayBuilder.add(factory.createObjectBuilder()
					.add("cTestsId", test.getcTestsId())
					.add("name", test.getName()));
		}
		JsonObject value = factory.createObjectBuilder().add("total", count)
				.add("rows", arrayBuilder).build();

		return value.toString();
	}

	@RequestMapping(value = "/uploadDropbox", method = RequestMethod.POST)
	public String uploadFile(Locale locale,
			@RequestParam("dropbox-file") MultipartFile file, Model model)
					throws DbxException {
		// final String APP_KEY = "gw4w14qy8129lpi";
		// final String APP_SECRET = "hpycgtegwghz183";
		//
		// DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",
				Locale.getDefault().toString());
		DbxClient client = new DbxClient(config,
				"vmWxWONh_7gAAAAAAAAAE3egnyeHlXJ3EEHBLo8rFv6FU3IGil1Ps9zwGpNlpE5Z");
				// System.out.println("Linked account: " +
				// client.getAccountInfo().displayName);

		// File inputFile = new File("working-draft.txt");
		// FileInputStream inputStream = new FileInputStream(inputFile);
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
			DbxEntry.File uploadedFile = client.uploadFile(
					"/suppliers/" + file.getOriginalFilename(),
					DbxWriteMode.add(), file.getSize(), inputStream);
			System.out.println("Uploaded: " + uploadedFile.toString());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("message", "uploadDropbox");
		model.addAttribute("dropboxLink",
				"https://www.dropbox.com/home/suppliers/");
		return "exhibitors.";
	}

	@RequestMapping(value = "/import/csv", method = RequestMethod.POST)
	public String importCSVPost(Locale locale,
			@RequestParam("csv-file") MultipartFile file, Model model)
					throws IOException {

		logger.info("-- CSV imporing is started --   " + file.getName());
		HeaderColumnNameTranslateMappingStrategy<Vendor> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Vendor>();
		beanStrategy.setType(Vendor.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Show", "showName");
		columnMapping.put("Vendor Name", "vendorName");
		columnMapping.put("Booth No", "boothNo");
		columnMapping.put("Phone", "phone");
		columnMapping.put("Address", "address");
		columnMapping.put("Email", "email");
		columnMapping.put("Website", "website");

		beanStrategy.setColumnMapping(columnMapping);

		CsvToBean<Vendor> csvToBean = new CsvToBean<Vendor>();
		InputStreamReader inputStreamReader = new InputStreamReader(
				file.getInputStream());
		CSVReader reader = new CSVReader(inputStreamReader);
		List<Vendor> vendors = csvToBean.parse(beanStrategy, reader);
		for (Vendor vendor : vendors) {
			System.out.println(vendor);
			vendorService.create(vendor);
		}
		logger.info("-- CSV imported completed --   " + file.getName());
		model.addAttribute("message", "import");
		return "exhibitors.";
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public String exportCSV(Locale locale, Model model) {
		logger.info("Export CSV  is called ", locale);
		model.addAttribute("message", "export");
		return "exhibitors.";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = {
			"application/json" })
	public @ResponseBody String add(@ModelAttribute CTest test,
			@RequestParam("xml-file") MultipartFile file, BindingResult result,
			Model model) throws IOException {
		SaxHandler saxHandler = new SaxHandler();
		saxHandler.parse(file.getInputStream());
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		logger.info("test is " + test.getName());
		logger.info(
				"questions are : " + saxHandler.getTestBean().getQuestions());
		// List<CQuestion> questionList= new LinkedList<CQuestion>();
		for (QuestionBean qBean : saxHandler.getTestBean().getQuestions()) {
			CQuestion cQuestion = new CQuestion();
			cQuestion.setCTest(test);
			cQuestion.setQuestion(qBean.getTitle());
			test.addCQuestion(cQuestion);
			// questionList.add(cQuestion);
			// List<COption> optionList= new LinkedList<COption>();
			for (OptionBean oBean : qBean.getOptions()) {
				COption cOption = new COption();
				cOption.setChoices(oBean.getTitle());
				cQuestion.addCOption(cOption);
				cOption.setCQuestion(cQuestion);
				// optionList.add(cOption);
			}
		}
		testService.create(test);

		JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
		JsonArray value = arrayBuilder.add(factory.createObjectBuilder()
				.add("cTestsId", test.getcTestsId())
				.add("name", test.getName())).build();

		return value.toString();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody String edit(@ModelAttribute CTest test,
			BindingResult result, Model model) {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		CTest find = testService.find(test.getcTestsId());
		find.setName(test.getName());
		find.setCategory(test.getCategory());

		testService.update(find);
		System.out.println("test is " + find);

		JsonObject value = factory.createObjectBuilder()
				.add("cTestsId", test.getcTestsId()).add("name", test.getName())
				.build();

		return value.toString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = {
			"application/json", "application/xml",
			"application/x-www-form-urlencoded" })
	public String delete(@RequestBody String json, Model model) {
		JsonReader jsonReader = Json.createReader(new StringReader(json));
		JsonArray jsonArray = jsonReader.readArray();
		int size = jsonArray.size();
		System.out.println("Json input is " + jsonArray);
		for (int i = 0; i < size; i++) {
			String id = ((JsonObject) jsonArray.get(i)).getString("id");
			Vendor vendor = vendorService.find(Long.valueOf(id));
			vendorService.delete(vendor);
			System.out.println("deleted successfully " + id);
		}
		return "exhibitors.";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes = {
			"application/json", "application/xml" })
	public @ResponseBody String deleteById(@PathVariable Long id) {
		CTest vendor = testService.find(id);
		testService.delete(vendor);
		System.out.println("deleted successfully " + id);
		return "exhibitors.";
	}
}
