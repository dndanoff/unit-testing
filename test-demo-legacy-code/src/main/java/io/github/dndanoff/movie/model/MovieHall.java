package io.github.dndanoff.movie.model;

import java.util.List;

import lombok.Data;

@Data
public class MovieHall {
	private final String name;
	private final List<Seat> seats;
}
