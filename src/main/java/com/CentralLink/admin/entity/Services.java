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
import lombok.Setter;

@Getter
@Setter

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title cannot be empty")
	@Size(max = 255)
	private String title;

	@Lob
	private byte[] icon; // For storing the uploaded icon image

	@NotBlank(message = "Short description cannot be empty")
	@Size(max = 1000) // Adjusting to ~200 words (~1000 characters)
	private String shortDescription;

	@NotBlank(message = "Main description cannot be empty")
	@Size(max = 3000) // Adjusting to ~500 words (~3000 characters)
	private String mainDescription;

	@Lob
	private byte[] photo; // For storing the uploaded photo

	// Constructors, getters, and setters
	public Services() {
	}

	public Services(String title, byte[] icon, String shortDescription, String mainDescription, byte[] photo) {
		this.title = title;
		this.icon = icon;
		this.shortDescription = shortDescription;
		this.mainDescription = mainDescription;
		this.photo = photo;
	}

	// Getters and Setters
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

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
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
