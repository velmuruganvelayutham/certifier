package com.certifier.rest.service;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.certifier.rest.dao.UserDao;
import com.certifier.rest.dao.UserDaoImpl;
import com.certifier.rest.domain.User;
import com.certifier.rest.entity.CUser;

@Path(value = "/users")
public class UserResourceService implements UserResource {

	UserDao userDao = new UserDaoImpl();

	public UserResourceService() {
	}

	@POST
	@Path("/add")
	@Consumes(value = { "application/json", "application/x-www-form-urlencoded" })
	public Response createUser(@FormParam("emailid") String emailid,
			@FormParam("password") String password,
			@FormParam("role") String role) {
		System.out.println("Request Params: emailid" + emailid + " password: "
				+ password);
		CUser user = new CUser();
		user.setEmailid(emailid);
		user.setPassword(password);
		user.setRole(role);
		userDao.add(user);
		System.out.println("User has beed added:" + user);
		return Response
				.created(URI.create("/customers/" + user.getCUserId()))
				.cookie(new NewCookie("name", emailid, null, null,
						"test comment", 10, false)).build();

	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") int id) {
		CUser user = userDao.getById(id);
		User outputUser = new User();
		outputUser.setEmailid(user.getEmailid());
		outputUser.setPassword(user.getPassword());
		outputUser.setRole(user.getRole());
		return outputUser;
	}

	//
	// @PUT
	// @Path("/{id}")
	// @Consumes(value = { "application/json" })
	// public void updateUser(@PathParam("id") int id, User inputUser) {
	// CUser user = userDao.getById(id);
	// user.setPassword(inputUser.getPassword());
	// userDao.update(user);
	// }

	@POST
	@Path("/update")
	@Consumes(value = { "application/json", "application/x-www-form-urlencoded" })
	public void updateUser(@FormParam("id") int id,
			@FormParam("value") String value) {
		System.out.println("The form parameters are:" + id + "  :" + value);
		CUser user = userDao.getById(id);
		user.setPassword(value);
		userDao.update(user);
	}

	@GET
	@Produces("application/json")
	public String getAllUser(@QueryParam("sEcho") Integer sEcho) {
		JSONArray data = new JSONArray();
		List<CUser> allUser = userDao.getAllUser();

		JSONObject jsonResponse = new JSONObject();

		try {
			jsonResponse.put("sEcho", sEcho);

			jsonResponse.put("iTotalRecords", allUser.size());
			jsonResponse.put("iTotalDisplayRecords", allUser.size());

			for (CUser c : allUser) {
				JSONArray row = new JSONArray();
				row.put(c.getCUserId()).put(c.getEmailid())
						.put(c.getPassword()).put(c.getRole());
				data.put(row);
			}
			jsonResponse.put("aaData", data);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// List<User> allOutput = new LinkedList<User>();
		//
		// int size = allUser.size();
		// User[][] arrayOfUser = new User[size][4];
		// for (int i = 0; i < size; i++) {
		// for (int j = 0; j < 4; j++) {
		// User user = new User();
		// user.setId(allUser.get(i).getCUserId());
		// user.setEmailid(allUser.get(i).getEmailid());
		// user.setPassword(allUser.get(i).getPassword());
		// user.setRole(allUser.get(i).getRole());
		// allOutput.add(user);
		// arrayOfUser[i][j] = user;
		// }
		// }
		// // User[] arrayOfUser = (User[]) allOutput.toArray();
		// // User[][] arrayOfUser = allOutput.toArray(new User[0][0]);
		// DataTableResponseParam dataTableResponse = new
		// DataTableResponseParam();
		// dataTableResponse.setAaData(arrayOfUser);
		// dataTableResponse.setsEcho(String.valueOf(sEcho));
		// dataTableResponse.setiTotalDisplayRecords(allOutput.size() - 4);
		// dataTableResponse.setiTotalRecords(allOutput.size());
		// System.out.println(allOutput);
		return jsonResponse.toString();
	}

	@POST
	@Path("/delete")
	public void deleteUser(@FormParam("id") int id) {
		UserDao userDao = new UserDaoImpl();
		userDao.delete(id);
	}

	@POST
	@Path("/login")
	@Consumes(value = { "application/json", "application/x-www-form-urlencoded" })
	public User getUserByEmail(@FormParam("emailid") String emailid,
			@FormParam("password") String password) {
		System.out.println("Request Params: emailid" + emailid + " password: "
				+ password);
		CUser byId = userDao.getById(9);
		if (byId != null && byId.getEmailid() != null) {

		}

		return new User();
	}
}
