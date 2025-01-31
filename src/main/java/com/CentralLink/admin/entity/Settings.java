package com.CentralLink.admin.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
public class Settings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email(message = "Enquiry email should be a valid email address")
	@NotBlank(message = "Enquiry email is required")
	private String enquiryEmail;

//	@Size(max = 255, message = "Facebook URL cannot be more than 255 characters")
//	@Pattern(regexp = "^(https?://)?(www\\.)?facebook\\.com/.+$", message = "Invalid Facebook URL format")
	private String facebookUrl;

	//@Size(max = 255, message = "Instagram URL cannot be more than 255 characters")
	//@Pattern(regexp = "^(https?://)?(www\\.)?instagram\\.com/.+$", message = "Invalid Instagram URL format")
	private String instagramUrl;

	@Size(max = 255, message = "LinkedIn URL cannot be more than 255 characters")
	//@Pattern(regexp = "^(https?://)?(www\\.)?linkedin\\.com/.+$", message = "Invalid LinkedIn URL format")
	private String linkedinUrl;

	// Constructors
//	public Settings(String enquiryEmail, String facebookUrl, String instagramUrl, String linkedinUrl) {
//		this.enquiryEmail = enquiryEmail;
//		this.facebookUrl = facebookUrl;
//		this.instagramUrl = instagramUrl;
//		this.linkedinUrl = linkedinUrl;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnquiryEmail() {
		return enquiryEmail;
	}

	public void setEnquiryEmail(String enquiryEmail) {
		this.enquiryEmail = enquiryEmail;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	
}
