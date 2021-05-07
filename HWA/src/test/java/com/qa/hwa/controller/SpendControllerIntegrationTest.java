package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.spendingTracker;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:schema.sql", "classpath:data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SpendControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {

		spendingTracker s = new spendingTracker(12.99, "Eating Out", "KFC");
		String sAsJSON = this.mapper.writeValueAsString(s);

		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(sAsJSON);

		spendingTracker Saved = new spendingTracker(2L, 12.99, "Eating Out", "KFC");
		String SavedAsJSON = this.mapper.writeValueAsString(Saved);

		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(SavedAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	void testgetAll() throws Exception {

		List<spendingTracker> expected = new ArrayList<>();
		expected.add(new spendingTracker(1L, 12.99, "Eating Out", "KFC"));
		String expAsJSON = this.mapper.writeValueAsString(expected);

		RequestBuilder mockRequest = get("/getAll").contentType(MediaType.APPLICATION_JSON).content(expAsJSON);

		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(expAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}

	@Test
	void testUpdate() throws Exception {
		Long id = 1L;

		spendingTracker amend = new spendingTracker(12.99, "Eating Out", "KFC");

		spendingTracker update = new spendingTracker(id, amend.getAmount(), amend.getType(), amend.getInfo());

		String amendAsJSON = this.mapper.writeValueAsString(amend);

		String updateAsJSON = this.mapper.writeValueAsString(update);

		RequestBuilder mockRequest = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(amendAsJSON);

		ResultMatcher matchStatus = status().isAccepted();
		ResultMatcher matchBody = content().json(updateAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	void testDelete() throws Exception {
		

		RequestBuilder mockRequest = delete("/delete/1");

		ResultMatcher matchStatus = status().isOk();

		this.mockMVC.perform(mockRequest).andExpect(matchStatus);
	
	}}
