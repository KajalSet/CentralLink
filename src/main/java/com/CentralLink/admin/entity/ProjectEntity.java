package com.CentralLink.admin.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.CentralLink.admin.auth.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class ProjectEntity extends BaseEntity {

	private String title;

	private String description;

	private String category;

	@ElementCollection // Allows storing a list of strings directly
	private List<String> images;

	private String testimonials;

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
