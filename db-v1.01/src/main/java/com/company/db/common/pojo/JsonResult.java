package com.company.db.common.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JsonResult<T> {

	private Integer state;
	private String message;
	private T data;

	private static Integer successState = 20;
	private static String successMessage = "OK";

	public static JsonResult<Void> getSuccessJR() {
		return new JsonResult<Void>(successState, successMessage, null);
	}

	public static <E> JsonResult<E> getSuccessJR(E data) {
		return new JsonResult<E>(successState, successMessage, data);
	}

	public JsonResult() {
	}

	public JsonResult(Integer state, String message, T data) {
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
