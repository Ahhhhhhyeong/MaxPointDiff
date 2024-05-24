package com.aykwon.peakdifference.maxpointdiff.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.aykwon.peakdifference.maxpointdiff.model.Point;
import com.aykwon.peakdifference.maxpointdiff.service.PointService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class PointController {
    
	@Autowired
	private PointService pointService;
	
	@PostMapping("check_table")
	public boolean checkTable(@RequestBody MultiValueMap<String, Object> requestBody) {
		String name = (String) requestBody.getFirst("name");
		boolean result = pointService.checkTable(name.toString());
		return result;
	}

	@PostMapping("maxPointDiff")
	public String[] getMaxPoint(@RequestParam  MultiValueMap<String, Object> requestBody) {
		return pointService.getMaxPoint((String) requestBody.getFirst("name"));
	}
	
    
    
}
