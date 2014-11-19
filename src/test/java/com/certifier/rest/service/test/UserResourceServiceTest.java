package com.certifier.rest.service.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.certifier.rest.service.test.util.CertifierHttpClient;

public class UserResourceServiceTest {

	public UserResourceServiceTest() {
	}

	@Before
	public void setup() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testCreateUser() {
		String uri = "http://localhost:8080/quiz-app/rest/users/add";
		CertifierHttpClient client = new CertifierHttpClient(uri);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("emailid", "test"));
		urlParameters.add(new BasicNameValuePair("password", "password"));
		int statusCode = client.postForm(urlParameters);
		Assert.assertEquals("Create Test Failed", 201, statusCode);

	}

	@Test
	public void testUpdateUser() {
		String uri = "http://localhost:8080/quiz-app/rest/users/update";
		CertifierHttpClient client = new CertifierHttpClient(uri);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("id", "1"));
		urlParameters.add(new BasicNameValuePair("value", "password"));
		int statusCode = client.postForm(urlParameters);
		Assert.assertEquals("Update Test Failed", 204, statusCode);
	}

	@Test
	public void testGetUser() {
		String uri = "http://localhost:8080/quiz-app/rest/users";
		String jsonEntity = "{\"emailid\":\"vishal@gmail.com\",\"password\":\"vishal\"}";
		CertifierHttpClient client = new CertifierHttpClient(uri, jsonEntity,
				null);
		int statusCode = client.get(1);
		Assert.assertEquals("Get Test Failed", 200, statusCode);
	}

	@Test
	public void testAllUser() {
		String uri = "http://localhost:8080/quiz-app/rest/users";
		CertifierHttpClient client = new CertifierHttpClient(uri);
		int statusCode = client.get();
		Assert.assertEquals("Get Test Failed", 200, statusCode);
	}

	public void testDelete() {
		String uri = "http://localhost:8080/quiz-app/rest/users/delete";
		CertifierHttpClient client = new CertifierHttpClient(uri);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("id", "1"));
		int statusCode = client.postForm(urlParameters);
		Assert.assertEquals("Update Test Failed", 200, statusCode);
	}
}
