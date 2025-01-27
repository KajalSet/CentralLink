package com.CentralLink.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Category name cannot be empty")
	@Size(max = 255)
	private String categoryName;

	@NotBlank(message = "Title cannot be empty")
	@Size(max = 255)
	private String title;

	@NotBlank(message = "Short description cannot be empty")
	@Size(max = 1000)
	private String shortDescription;

	@NotBlank(message = "Main description cannot be empty")
	@Size(max = 3000) // Around 500 words (3000 characters)
	private String mainDescription;

	@Lob
	private byte[] photo; // For storing the uploaded image

	// Constructors, getters, and setters
	public Blog() {
	}
//
//	public Blog(String categoryName, String title, String shortDescription, String mainDescription, byte[] photo) {
//		this.categoryName = categoryName;
//		this.title = title;
//		this.shortDescription = shortDescription;
//		this.mainDescription = mainDescription;
//		this.photo = photo;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getMainDescription() {
		return mainDescription;
	}

	public void setMainDescription(String mainDescription) {
		this.mainDescription = mainDescription;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
