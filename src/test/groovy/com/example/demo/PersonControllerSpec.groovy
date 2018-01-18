package com.example.demo

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions

import com.example.demo.controller.PersonController

import spock.lang.Specification

@WebMvcTest(PersonController.class)
class PersonControllerSpec extends Specification {

	@Autowired
	private MockMvc mockMvc;
	
	def "Get by Id returns person with ID"() {
		given: "An Id"
		String id = "1";
		when: "Get by Id is called"
		ResultActions result = mockMvc.perform(get("/person/${id}"));
		then: "status is ok"
		result.andExpect(status().isOk())
		then: "person id is same as url"
		result.andExpect(jsonPath("\$.id").value(id));
	}
	
}
