package com.velmurugan.certifier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.velmurugan.certifier.component.VelocityEmailSender;
import com.velmurugan.certifier.entity.UserRoles;
import com.velmurugan.certifier.entity.Users;
import com.velmurugan.certifier.model.UserFormBean;
import com.velmurugan.certifier.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@Autowired
	VelocityEmailSender velocityEmailSender;

	@Autowired
	SimpleMailMessage templateMessage;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String home(
			Locale locale,
			@RequestParam(value = "login_error", required = false) String error,
			Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		if (null == error)
			model.addAttribute("error", "");
		else
			model.addAttribute("error", "Invalid username or password");
		return "login.";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String invalidUsername(Model model) {
		return "tests.";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String authenticate(Model model,
			@RequestParam MultiValueMap<String, String> map) {
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
	public String register(Model model, @ModelAttribute UserFormBean userBean) {
		System.out.println("user form values are: " + userBean);

		Users user = new Users();
		user.setIsEnabled(true);
		user.setUsername(userBean.getEmail());
		user.setPassword(userBean.getPassword());
		UserRoles role = new UserRoles();
		role.setRole("ROLE_USER");
		user.addUserRole(role);

		sendMail(userBean.getEmail());
		userService.create(user);
		model.addAttribute("error",
				"Registration Successful!.. Login with your credentials ");
		return "login.";

	}

	private void sendMail(String mail) {
		// mail sending
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		templateMessage.setTo(mail);

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("email", mail);
		// props.put("lastName", "Smith");

		velocityEmailSender.send(msg, props);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("error", "signed out successfully");
		return "login.";

	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public String forgotPassword(Model model,
			@RequestParam("email") String email) {
		sendMail(email);
		model.addAttribute("error", "password has been sent to your mail.");
		return "login.";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model) {

		return "403.";

	}

}
