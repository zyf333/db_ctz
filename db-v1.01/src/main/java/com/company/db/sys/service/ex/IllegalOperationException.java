package com.company.db.sys.service.ex;

public class IllegalOperationException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5616805123052050061L;

	public IllegalOperationException() {
		super();
	}

	public IllegalOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalOperationException(String message) {
		super(message);
	}

	public IllegalOperationException(Throwable cause) {
		super(cause);
	}

}
