package com.exception.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private String msg;
	private String description;
	private LocalDateTime dateTime;

	public ErrorDetails(String msg, String description, LocalDateTime dateTime) {
		super();
		this.msg = msg;
		this.description = description;
		this.dateTime = dateTime;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "ErrorDetails [msg=" + msg + ", description=" + description + ", dateTime=" + dateTime + "]";
	}
}
