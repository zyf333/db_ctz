package com.company.db.sys.service.ex;

public class EmptyArgumentException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8141173589728129385L;

	public EmptyArgumentException() {
		super();
	}

	public EmptyArgumentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyArgumentException(String message) {
		super(message);
	}

	public EmptyArgumentException(Throwable cause) {
		super(cause);
	}

}
