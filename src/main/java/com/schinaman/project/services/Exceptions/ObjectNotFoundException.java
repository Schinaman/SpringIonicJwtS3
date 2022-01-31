package com.schinaman.project.services.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1128900036875486220L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

