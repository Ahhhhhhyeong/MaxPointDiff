package com.aykwon.peakdifference.maxpointdiff.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {   
    List<String> getAllModelTable();
    boolean checkTable(String tableName);
}
