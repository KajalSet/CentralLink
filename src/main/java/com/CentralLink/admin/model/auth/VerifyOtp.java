package com.CentralLink.admin.model.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyOtp {
	private String mobileNumber;
	private int otp;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

}
