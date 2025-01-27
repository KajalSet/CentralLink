package com.CentralLink.admin.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponse {
	boolean status = false;
	String message = "";
	boolean isProfileExists = false;
	boolean isMPINExists = false;

}
