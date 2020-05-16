package com.company.db.sys.service.ex;

public class UsernameExistsException extends ServiceException {

	private static final long serialVersionUID = -1684248683497774567L;

	public UsernameExistsException() {
		super();
	}

	public UsernameExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameExistsException(String message) {
		super(message);
	}

	public UsernameExistsException(Throwable cause) {
		super(cause);
	}

}
