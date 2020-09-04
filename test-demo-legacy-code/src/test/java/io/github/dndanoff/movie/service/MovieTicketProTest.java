package io.github.dndanoff.movie.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.github.dndanoff.movie.model.BookingException;
import io.github.dndanoff.movie.model.Movie;
import io.github.dndanoff.movie.model.MovieHall;
import io.github.dndanoff.movie.model.Seat;
import io.github.dndanoff.movie.model.ShowTime;
import io.github.dndanoff.movie.repository.MovieDao;

@RunWith(MockitoJUnitRunner.class)
public class MovieTicketProTest {

	@Mock
	ErrorMessageDisplayer messageDisplayer;

	@Mock
	MovieDao movieDao;

	MovieTicketPro objUnderTest;

	@Before
	public void setup() {
		objUnderTest = new MovieTicketPro() {
			ErrorMessageDisplayer getErrorMessageDisplayer() {
				return messageDisplayer;
			}

			MovieDao getMovieDao() {
				return movieDao;
			}
		};
	}

	@Test
	public void sanity() throws Exception {
		objUnderTest.book(null, null, 1);
	}

	@Test
	public void book_should_shows_error_message_when_invalid_movie() {
		objUnderTest.book(null, null, 1);
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(messageDisplayer).showMessage(stringArgCaptor.capture(), stringArgCaptor.capture(),
				intArgCaptor.capture());
		assertEquals("Movie or showtime not available", stringArgCaptor.getAllValues().get(1));
	}

	@Test
	public void book_should_show_eror_when_not_enough_seats() {
		Movie movie = new Movie("LOTR");
		ShowTime eveningShowtime = new ShowTime("20:00");
		MovieHall moviewHallWithoutSeats = new MovieHall("SCREEN_1", Arrays.asList(new Seat("A1", true),
																					new Seat("A2", true)));
		List<String> emptySeatNumbers = new ArrayList<>();
		when(movieDao.findMovie(any(Movie.class), any(ShowTime.class))).thenReturn(moviewHallWithoutSeats);
		when(movieDao.getAvilableSeats(any(Movie.class), any(ShowTime.class))).thenReturn(emptySeatNumbers);
		
		objUnderTest.book(movie, eveningShowtime, 1);
		
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(messageDisplayer).showMessage(stringArgCaptor.capture(), stringArgCaptor.capture(),
				intArgCaptor.capture());
		assertEquals("Ticket is not available", stringArgCaptor.getAllValues().get(1));
	}
	
	@Test
	public void book_should_book_requested_seats_when_seats_are_Free() throws BookingException {
		Movie movie = new Movie("LOTR");
		ShowTime eveningShowtime = new ShowTime("20:00");
		MovieHall moviewHallWithoutSeats = new MovieHall("SCREEN_1", Arrays.asList(new Seat("A1", false),
																					new Seat("A2", true)));
		List<String> emptySeatNumbers = Arrays.asList("A1");
		when(movieDao.findMovie(any(Movie.class), any(ShowTime.class))).thenReturn(moviewHallWithoutSeats);
		when(movieDao.getAvilableSeats(any(Movie.class), any(ShowTime.class))).thenReturn(emptySeatNumbers);
		
		objUnderTest.book(movie, eveningShowtime, 1);
		
		verify(movieDao).book(argThat((Movie m) -> m.getTitle().equals(movie.getTitle())), any(ShowTime.class), eq("A1"));
	}
}
