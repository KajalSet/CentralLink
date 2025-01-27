package com.CentralLink.admin.pojo.request;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MPin {
	private UUID userId;
	private String mpin;

}
