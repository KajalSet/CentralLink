package com.CentralLink.admin.request;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProjectRequest {
	private Long id;
    private String title;
    private String description;
    private List<String> images; 
    private String testimonials;
}
