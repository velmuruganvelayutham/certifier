package com.certifier.rest.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.certifier.rest.entity.CUser;
import com.certifier.rest.util.Mailer;
import com.certifier.rest.util.PersistenceUtil;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends BaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String command = request.getParameter("command");
		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession(true);
		}

		if (command.equalsIgnoreCase("sign-in")) {
			String emilid = request.getParameter("emailid");
			String password = request.getParameter("password");
			System.out.println("email id:" + emilid + "password:" + password
					+ "command:" + command);
			EntityManager entityManager = PersistenceUtil.getEntityManager();
			Query createQuery = entityManager
					.createQuery("select c from CUser c where c.emailid=:emailid");
			List resultList = createQuery.setParameter("emailid", emilid)
					.getResultList();
			CUser user = null;
			if (resultList.size() > 0) {
				user = (CUser) resultList.get(0);
			}
			System.out.println("Result:" + user);

			if (user != null && StringUtils.equals(emilid, user.getEmailid())
					&& StringUtils.equals(password, user.getPassword())) {

				System.out.println("session has been created:"
						+ session.getId());
				session.setAttribute("user", user.getEmailid());

				// request.setAttribute("user", singleResult.getEmailid());
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			} else {
				request.setAttribute("error", "invalid credentials");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}

		} else if (command.equalsIgnoreCase("forgot-password")) {
			String emilid = request.getParameter("emailid");
			System.out.println("email id:" + emilid);
			EntityManager entityManager = PersistenceUtil.getEntityManager();
			if (isUserExists(emilid, entityManager)) {
				// sending password to their email id.
				CUser user = getUserByMail(emilid, entityManager);

				Mailer.send(emilid, "Certifier:-- Your Forgotten Password",
						user.getPassword());
				request.setAttribute("emailidfound",
						"Password has been sent your mailid");
				request.getRequestDispatcher("forgot_password.jsp").forward(
						request, response);
			} else {
				request.setAttribute("emailidnotfound", "Email  not found.");
				request.getRequestDispatcher("forgot_password.jsp").forward(
						request, response);
			}

		} else if (command.equalsIgnoreCase("sign-up")) {
			String emilid = request.getParameter("emailid");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmpassword");
			System.out.println("email id:" + emilid + "password:" + password
					+ "Confirm Password:" + confirmPassword + "command:"
					+ command);
			if (!StringUtils.equals(password, confirmPassword)) {
				request.setAttribute("error", "invalid credentials");
				request.getRequestDispatcher("signup.jsp").forward(request,
						response);
			} else {
				EntityManager entityManager = PersistenceUtil
						.getEntityManager();
				if (!isUserExists(emilid, entityManager)) {
					createUser(emilid, password, entityManager);
					session.setAttribute("user", emilid);
					request.getRequestDispatcher("home.jsp").forward(request,
							response);
				} else {
					request.setAttribute("userexists", "Email  Already Exists");
					request.getRequestDispatcher("signup.jsp").forward(request,
							response);
				}
			}

		}
	}

}
