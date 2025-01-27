package com.CentralLink.admin.pojo.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PasswordRequest {
	private String oldPassword;

	private String token;

	private String newPassword;

}
