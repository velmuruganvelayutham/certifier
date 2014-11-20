package com.tocgroup.tradeshow.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import com.tocgroup.scrap.ABCKids14;
import com.tocgroup.scrap.ASDOnline;
import com.tocgroup.scrap.ExpocadWeb;
import com.tocgroup.scrap.Expotec;
import com.tocgroup.scrap.FallToy;
import com.tocgroup.scrap.FallToy14;
import com.tocgroup.scrap.FurnitureGiftMarket;
import com.tocgroup.scrap.OutdoorRetailer;
import com.tocgroup.scrap.Scraper;
import com.tocgroup.scrap.Spielwarenmesse;
import com.tocgroup.scrap.SportsTailgate;
import com.tocgroup.scrap.ToyFair;
import com.tocgroup.tradeshow.model.Settings;
import com.tocgroup.tradeshow.model.Vendor;
import com.tocgroup.tradeshow.service.SettingsService;
import com.tocgroup.tradeshow.service.VendorService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SettingsController {

	private static final Logger logger = LoggerFactory
			.getLogger(SettingsController.class);

	@Autowired
	SettingsService settingsService;
	@Autowired
	VendorService vendorService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);
		List<Settings> settings = settingsService.findAll();
		model.addAttribute("settings", settings);
		model.addAttribute("message", "Settings  are coming soon !.");
		return "settings.";

	}

	@RequestMapping(value = { "/settings/{action}", "", "" }, method = RequestMethod.POST)
	public @ResponseBody String save(
			@RequestParam MultiValueMap<String, String> map,
			@PathVariable String action) throws FileNotFoundException {
		List<String> urlList = map.get("url");
		String url = "";
		if (null != urlList && urlList.size() > 0)
			url = urlList.get(0);

		if (action.equalsIgnoreCase("add")) {
			Settings settings = new Settings();
			settings.setUrl(url);
			settings.setWebsiteName(map.get("websiteName").get(0));
			logger.info(" record created successfully with ID --> "
					+ settings.toString());
			settingsService.create(settings);
		} else if (action.equalsIgnoreCase("edit")) {
			String id = map.get("settings_id").get(0);
			Settings setting = settingsService.find(Long.valueOf(id));
			setting.setWebsiteName(map.get("websiteName").get(0));
			setting.setUrl(url);
			settingsService.update(setting);
			logger.info(" record updated successfully with ID --> " + id);
		} else if (action.equalsIgnoreCase("delete")) {
			String id = map.get("id").get(0);
			Settings setting = settingsService.find(Long.valueOf(id));
			settingsService.delete(setting);
			logger.info(" record deleted successfully with ID --> " + id);
		} else {
			String id = map.get("id").get(0);
			Settings setting = settingsService.find(Long.valueOf(id));
			logger.info("setting is found for extraction : --> " + setting);

			if (StringUtils.equalsIgnoreCase(
					"http://toyfall14.mapyourshow.com", setting.getUrl())) {
				importVendorsFromToyfall14();
			} else if (StringUtils.equalsIgnoreCase("http://www.asdonline.com",
					setting.getUrl())) {
				// new ASDOnline().extract();
				importVendorsFromASDOnline();

			} else if (StringUtils.equalsIgnoreCase(
					"http://www.lasvegasmarket.com", setting.getUrl())) {
				importVendorsFromFurnitureGiftMarket();
				// new FurnitureGiftMarket().extract();

			} else if (StringUtils.equalsIgnoreCase(
					"http://www.sportstailgateshow.com", setting.getUrl())) {
				// new SportsTailgate().extract();
				importVendorsFromSportsTailGate();

			} else if (StringUtils.equalsIgnoreCase(
					"http://www.expocadweb.com", setting.getUrl())) {
				// new ExpocadWeb().extract();
				importVendorsFromExpocadWeb();

			} else if (StringUtils.equalsIgnoreCase(
					"http://n2b.goexposoftware.com", setting.getUrl())) {
				// new OutdoorRetailer().extract();
				importVendorsFromOutdoorRetailer();

			} else if (StringUtils.equalsIgnoreCase("http://s23.a2zinc.net",
					setting.getUrl())) {
				importVendorsFromToyFair();
				// new ToyFair().extract();

			} else if (StringUtils.equalsIgnoreCase(
					"http://abckids14.mapyourshow.com", setting.getUrl())) {
				importVendorsFromABCKids();
				// new ABCKids14().extract();

			} else if (StringUtils.equalsIgnoreCase("http://10times.com",
					setting.getUrl())) {
				importVendorsFromFallToy();
				// new FallToy().extract();

			} else if (StringUtils.equalsIgnoreCase("http://www.toyfair.de",
					setting.getUrl())) {
				importVendorsFromSpielwarenmesseToyFair();

			} else if (StringUtils.equalsIgnoreCase("http://events.expotec.us",
					setting.getUrl())) {

				importVendorsFromExpotec();

			} else if (StringUtils.equalsIgnoreCase(
					"http://toyfall14.mapyourshow.com", setting.getUrl())) {
				// TODO: need to add here,...

			}

		}
		return "saved successully";

	}

	private void importVendorsFromExpotec() {
		importProductsFromCSV(new Expotec());
	}

	private void importVendorsFromSpielwarenmesseToyFair() {
		importProductsFromCSV(new Spielwarenmesse());

	}

	private void importVendorsFromFallToy() {
		importProductsFromCSV(new FallToy());
	}

	private void importVendorsFromABCKids() {
		importProductsFromCSV(new ABCKids14());
	}

	private void importVendorsFromToyFair() {

		importProductsFromCSV(new ToyFair());

	}

	private void importVendorsFromOutdoorRetailer() {
		importProductsFromCSV(new OutdoorRetailer());
	}

	private void importVendorsFromExpocadWeb() {
		importProductsFromCSV(new ExpocadWeb());

	}

	private void importVendorsFromSportsTailGate() {

		importProductsFromCSV(new SportsTailgate());
	}

	private void importVendorsFromFurnitureGiftMarket() {
		importProductsFromCSV(new FurnitureGiftMarket());

	}

	private void importVendorsFromASDOnline() {
		importProductsFromCSV(new ASDOnline());
	}

	/**
	 * 
	 */
	private void importProductsFromCSV(Scraper scraper) {
		try {
			String tempdir = System.getProperty("java.io.tmpdir");
			logger.info("using temporary folder --> " + tempdir);
			File file = scraper.extract();
			logger.info("-- CSV imporing is started --   " + file.getName());
			HeaderColumnNameTranslateMappingStrategy<Vendor> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Vendor>();
			beanStrategy.setType(Vendor.class);

			Map<String, String> columnMapping = new HashMap<String, String>();
			columnMapping.put("Show", "showName");
			// columnMapping.put("Show Date", "showStartDate");
			columnMapping.put("Vendor Name", "vendorName");
			columnMapping.put("Address", "address");
			columnMapping.put("Phone", "phone");
			columnMapping.put("Fax", "fax");
			columnMapping.put("Website", "website");
			columnMapping.put("Booth No", "boothNo");
			columnMapping.put("Email", "email");
			// columnMapping.put("Product Categories", "email");
			beanStrategy.setColumnMapping(columnMapping);
			CsvToBean<Vendor> csvToBean = new CsvToBean<Vendor>();
			InputStreamReader inputStreamReader = new InputStreamReader(
					new FileInputStream(file));
			CSVReader reader = new CSVReader(inputStreamReader);
			List<Vendor> vendors = csvToBean.parse(beanStrategy, reader);
			for (Vendor vendor : vendors) {
				logger.info(vendor.toString());
				vendorService.create(vendor);
			}
			logger.info("-- CSV imported completed --   " + file.getName());
		} catch (Exception e) {
			logger.error("error: while extracting vendor information--> ", e);
		}
	}

	/**
	 * @throws FileNotFoundException
	 */
	private void importVendorsFromToyfall14() throws FileNotFoundException {
		File file = new FallToy14().extract();
		logger.info("-- CSV imporing is started --   " + file.getName());
		HeaderColumnNameTranslateMappingStrategy<Vendor> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Vendor>();
		beanStrategy.setType(Vendor.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("Show", "showName");
		// columnMapping.put("Show Date", "showStartDate");
		columnMapping.put("vendor Name", "vendorName");
		columnMapping.put("Address", "address");
		columnMapping.put("Phone", "phone");
		columnMapping.put("Fax", "fax");
		columnMapping.put("Website", "website");
		columnMapping.put("Booth No", "boothNo");
		// columnMapping.put("Category", "email");
		beanStrategy.setColumnMapping(columnMapping);
		CsvToBean<Vendor> csvToBean = new CsvToBean<Vendor>();
		InputStreamReader inputStreamReader = new InputStreamReader(
				new FileInputStream(file));
		CSVReader reader = new CSVReader(inputStreamReader);
		List<Vendor> vendors = csvToBean.parse(beanStrategy, reader);
		for (Vendor vendor : vendors) {
			logger.info(vendor.toString());
			vendorService.create(vendor);
		}
		logger.info("-- CSV imported completed --   " + file.getName());
	}

	@RequestMapping(value = "/settings/delete", method = RequestMethod.POST, consumes = {
			"application/json", "application/xml",
			"application/x-www-form-urlencoded" })
	public String delete(@RequestBody String json, Model model) {
		JsonReader jsonReader = Json.createReader(new StringReader(json));
		JsonArray jsonArray = jsonReader.readArray();
		int size = jsonArray.size();
		logger.info("Json input is " + jsonArray);
		for (int i = 0; i < size; i++) {
			String id = ((JsonObject) jsonArray.get(i)).getString("id");
			Settings setting = settingsService.find(Long.valueOf(id));
			settingsService.delete(setting);
			logger.info("deleted successfully " + id);
		}
		return "exhibitors.";
	}

}
