package com.vinegrad.colours.service;

import java.util.Map;

import com.vinegrad.colours.model.Colour;

public interface ColourService {

	boolean insertColour(String colour);
	
	Map<String, Long> getColourCounts();
	
}
