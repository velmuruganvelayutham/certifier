package com.velmurugan.certifier.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.velmurugan.certifier.service.TestService;
import com.velmurugan.certifier.service.UserService;
import com.velmurugan.certifier.service.UserTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class AssignTestControllerTest {

	private static final String MAIN_LAYOUT_JSP = "/pages/tradeshow/templates/bootstrap/mainLayout.jsp";

	@Autowired
	UserService userService;

	@Autowired
	TestService testService;

	@Autowired
	UserTestService userTestService;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Test
	public void givenWac_whenServletContext_thenItAssignTestController() {
		ServletContext servletContext = wac.getServletContext();

		Assert.assertNotNull(servletContext);
		Assert.assertTrue(servletContext instanceof MockServletContext);
		Assert.assertNotNull(wac.getBean("assignTestController"));
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/assignTest")).andDo(print()).andExpect(view().name("assignTest."))
				.andExpect(status().isOk()).andExpect(forwardedUrl(MAIN_LAYOUT_JSP));
	}

	@Test
	public void assignTestToNewUser() throws Exception {
		this.mockMvc
				.perform(post("/assignTest").contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("selectedUser", "admin@admin.com").param("selectedTests", "1"))
				.andDo(print()).andExpect(view().name("assignTest.")).andExpect(status().isOk())
				.andExpect(model().attribute("message",
						"Selected Tests is assigned to user successfully " + "1" + "admin@admin.com"))
				.andExpect(forwardedUrl(MAIN_LAYOUT_JSP));
	}

	@Test
	public void assignTestToNonExistsUser() throws Exception {
		this.mockMvc
				.perform(post("/assignTest").contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("selectedUser", "non-exists@gmail.com").param("selectedTests", "1"))
				.andDo(print()).andExpect(view().name("assignTest.")).andExpect(status().isOk())
				.andExpect(model().attribute("message", "user is not found")).andExpect(forwardedUrl(MAIN_LAYOUT_JSP));
	}

	@Test
	public void assignNonExistsTestToUser() throws Exception {
		this.mockMvc
				.perform(post("/assignTest").contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("selectedUser", "admin@admin.com").param("selectedTests", "100"))
				.andDo(print()).andExpect(view().name("assignTest.")).andExpect(status().isOk())
				.andExpect(model().attribute("message", "test is not found")).andExpect(forwardedUrl(MAIN_LAYOUT_JSP));
	}

}
