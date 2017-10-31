package com.pratikjarandeprojects.bowling.exceptions;

public class DigitRequiredException extends Exception {	
	private static final long serialVersionUID = -8542717359997231132L;

	public DigitRequiredException() {
		super();
	}

	public DigitRequiredException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DigitRequiredException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DigitRequiredException(String arg0) {
		super(arg0);
	}

	public DigitRequiredException(Throwable arg0) {
		super(arg0);
	}

}
