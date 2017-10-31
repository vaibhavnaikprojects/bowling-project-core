package com.pratikjarandeprojects.bowling.exceptions;

public class ServicesNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServicesNotFoundException() {
		super();
	}

	public ServicesNotFoundException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ServicesNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ServicesNotFoundException(String arg0) {
		super(arg0);
	}

	public ServicesNotFoundException(Throwable arg0) {
		super(arg0);
	}
}
