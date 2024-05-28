package com.aykwon.peakdifference.maxpointdiff.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.aykwon.peakdifference.maxpointdiff.service.PointService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class PointController {
	
	@Autowired
	private PointService pointService;

	@PostMapping("check_table")
	public boolean checkTable(@RequestBody MultiValueMap<String, Object> requestBody) {
		String name = (String) requestBody.getFirst("name");
		@SuppressWarnings("null")
		boolean result = pointService.checkTable(name.toString());
		return result;
	}

	@PostMapping("/maxPointDiff")
	public String[] getMaxPoint(@RequestBody Map<String, String> requestBody) {
		String name = requestBody.get("name");
		System.out.println(name);
		return pointService.getMaxPoint(name);
	}
	
	
}
