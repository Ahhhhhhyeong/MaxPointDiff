package com.aykwon.peakdifference.maxpointdiff;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
class MaxPointDiffApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testControllerEndpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/maxPointDiff")
			.param("name", "model_ww3_data")
			.contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void contextLoads() {		
	}


}
