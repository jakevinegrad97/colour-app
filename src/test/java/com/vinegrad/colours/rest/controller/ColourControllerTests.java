package com.vinegrad.colours.rest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vinegrad.colours.service.ColourService;

import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest(controllers = ColourController.class)
@ContextConfiguration(classes = {ColourController.class})
@ExtendWith(SpringExtension.class)
public class ColourControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ColourService mockColourService;
	
	private Map<String, Long> colourCounts;
	
	@BeforeEach
	public void setUp() {
		colourCounts = Map.of("blue", 3l, "red", 2l);
	}
	
	@Test
	@DisplayName("Given colours, when we query for colours counts, then we expect the colour counts to be returned")
	public void testColoursCountsReturnedForColours() throws Exception {
		when(mockColourService.getColourCounts()).thenReturn(colourCounts);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/colours");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{\"blue\": 3, \"red\": 2}";
		String actual = result.getResponse().getContentAsString();
		JSONAssert.assertEquals(expected, actual, true);
	}
	
	@Test
	@DisplayName("Given no colours, when we query for colours counts, then we expect an empty object")
	public void testEmptyObjectReturnedForNoColours() throws Exception {
		when(mockColourService.getColourCounts()).thenReturn(new HashMap<>());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/colours");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{}";
		String actual = result.getResponse().getContentAsString();
		JSONAssert.assertEquals(expected, actual, true);
	}
}
