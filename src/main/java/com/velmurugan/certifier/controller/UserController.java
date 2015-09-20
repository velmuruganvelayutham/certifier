package com.velmurugan.certifier.controller;

import java.util.List;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.entity.Users;
import com.velmurugan.certifier.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("message", "users are coming soon !.");
		return "users.";
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET, produces = {
			"application/json" })
	public @ResponseBody String getAll(Locale locale, Model model,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "offset", defaultValue = "0") int offset,
			@RequestParam(value = "order", defaultValue = "asc") String order) {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		Page page = new Page(offset, limit);
		Long count = userService.count();
		List<Users> userList = userService.findAll(page);
		JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
		for (Users user : userList) {
			arrayBuilder.add(factory.createObjectBuilder()
					.add("username", user.getUsername())
					.add("password", user.getPassword())
					.add("enabled", user.getIsEnabled()));
		}
		JsonObject value = factory.createObjectBuilder().add("total", count)
				.add("rows", arrayBuilder).build();

		return value.toString();
	}

}
