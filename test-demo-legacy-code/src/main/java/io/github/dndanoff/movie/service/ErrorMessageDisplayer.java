package io.github.dndanoff.movie.service;

public interface ErrorMessageDisplayer {
	
	void showMessage(String title, String message, int messageType);

	boolean showConfirmMessage(String title, String message);
}
