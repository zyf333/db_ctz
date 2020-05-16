package com.company.db.sys.service.ex;

public class EmptyIdException extends ServiceException {

	private static final long serialVersionUID = -1684248683497774567L;

	public EmptyIdException() {
		super();
	}

	public EmptyIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyIdException(String message) {
		super(message);
	}

	public EmptyIdException(Throwable cause) {
		super(cause);
	}

}
