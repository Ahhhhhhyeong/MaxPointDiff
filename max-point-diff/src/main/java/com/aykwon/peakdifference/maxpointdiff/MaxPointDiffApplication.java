package com.aykwon.peakdifference.maxpointdiff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.aykwon.peakdifference.maxpointdiff.config.MybatisConfig;

@SpringBootApplication
@MapperScan("com.aykwon.peakdifference.maxpointdiff")
@Import(MybatisConfig.class)
public class MaxPointDiffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxPointDiffApplication.class, args);
	}

}
