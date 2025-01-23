package com.CentralLink.admin.request;

import java.util.List;

import lombok.Data;

@Data
public class ServiceRequest {
	private String name;
    private String description;
    private String category;
    private List<String> images;
}
