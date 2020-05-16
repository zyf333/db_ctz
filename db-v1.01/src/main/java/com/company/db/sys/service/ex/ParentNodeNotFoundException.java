package com.company.db.sys.service.ex;

public class ParentNodeNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5934060056772846650L;

	public ParentNodeNotFoundException() {
		super();
	}

	public ParentNodeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ParentNodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParentNodeNotFoundException(String message) {
		super(message);
	}

	public ParentNodeNotFoundException(Throwable cause) {
		super(cause);
	}

}
