package com.CentralLink.admin.request;

import java.util.List;

import lombok.Data;
@Data
public class BlogRequest {
	private String title;
    private String content;
    private Long categoryId;  // Category ID instead of category name
    private String image;
    private List<String> tags;
}
