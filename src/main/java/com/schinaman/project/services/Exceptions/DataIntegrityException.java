package com.schinaman.project.services.Exceptions;

public class DataIntegrityException extends RuntimeException{
	private static final long serialVersionUID = 1128900036875486220L;

	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

