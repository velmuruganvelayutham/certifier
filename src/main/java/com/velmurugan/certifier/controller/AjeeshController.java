package com.velmurugan.certifier.controller;

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/UpdateStatus")


public class AjeeshController {

	private static Map<String , Boolean> db= new HashMap<String, Boolean>();
	static {
		db.put("enabled", true);		
	}
	
	@RequestMapping(method = RequestMethod.POST, produces= {"application/json"},consumes= {"application/json"})
	public @ResponseBody String update(@RequestParam( value="enabled", required=false,defaultValue="true")Boolean status, @RequestBody (required=false) Map<String, String> input) {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
	 JsonObjectBuilder jsonObjectBuilder = factory.createObjectBuilder();
	 db.put("enabled", status);
	 jsonObjectBuilder.add("message", "status changed successfully");
		return jsonObjectBuilder.build().toString();
	}

	@RequestMapping(method = RequestMethod.GET, produces= {"application/json"})
	public @ResponseBody String get() {JsonBuilderFactory factory = Json.createBuilderFactory(null);
	 JsonObjectBuilder jsonObjectBuilder = factory.createObjectBuilder();
	 jsonObjectBuilder.add("enabled", db.get("enabled"));
		return jsonObjectBuilder.build().toString();}

	
}
