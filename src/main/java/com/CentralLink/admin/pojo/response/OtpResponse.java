package com.CentralLink.admin.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OtpResponse {
	String type;
	String message;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
