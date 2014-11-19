package com.certifier.rest.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

import com.certifier.rest.dao.QuestionDao;
import com.certifier.rest.dao.QuestionDaoImpl;
import com.certifier.rest.dao.TestDao;
import com.certifier.rest.dao.TestDaoImpl;
import com.certifier.rest.domain.Option;
import com.certifier.rest.domain.Question;
import com.certifier.rest.entity.CAnswer;
import com.certifier.rest.entity.COption;
import com.certifier.rest.entity.CQuestion;
import com.certifier.rest.entity.CTest;
import com.certifier.rest.util.PersistenceUtil;
import com.sun.jersey.multipart.FormDataParam;

@Path("/tests")
public class TestResourceService implements TestResource {

	TestDao testDao = new TestDaoImpl();
	QuestionDao questionDao = new QuestionDaoImpl();

	public TestResourceService() {
		// TODO Auto-generated constructor stub
	}

	@POST
	@Consumes({ "multipart/form-data" })
	public Response CreateTest(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("testname") String testName) throws IOException {

		// byte[] bytes = IOUtils.toByteArray(uploadedInputStream);
		File file = File.createTempFile("temp", ".csv");
		FileUtils.copyInputStreamToFile(uploadedInputStream, file);
		byte[] byteArray = FileUtils.readFileToByteArray(file);
		CTest cTest = new CTest();
		cTest.setNo(String.valueOf(1));
		cTest.setName(testName);
		cTest.setFile(byteArray);
		List<CQuestion> cQuestionList = new LinkedList<CQuestion>();
		CSVReader reader = new CSVReader(new FileReader(file));
		String[] nextLine;
		int value = 0;
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			if (value == 0) {
				value = 1;
				continue;
			}
			System.out.println(nextLine[0] + nextLine[1] + nextLine[2]
					+ nextLine[3] + nextLine[4]);
			CQuestion cQuestion = new CQuestion();
			cQuestion.setQuestionno(nextLine[0]);
			cQuestion.setQuestion(nextLine[1]);
			cQuestion.setCategory(nextLine[2]);
			cQuestion.setCTest(cTest);
			cQuestionList.add(cQuestion);
			String[] answerArray = StringUtils.splitByWholeSeparator(
					nextLine[3], "~");
			List<CAnswer> cAnswerList = new LinkedList<CAnswer>();
			for (int i = 0; i < answerArray.length; i++) {
				CAnswer cAnswer = new CAnswer();
				cAnswer.setAnswer(answerArray[i]);
				cAnswer.setNo(i);
				cAnswer.setCQuestion(cQuestion);
				cAnswerList.add(cAnswer);

			}
			cQuestion.setCAnswers(cAnswerList);
			String[] optionArray = StringUtils.splitByWholeSeparator(
					nextLine[4], "~");
			List<COption> cOptionList = new LinkedList<COption>();
			for (int i = 0; i < optionArray.length; i++) {
				COption cOption = new COption();
				cOption.setChoices(optionArray[i]);
				cOption.setNo(i);
				cOption.setCQuestion(cQuestion);
				cOptionList.add(cOption);

			}
			cQuestion.setCOptions(cOptionList);
		}
		cTest.setCQuestions(cQuestionList);
		testDao.add(cTest);
		System.out.println("testname:" + testName);
		return Response.created(URI.create("/customers/" + "9")).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/{testNo}/question/{questionNo}")
	public Question getQuestion(@PathParam("testNo") String testNo,
			@PathParam("questionNo") String questionNo) {
		// CTest test = testDao.getById(Integer.valueOf(testNo));
		CQuestion cQuestion = questionDao.getById(Integer.valueOf(questionNo));

		System.out.println("test no:" + testNo + "question No:" + questionNo);
		if (cQuestion != null) {
			Question question = new Question();
			question.setQuestion(cQuestion.getQuestion());
			question.setQuestionNo(cQuestion.getQuestionno());
			question.setNextQuestionNo(String.valueOf(cQuestion
					.getCQuestionsId() + 1));
			question.setNextPreviousNo(String.valueOf(cQuestion
					.getCQuestionsId() - 1));

			List<Option> optionList = new LinkedList<Option>();
			List<COption> cAnswers = cQuestion.getCOptions();
			for (COption cAnswer : cAnswers) {
				Option option = new Option();
				option.setOption(cAnswer.getChoices());
				optionList.add(option);
			}
			question.setOptionList(optionList);
			return question;
		}
		return new Question();
	}

	public static void main(String ar[]) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// CTest test = entityManager.find(CTest.class, "1");
		CQuestion question = entityManager.find(CQuestion.class, 1);
		COption cOption = new COption();
		cOption.setChoices("sdfdsfs");
		cOption.setNo(1);
		cOption.setCQuestion(question);
		entityManager.persist(cOption);
		entityManager.flush();
		transaction.commit();
	}
}
