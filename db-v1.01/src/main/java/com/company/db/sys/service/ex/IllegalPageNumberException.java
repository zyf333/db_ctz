package com.company.db.sys.service.ex;

public class IllegalPageNumberException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8141173589728129385L;

	public IllegalPageNumberException() {
		super();
	}

	public IllegalPageNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalPageNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalPageNumberException(String message) {
		super(message);
	}

	public IllegalPageNumberException(Throwable cause) {
		super(cause);
	}

}
