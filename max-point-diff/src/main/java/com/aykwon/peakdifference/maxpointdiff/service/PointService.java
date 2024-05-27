package com.aykwon.peakdifference.maxpointdiff.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public String[] getMaxPoint(String tableName) {
		List<Point> points = pointMapper.getAllPoint(tableName);

		// Variables to stroe the maximum distance and the points involved 
		double maxDistance = 0;
		Point pointA = null;
		Point pointB = null;

		// Compare each pair of points to find the maximum distance
		for(Point p1 : points){
			for(Point p2 : points){
				//같은 점은 건너뜀
				if(p1 == p2) continue;

				//현재 점 쌍의 거리 계산
				double distance = p1.distance(p2);

				//최대거리 갱신
				if(distance > maxDistance){
					maxDistance = distance;
					pointA = p1;
					pointB = p2;
				}
			}
		}

		// Output the points with the maximum distance
		if(pointA != null && pointB != null){
			String[] result = {
				String.valueOf(pointA.getLon()),
				String.valueOf(pointA.getLat()),
				String.valueOf(pointB.getLon()),
				String.valueOf(pointB.getLat())
			};
			return result;
		}		
		return null;
	}


}
