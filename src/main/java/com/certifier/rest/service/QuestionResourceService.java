package com.certifier.rest.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.certifier.rest.domain.Question;

@Path(value = "/questions")
public class QuestionResourceService implements QuestionResource {

	@POST
	@Consumes(value = { "application/xml", "application/json" })
	public Response createQuestion(InputStream is) {
		return null;
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Question getQuestion(@PathParam(value = "id") int id) {

		Question question = new Question();
		question.setQuestion("vishal");
		question.setQuestionNo("velmurugan");
		return question;

	}

	@PUT
	@Path("/{id}")
	@Consumes(value = { "application/xml", "application/json" })
	public void updateQuestion(@PathParam(value = "id") int id, InputStream is) {

	}

}