package com.vinegrad.colours.service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vinegrad.colours.model.Colour;
import com.vinegrad.colours.model.ColourType;
import com.vinegrad.colours.repository.ColourRepository;

@Service
public class ColourServiceImpl implements ColourService {
	
	private ColourRepository colourRepository;
	private final Logger logger;
	
	@Autowired
	public ColourServiceImpl(ColourRepository colourRepository) {
		this.colourRepository = colourRepository;
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@Override
	public boolean insertColour(String colour) {
		try {
			ColourType colourType = ColourType.valueOf(colour.toUpperCase());
			colourRepository.save(new Colour(colourType));
			logger.info("Successfully persisted colour {}", colour);
			return true;
		} catch(IllegalArgumentException e) {
			logger.error("Invalid Colour Type {} ", colour);
			return false;
		}
	}

	@Override
	@Cacheable(value = "colour-counts", unless = "#result==null or #result.size()==0")
	public Map<String, Long> getColourCounts() {
		return colourRepository.findAll().stream()
				.map(Colour::getColourType)
				.map(ColourType::toString)
				.map(String::toLowerCase)
				.collect(
						Collectors.groupingBy(
								Function.identity(),
								Collectors.counting()
							)
				);
	}

}
