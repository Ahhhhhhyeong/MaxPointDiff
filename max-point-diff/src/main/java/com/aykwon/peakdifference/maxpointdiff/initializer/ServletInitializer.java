package com.aykwon.peakdifference.maxpointdiff.initializer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.aykwon.peakdifference.maxpointdiff.MaxPointDiffApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MaxPointDiffApplication.class);
	}

}
