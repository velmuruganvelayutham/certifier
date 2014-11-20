package com.tocgroup.tradeshow.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

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
		return "exhibitors.";
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("error", "signed out successfully");
		return "login.";

	}

}
