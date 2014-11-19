package com.certifier.rest.service.test;

import org.junit.Assert;
import org.junit.Test;

import com.certifier.rest.service.test.util.CertifierHttpClient;

public class TestResourceServiceTest {

	public TestResourceServiceTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testCreate() throws Exception {
		String fileName = "C:\\Users\\velmuruganv\\test\\quiz-app\\src\\test\\resources\\sample_test.csv";
		String uri = "http://localhost:8080/quiz-app/rest/tests";
		CertifierHttpClient client = new CertifierHttpClient(uri);
		int statusCode = client.submitUploadForm(fileName);
		Assert.assertEquals("submitUploadForm Test Failed", 201, statusCode);
	}

	@Test
	public void testGetQuestion() {
		String uri = "http://localhost:8080/quiz-app/rest/tests/1/question";
		CertifierHttpClient client = new CertifierHttpClient(uri);
		int statusCode = client.get(1);
		Assert.assertEquals("get Question Test Failed", 200, statusCode);
	}

}
