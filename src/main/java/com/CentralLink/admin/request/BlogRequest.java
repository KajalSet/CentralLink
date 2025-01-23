package com.CentralLink.admin.request;

import java.util.List;

import lombok.Data;
@Data
public class BlogRequest {
	private String title;
    private String content;
    private String category; 
    private List<String> image;
    private List<String> tags;
}
