package br.com.p8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundStorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FileNotFoundStorageException(String exception) {
		super(exception);
	}
	
	public FileNotFoundStorageException(String exception,Throwable cause) {
		super(exception,cause);
	}
}
