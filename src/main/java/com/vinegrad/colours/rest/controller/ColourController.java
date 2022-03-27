package com.vinegrad.colours.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinegrad.colours.service.ColourService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/colours")
public class ColourController {
	
	private ColourService colourService;
	
	@Autowired
	public ColourController(ColourService colourService) {
		this.colourService = colourService;
	}
	
	@GetMapping
	@Operation(summary = "View a count of each colour")
	public Map<String, Long> getColour() {
		return colourService.getColourCounts();
	}
	
}
