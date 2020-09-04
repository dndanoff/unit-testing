package io.github.dndanoff.movie.service;

import java.util.List;

import javax.swing.JOptionPane;

import io.github.dndanoff.movie.model.BookingException;
import io.github.dndanoff.movie.model.ErrorType;
import io.github.dndanoff.movie.model.Movie;
import io.github.dndanoff.movie.model.MovieHall;
import io.github.dndanoff.movie.model.ShowTime;
import io.github.dndanoff.movie.repository.MovieDao;

public class MovieTicketPro {

	public void book(Movie movie, ShowTime time, int noOfTickets) {
		MovieDao dao = getMovieDao();
		MovieHall hall = dao.findMovie(movie, time);
		if (hall != null) {
			List<String> seats = dao.getAvilableSeats(movie, time);
			if (seats.size() < noOfTickets) {
				getErrorMessageDisplayer().showMessage("Booking message", "Ticket is not available",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int booked = 0;
			String bookedSeats = "";
			for (String aSeat : seats) {
				try {
					dao.book(movie, time, aSeat);
					bookedSeats += " " + aSeat;
					booked++;
					if (booked == noOfTickets) {
						getErrorMessageDisplayer().showMessage("Booking Info",
								"Following tickets" + bookedSeats + " Booked", JOptionPane.ERROR_MESSAGE);
						break;
					}
				} catch (BookingException e) {
					if (ErrorType.SEAT_ALREADY_BOOKED.equals(e.getType())) {
						boolean yes = getErrorMessageDisplayer().showConfirmMessage("Booking message",
								"Adjacent seats not available. Can I book any other seat?");
						if (yes) {
							getErrorMessageDisplayer().showMessage("Booking information",
									"Going to auto allocate seats.", JOptionPane.INFORMATION_MESSAGE);
							continue;
						}
						break;
					}
				} catch (Exception e) {
					getErrorMessageDisplayer().showMessage("Booking Error", "Could not book ticket",
							JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
		} else {
			getErrorMessageDisplayer().showMessage("Booking message", "Movie or showtime not available",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	ErrorMessageDisplayer getErrorMessageDisplayer() {
		return new BookingErrorController();
	}

	MovieDao getMovieDao() {
		return new MovieDao();
	}
}
