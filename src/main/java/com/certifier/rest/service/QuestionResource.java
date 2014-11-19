package com.certifier.rest.service;

import java.io.InputStream;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.certifier.rest.domain.Question;

public interface QuestionResource {

	public Response createQuestion(InputStream is);

	public Question getQuestion(@PathParam(value = "id") int id);

	public void updateQuestion(@PathParam(value = "id") int id, InputStream is);

}
