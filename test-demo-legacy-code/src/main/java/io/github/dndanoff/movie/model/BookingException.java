package io.github.dndanoff.movie.model;

public class BookingException extends Exception {

	private final String type;
	
	public BookingException() {
		this(null,null,null);
	}
	
	public BookingException(String message, String type) {
		this(message, null, type);
	}
	
	public BookingException(String message, Throwable error) {
		this(message, error,null);
	}
	
	public BookingException(String message, Throwable error, String type) {
		super(message, error);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
