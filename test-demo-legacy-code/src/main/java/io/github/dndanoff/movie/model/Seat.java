package io.github.dndanoff.movie.model;

import lombok.Data;

@Data
public class Seat {
	private final String number;
	private boolean occupied;
	
	public Seat(String number) {
		this(number, false);
	}
	
	public Seat(String number, boolean occupied) {
		this.number = number;
		this.occupied = occupied;
	}
}
