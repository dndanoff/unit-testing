package io.github.dndanoff.movie.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.github.dndanoff.movie.model.BookingException;
import io.github.dndanoff.movie.model.ErrorType;
import io.github.dndanoff.movie.model.Movie;
import io.github.dndanoff.movie.model.MovieHall;
import io.github.dndanoff.movie.model.Seat;
import io.github.dndanoff.movie.model.ShowTime;

public class MovieDao {
	
	public MovieHall findMovie(Movie movie, ShowTime time) {
		if(movie == null || movie.getTitle() == null || time == null || time.getValue() == null) {
			return null;
		}
		return DB.movies.get(movie.getTitle()+"_"+time.getValue());
	}

	public List<String> getAvilableSeats(Movie movie, ShowTime time) {
		MovieHall hall = DB.movies.get(movie.getTitle()+"_"+time.getValue());
		if(hall == null) {
			return null;
		}
		
		return hall.getSeats().stream()
				.filter(s -> !s.isOccupied())
				.map(Seat::getNumber)
				.collect(Collectors.toList());
	}

	public void book(Movie movie, ShowTime time, String aSeat) throws BookingException{
		MovieHall hall = DB.movies.get(movie.getTitle()+"_"+time.getValue());
		if(hall == null) {
			return;
		}
		
		Optional<Seat> seatOpt = hall.getSeats().stream().filter(s -> !s.isOccupied() && s.getNumber().equals(aSeat)).findFirst();
		seatOpt.orElseThrow(() -> new BookingException("Cannot book seat: "+aSeat, ErrorType.SEAT_ALREADY_BOOKED)).setOccupied(true);
	}

	private static final class DB {
		private static final Map<String, MovieHall> movies = new HashMap<>();
		static {
			movies.put("Evening_LOTR", new MovieHall("SCREEN 1", Arrays.asList(new Seat("A1"),
					new Seat("A2"),
					new Seat("A3"),
					new Seat("B1"),
					new Seat("B2"),
					new Seat("C1"))));
			
			movies.put("Morning_Ice Age 3", new MovieHall("SCREEN 1", Arrays.asList(new Seat("A1"),
					new Seat("A2"),
					new Seat("A3"),
					new Seat("B1"),
					new Seat("B2"),
					new Seat("C1"))));
		}
	}
	
}
