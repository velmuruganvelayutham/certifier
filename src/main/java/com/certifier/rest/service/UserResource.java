package com.certifier.rest.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.certifier.rest.domain.User;

public interface UserResource {

	public String getAllUser(Integer sEcho);

	public Response createUser(@FormParam("emailid") String emailid,
			@FormParam("password") String password,
			@FormParam("role") String role);

	public User getUser(@PathParam(value = "id") int id);

	public void updateUser(@FormParam("id") int id,
			@FormParam("value") String value);

	public User getUserByEmail(@FormParam("emailid") String emailid,
			@FormParam("password") String password);

	public void deleteUser(@FormParam("id") int id);
}
