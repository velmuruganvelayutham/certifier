package com.velmurugan.certifier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.velmurugan.certifier.component.VelocityEmailSender;
import com.velmurugan.certifier.entity.UserRoles;
import com.velmurugan.certifier.entity.Users;
import com.velmurugan.certifier.entity.VerificationToken;
import com.velmurugan.certifier.model.UserFormBean;
import com.velmurugan.certifier.service.UserService;
import com.velmurugan.certifier.service.VerificationTokenService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@Autowired
	VerificationTokenService verificationTokenService;

	@Autowired
	VelocityEmailSender velocityEmailSender;

	@Autowired
	SimpleMailMessage templateMessage;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String home(Locale locale, @RequestParam(value = "login_error", required = false) String error,
			Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if (null == error)
			model.addAttribute("error", "");
		else
			model.addAttribute("error", "Invalid username or password");
		return "login.";
	}

	@RequestMapping(value = { "/login/validate" }, method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody String validateEmail(@RequestParam("email") String email, Model model) {
		// fetch the user by email { "valid": true }
		Users findByEmail = userService.findByEmail(email);
		if (findByEmail == null) {
			return Json.createObjectBuilder().add("valid", Boolean.FALSE).build().toString();
		}
		return Json.createObjectBuilder().add("valid", Boolean.TRUE).build().toString();
	}

	@RequestMapping(value = { "/signup/validate" }, method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody String isEmailExists(@RequestParam("email") String email, Model model) {
		// fetch the user by email { "valid": true }
		Users findByEmail = userService.findByEmail(email);
		if (findByEmail == null) {
			return Json.createObjectBuilder().add("valid", Boolean.TRUE).build().toString();
		}
		return Json.createObjectBuilder().add("valid", Boolean.FALSE).build().toString();
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String invalidUsername(Model model) {
		return "tests.";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String authenticate(Model model, @RequestParam MultiValueMap<String, String> map) {
		System.out.println(map);

		List<String> list = map.get("username");
		List<String> list2 = map.get("password");
		if (StringUtils.equals(list.get(0), list2.get(0))) {
			return "landing.";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login.";
		}

	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute UserFormBean userBean, HttpServletRequest request) {
		System.out.println("user form values are: " + userBean);

		Users user = new Users();
		user.setIsEnabled(false);
		user.setUsername(userBean.getEmail());
		user.setPassword(userBean.getPassword());
		UserRoles role = new UserRoles();
		role.setRole("ROLE_USER");
		user.addUserRole(role);
		userService.create(user);
		logger.info("User {} is created  ", user);
		// generate token and set confirmation URL
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUsers(user);
		verificationTokenService.save(verificationToken);
		logger.info("Verification Token is generated for user {} ", user);
		String appURL = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
		String confirmationURL = appURL + "/confirmation/token/" + token;
		// send confirmation mail
		sendMail(userBean.getEmail(), confirmationURL);
		logger.info("email is sent to {}", user);
		model.addAttribute("error", "confirmation link has beed sent to  " + user.getUsername() + "Please confirm !");
		return "login.";

	}

	private void sendMail(String mail, String confirmationURL) {
		// mail sending
		templateMessage.setTo(mail);

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("email", mail);
		props.put("confirmURL", confirmationURL);
		// props.put("lastName", "Smith");

		velocityEmailSender.send(templateMessage, props);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("error", "signed out successfully");
		return "login.";

	}

	@RequestMapping(value = "/confirmation/token/{value}", method = RequestMethod.GET)
	public String confirmationMail(Model model, @PathVariable String value) {
		logger.info("getting user for token {} ", value);
		Users user = userService.getUsersByToken(value);
		if (null != user) {
			logger.info("User is found for token {} ", value);
			user.setIsEnabled(true);
			userService.update(user);
			model.addAttribute("error", "Registration Successful!.. Login with your credentials ");
		} else {
			model.addAttribute("error", "Invalid Token !");
		}

		return "login.";

	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPassword(Model model, @RequestParam("email") String email) {
		sendMail(email, "");
		model.addAttribute("error", "password has been sent to your mail.");
		return "login.";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model) {

		return "403.";

	}

}
