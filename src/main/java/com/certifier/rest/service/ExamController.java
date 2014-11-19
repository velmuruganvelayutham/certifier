package com.certifier.rest.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.certifier.rest.dao.QuestionDaoImpl;
import com.certifier.rest.domain.ExamSummaryLine;
import com.certifier.rest.entity.CAnswer;
import com.certifier.rest.entity.CQuestion;
import com.certifier.rest.util.SessionStore;

/**
 * Servlet implementation class ExamController
 */
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SessionStore ss = null;
		HttpSession session = request.getSession(false);
		String submit = request.getParameter("submit");
		System.out.println("The submit is " + submit);
		if ("submit".equalsIgnoreCase(submit)) {
			session.setAttribute("summary", null);

			// match the answers of this user with answers from the database.
			ss = (SessionStore) session.getAttribute("sessionStore");
			List<ExamSummaryLine> summaryReport = getSummaryReport(
					ss.getOptionMap(), ss.getAnswerMap());
			// reset the session store
			session.setAttribute("sessionStore", null);

			// for (Entry<Integer, LinkedList<String>> entry : ss.getOptionMap()
			// .entrySet()) {
			// System.out.println(entry.getKey() + "/" + entry.getValue());
			// }
			session.setAttribute("summary", summaryReport);
			request.getRequestDispatcher("result.jsp").forward(request,
					response);
		} else {
			String parameter = request.getParameter("pageNumber");
			String testNo = request.getParameter("testNo");

			if (parameter == null) {
				parameter = "1";
			}
			// TODO: need to remove this later.
			if (testNo == null) {
				testNo = "11";
			}

			System.out.println("page number is:" + parameter);
			int pageNumber = Integer.valueOf(parameter);

			if (session == null) {
				session = request.getSession(true);
			}
			String totalQuestions = (String) session
					.getAttribute("totalNoQuestions");
			if (totalQuestions == null) {
				totalQuestions = new String(""
						+ new QuestionDaoImpl().getTotalNoOfQuestions());
				session.setAttribute("totalNoQuestions", totalQuestions);
			}
			CQuestion question = new QuestionDaoImpl().getQuestion(
					Integer.valueOf(testNo), pageNumber);

			int size = question.getCOptions().size();
			int cQuestionsId = question.getCQuestionsId();
			LinkedList<String> checkedOptionList = new LinkedList<String>();
			LinkedList<String> answersList = new LinkedList<String>();
			List<CAnswer> cAnswers = question.getCAnswers();
			for (CAnswer cAnswer : cAnswers) {
				answersList.add(cAnswer.getAnswer());
			}
			for (int i = 1; i <= size; i++) {
				String checkbox = request.getParameter("checkboxNo" + i);
				if (!StringUtils.isEmpty(checkbox)) {
					checkedOptionList.add(checkbox);
				}

			}
			if (session.getAttribute("sessionStore") == null) {
				ss = new SessionStore();
				session.setAttribute("sessionStore", ss);

			} else {
				ss = (SessionStore) session.getAttribute("sessionStore");
				ss.storeAnswers(cQuestionsId, answersList);
				ss.storeOptions(cQuestionsId, checkedOptionList);
				session.setAttribute("sessionStore", ss);
				session.setAttribute("list", ss.getOptionMap()
						.get(cQuestionsId));
				session.setAttribute("questionNo", cQuestionsId);
			}
			session.setAttribute("question", question);
			session.setAttribute("next", pageNumber + 1);
			session.setAttribute("previous", pageNumber - 1);
			System.out.println("The map is: " + ss.getOptionMap());
			System.out.println("The Answer map is : " + ss.getAnswerMap());
			request.getRequestDispatcher("exam.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private List<ExamSummaryLine> getSummaryReport(
			Map<Integer, LinkedList<String>> m1,
			Map<Integer, LinkedList<String>> m2) {
		List<ExamSummaryLine> summaryList = new LinkedList<ExamSummaryLine>();
		ExamSummaryLine examSummaryLine = null;
		if (m1.size() != m2.size()) {
			System.out.println("map is not equal");
		}
		for (Integer key : m1.keySet()) {
			examSummaryLine = new ExamSummaryLine();
			examSummaryLine.setQuestionNo(key);
			examSummaryLine.setLink("click here for more information");
			if (!m1.get(key).equals(m2.get(key))) {
				examSummaryLine.setResult("wrong");
				examSummaryLine.setScore(0);
				examSummaryLine.setCssClass("danger");

			} else {
				examSummaryLine.setResult("correct");
				examSummaryLine.setScore(1);
				examSummaryLine.setCssClass("success");
			}
			summaryList.add(examSummaryLine);
		}
		return summaryList;
	}
}
