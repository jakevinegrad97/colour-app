package com.vinegrad.colours.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "colour")
public class Colour {
	
	@Id
	private UUID colourId;
	private ColourType colourType;
	
	public Colour(ColourType colourType) {
		this.colourType = colourType;
		this.colourId = UUID.randomUUID();
	}
	
	public ColourType getColourType() {
		return colourType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colourType == null) ? 0 : colourType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colour other = (Colour) obj;
		if (colourType != other.colourType)
			return false;
		return true;
	}
	
}
