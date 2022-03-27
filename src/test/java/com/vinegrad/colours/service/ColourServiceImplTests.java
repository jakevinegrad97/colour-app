package com.vinegrad.colours.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vinegrad.colours.model.Colour;
import com.vinegrad.colours.model.ColourType;
import com.vinegrad.colours.repository.ColourRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
public class ColourServiceImplTests {
	
	@Mock
	private ColourRepository mockRepository;
	
	@InjectMocks
	private ColourServiceImpl colourService;
	
	private Colour blue;
	private List<Colour> colours;
	
	@BeforeEach
	public void setUp() {
		blue = new Colour(ColourType.BLUE);
		colours = List.of(new Colour(ColourType.BLUE), new Colour(ColourType.BLUE),
				new Colour(ColourType.RED), new Colour(ColourType.BLUE), new Colour(ColourType.RED));
	}
	
	@Test
	@DisplayName("Given a valid colour, when we try to insert it then we expect true to be returned")
	public void testInsertColourReturnsTrueForValidColour() {
		when(mockRepository.save(blue)).thenReturn(blue);
		boolean actual = colourService.insertColour("blue");
		assertTrue(actual);
		
	}
	
	@Test
	@DisplayName("Given an invalid colour, when we try to insert it then we expect false to be returned")
	public void testInsertColourReturnsFalseForInvalidColour() {
		boolean actual = colourService.insertColour("invalid");
		assertFalse(actual);
		
	}
	
	@Test
	@DisplayName("Given colours in the DB, when we find colour count then we expect a count of all the colours")
	public void testGetColourCountsReturnsColoursCountsWhenThereAreColours() {
		when(mockRepository.findAll()).thenReturn(colours);
		Map<String, Long> expected = Map.of("blue", 3l, "red", 2l);
		Map<String, Long> actual = colourService.getColourCounts();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Given no colours in the DB, when we find colour count then we expect an empty list")
	public void testGetColourCountsReturnsEmptyMapWhenThereAreNoColours() {
		when(mockRepository.findAll()).thenReturn(new ArrayList<>());
		Map<String, Long> expected = new HashMap<>();
		Map<String, Long> actual = colourService.getColourCounts();
		assertEquals(expected, actual);
	}

}
