package com.schinaman.project.services.Exceptions;

public class AuthorizationException extends RuntimeException{
	private static final long serialVersionUID = 1128900036875486224L;

	public AuthorizationException(String msg) {
		super(msg);
	}

	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

