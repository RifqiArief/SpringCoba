package co.id.latihan.backend.rest;

import co.id.latihan.backend.constant.Constant;

public class BaseResponse {
	private String status;
	private String message;
	
	public BaseResponse() {
		makeSuccess("");
	}
	
	public void makeSuccess(String msg) {
		this.status = Constant.SCS_MESSAGE;
		this.message = msg;
	}

	public void makeError(String msg) {
		this.status = Constant.ERR_MESSAGE;
		this.message = msg;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
