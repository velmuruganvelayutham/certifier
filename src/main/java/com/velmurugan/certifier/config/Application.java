package com.velmurugan.certifier.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Customize the application or call application.sources(...) to add
		// sources
		// Since our example is itself a @Configuration class (via
		// @SpringBootApplication)
		// we actually don't need to override this method.
		return application;
	}

}