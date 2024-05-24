package com.aykwon.peakdifference.maxpointdiff.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aykwon.peakdifference.maxpointdiff.model.Point;

@Mapper
public interface PointMapper {   
    boolean checkTable(String tableName);
    List<Point> getAllPoint(String tableName);
}
