package com.certifier.rest.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.certifier.rest.domain.ProfileModel;
import com.certifier.rest.entity.CUser;
import com.certifier.rest.entity.CUserProfile;
import com.certifier.rest.util.PersistenceUtil;

/**
 * Servlet implementation class ProfileController
 */
public class ProfileController extends BaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		String emailid = (String) request.getSession(false)
				.getAttribute("user");

		CUser userByMail = getUserByMail(emailid, entityManager);
		if (command == null) {
			command = "get-profile";
		}
		if (command.equalsIgnoreCase("update-profile")) {

			List<CUserProfile> cUserProfiles = userByMail.getCUserProfiles();
			ProfileModel profile = new ProfileModel();
			String city = request.getParameter("city");
			profile.setCity(city);
			String country = request.getParameter("country");
			profile.setCountry(country);
			String phoneNo = request.getParameter("phoneno");
			profile.setDescription(phoneNo);
			String emailId = request.getParameter("emailid");
			profile.setEmailId(emailId);
			String firstName = request.getParameter("firstName");
			profile.setFirstName(firstName);
			String lastName = request.getParameter("lastName");
			profile.setLastName(lastName);
			profile.setPhoneNo(phoneNo);
			String skypeId = request.getParameter("skypeid");
			profile.setSkypeId(skypeId);
			String description = request.getParameter("description");
			profile.setDescription(description);
			if (cUserProfiles.size() > 0) {
				// update it
				CUserProfile cUserProfile = cUserProfiles.get(0);
				cUserProfile.setCity(city);
				cUserProfile.setCountry(country);
				cUserProfile.setDescription(description);
				cUserProfile.setFirstName(firstName);
				cUserProfile.setLastName(lastName);
				cUserProfile.setPhoneno(phoneNo);
				cUserProfile.setSkypeId(skypeId);
				cUserProfile.setCUser(userByMail);
				entityManager.getTransaction().begin();
				entityManager.merge(cUserProfile);
				entityManager.flush();
				entityManager.getTransaction().commit();

			} else {
				// create the user profile
				CUserProfile cUserProfile = new CUserProfile();
				cUserProfile.setCity(city);
				cUserProfile.setCountry(country);
				cUserProfile.setDescription(description);
				cUserProfile.setFirstName(firstName);
				cUserProfile.setLastName(lastName);
				cUserProfile.setPhoneno(phoneNo);
				cUserProfile.setSkypeId(skypeId);
				cUserProfile.setCUser(userByMail);
				entityManager.getTransaction().begin();
				entityManager.persist(cUserProfile);
				entityManager.flush();
				entityManager.getTransaction().commit();

			}

			request.setAttribute("profile_updated_success",
					"The profile has been updated successfully");
			request.setAttribute("profile", profile);
			request.getRequestDispatcher("profile.jsp").forward(request,
					response);
		}
		if (command.equalsIgnoreCase("change-password")) {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmPassword = request.getParameter("confirmPassword");

			if (!StringUtils.equals(oldPassword, userByMail.getPassword())
					|| !StringUtils.equals(newPassword, confirmPassword)) {
				request.setAttribute(
						"password_not_match",
						"Make sure to give the old password as well as new password without any type errors.");
				request.getRequestDispatcher("profile.jsp").forward(request,
						response);
			} else {
				userByMail.setPassword(newPassword);
				entityManager.getTransaction().begin();
				entityManager.merge(userByMail);
				entityManager.getTransaction().commit();
				request.setAttribute("password_changed_success",
						"The password has been updated successfully");
				request.getRequestDispatcher("profile.jsp").forward(request,
						response);
			}

		}

		if (command.equalsIgnoreCase("get-profile")) {
			ProfileModel profile = new ProfileModel();
			List<CUserProfile> cUserProfiles = userByMail.getCUserProfiles();
			if (cUserProfiles.size() > 0) {
				CUserProfile cUserProfile = cUserProfiles.get(0);
				profile.setCity(cUserProfile.getCity());
				profile.setCountry(cUserProfile.getCountry());
				profile.setDescription(cUserProfile.getDescription());
				profile.setEmailId("email id @ certifier");
				profile.setFirstName(cUserProfile.getFirstName());
				profile.setLastName(cUserProfile.getLastName());
				profile.setPhoneNo(cUserProfile.getPhoneno());
				profile.setSkypeId(cUserProfile.getSkypeId());

			} else {
				profile.setCity("Bangalore");
				profile.setCountry("India");
				profile.setDescription("description");
				profile.setEmailId("email id @ certifier");
				profile.setFirstName("first name @ certifier");
				profile.setLastName("last name @ certifier");
				profile.setPhoneNo("phoneno @ cerfitier ");
				profile.setSkypeId("skype id @ certifier ");
			}

			request.setAttribute("profile", profile);
			request.getRequestDispatcher("profile.jsp").forward(request,
					response);
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

}
