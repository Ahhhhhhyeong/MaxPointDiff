package com.aykwon.peakdifference.maxpointdiff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aykwon.peakdifference.maxpointdiff.mappers.PointMapper;

@Service
public class PointService {

	@Autowired(required=true)
	PointMapper pointMapper;

	public List<String> getAllModelTable(){
		return pointMapper.getAllModelTable();
	}

	public boolean checkTable(String tableName) {
		boolean result = pointMapper.checkTable(tableName);
		return result;
	}

	// public Point showDataList(){
	//     Point points = pointDAO.getAllPoints();
	//     return points;
	// } 
}
