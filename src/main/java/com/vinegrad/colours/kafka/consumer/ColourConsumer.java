package com.vinegrad.colours.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.vinegrad.colours.service.ColourService;

@Component
public class ColourConsumer {
	
	private ColourService colourService;
	
	@Autowired
	public ColourConsumer(ColourService colourService) {
		this.colourService = colourService;
	}
	
	@KafkaListener(topics = "colours", groupId = "colours-consumer")
	public void consumeColours(String colour) {
		colourService.insertColour(colour);
	}

}
