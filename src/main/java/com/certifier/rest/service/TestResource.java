package com.certifier.rest.service;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.Response;

import com.sun.jersey.multipart.FormDataParam;

public interface TestResource {

	public Response CreateTest(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("testName") String testName) throws IOException;

}
