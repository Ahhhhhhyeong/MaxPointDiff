package com.aykwon.peakdifference.maxpointdiff.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		int X = pointMapper.getMaxXPoint(tableName);
		int Y = pointMapper.getMaxYPoint(tableName);
		
		return findMaxDifferenceOn(points, X, Y);
	}
	// 최대 차 구하는 함수 : 시간복잡도 O(n^2)
	public String[] findMaxDifference(List<Point> points, int X, int Y){
		// Variables to store the maximum distance and the points involved 
		double maxDistance = 0;
		Point pointA = null;
		Point pointB = null;

		// Compare each pair of adjacent points to find the maximum distance
		for (Point p1 : points) {
			for (Point p2 : points) {
				// Skip the same point
				if (p1 == p2) continue;

				// Check if p2 is adjacent to p1
				if (Math.abs(p1.getLon() - p2.getLon()) <= 1 && Math.abs(p1.getLat() - p2.getLat()) <= 1) {
					double distance = p1.distance(p2);
					if (distance > maxDistance) {
						maxDistance = distance;
						pointA = p1;
						pointB = p2;
					}
				}
			}
		}

		// Output the points with the maximum distance
		if (pointA != null && pointB != null) {
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
	// 최대 차 구하는 함수 : 시간복잡도 O(n)
    public String[] findMaxDifferenceOn(List<Point> points, int X, int Y) {
        // Variables to store the maximum distance and the points involved
        double maxDistance = 0;
        Point pointA = null;
        Point pointB = null;

        // Using a map to store points based on their grid coordinates for quick access
        Map<String, Point> pointMap = new HashMap<>();
        for (Point p : points) {
            pointMap.put(p.getIdx_x() + "," + p.getIdx_y(), p);
        }

        // Directions for adjacent points (8 directions)
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},          {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (Point p1 : points) {
            for (int[] dir : directions) {
                int adjX = p1.getIdx_x() + dir[0];
                int adjY = p1.getIdx_y() + dir[1];
                String key = adjX + "," + adjY;

                if (pointMap.containsKey(key)) {
                    Point p2 = pointMap.get(key);
                    double distance = p1.distance(p2);
                    if (distance > maxDistance) {
                        maxDistance = distance;
                        pointA = p1;
                        pointB = p2;
                    }
                }
            }
        }

        // Output the points with the maximum distance
        if (pointA != null && pointB != null) {
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
