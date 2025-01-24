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
    private String category;
    private List<String> images; 
    private String testimonials;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public String getTestimonials() {
		return testimonials;
	}
	public void setTestimonials(String testimonials) {
		this.testimonials = testimonials;
	}
    
    
    
}
