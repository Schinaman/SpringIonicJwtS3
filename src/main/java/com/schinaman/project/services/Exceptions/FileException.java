package com.schinaman.project.services.Exceptions;

public class FileException extends RuntimeException{
	private static final long serialVersionUID = 1128900036875486230L;

	public FileException(String msg) {
		super(msg);
	}

	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

