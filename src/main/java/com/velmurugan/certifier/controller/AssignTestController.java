package com.velmurugan.certifier.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.velmurugan.certifier.entity.CTest;
import com.velmurugan.certifier.entity.UserTest;
import com.velmurugan.certifier.entity.Users;
import com.velmurugan.certifier.service.TestService;
import com.velmurugan.certifier.service.UserService;
import com.velmurugan.certifier.service.UserTestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AssignTestController {

	private static final Logger logger = LoggerFactory.getLogger(AssignTestController.class);

	@Autowired
	UserService userService;

	@Autowired
	TestService testService;

	@Autowired
	UserTestService userTestService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/assignTest", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("getting available users and tests ", locale);
		return fetchAllTests(model);
	}

	private String fetchAllTests(Model model) {
		List<CTest> tests = testService.findAll();
		List<Users> users = userService.findAll();
		model.addAttribute("availableTests", tests);
		model.addAttribute("availableUsers", users);
		return "assignTest.";
	}

	@RequestMapping(value = "/assignTest", method = RequestMethod.POST)
	public String assignTest(Locale locale,
			@RequestParam(value = "selectedTests", required = false, defaultValue = "1") String selectedTests,
			@RequestParam("selectedUser") String selectedUser, Model model) {

		logger.info("Selected Tests and Seleted User is {} {}.", selectedTests, selectedUser);

		if (StringUtils.isEmpty(selectedTests)) {
			model.addAttribute("message", "Selected Test can not be empty ");
			return fetchAllTests(model);
		}
		Long selectedTest = Long.valueOf(selectedTests);
		CTest test = testService.find(selectedTest);
		Users user = userService.findByEmail(selectedUser);
		UserTest findUserTest = userTestService.findByUsernameAndTestID(selectedUser, selectedTest);
		if (null != findUserTest) {
			model.addAttribute("message", "Selected Tests is already assigned to user ");
			return fetchAllTests(model);
		}
		UserTest userTest = new UserTest();
		userTest.setTest(test);
		userTest.setUsername(user);
		userTestService.create(userTest);
		model.addAttribute("message",
				"Selected Tests is assigned to user successfully " + selectedTests + selectedUser);
		// TODO: send mail to the user
		return fetchAllTests(model);

	}

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("message", "settings are coming soon !.");
		return "settings.";
	}

}
