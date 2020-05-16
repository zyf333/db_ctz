package com.company.db.sys.service.ex;

public class IllegalPageCurrentNumberException extends ServiceException {

	private static final long serialVersionUID = -8285695186851685806L;

	public IllegalPageCurrentNumberException() {
		super();
	}

	public IllegalPageCurrentNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalPageCurrentNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalPageCurrentNumberException(String message) {
		super(message);
	}

	public IllegalPageCurrentNumberException(Throwable cause) {
		super(cause);
	}

}
