package com.CentralLink.admin.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class BlogResponse {
	private Long id;
    private String title;
    private String content;
    private String image;
    private List<String> tags;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
