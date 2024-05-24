package com.aykwon.peakdifference.maxpointdiff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aykwon.peakdifference.maxpointdiff.controller.string;
import com.aykwon.peakdifference.maxpointdiff.mappers.PointMapper;
import com.aykwon.peakdifference.maxpointdiff.model.Point;

@Service
public class PointService {

	@Autowired(required=true)
	PointMapper pointMapper;

	public boolean checkTable(String tableName) {
		boolean result = pointMapper.checkTable(tableName);
		return result;
	}

	public String[] getMaxPoint(String first) {
		List<Point> list = pointMapper.getAllPoint(first);

		String[] test = {"a","b"};
		return test;
	}

	
}
