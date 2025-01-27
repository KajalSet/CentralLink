package com.CentralLink.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
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
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	@Size(max = 255, message = "Name cannot be more than 255 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;

	@ManyToOne
	private Services serviceName;

	@NotBlank(message = "Message is required")
	@Size(max = 5000, message = "Message cannot be more than 1000 words (5000 characters)")
	private String message;

	// Constructors, getters, and setters
	public Inquiry() {
	}

	public Inquiry(Long id,
			@NotBlank(message = "Name is required") @Size(max = 255, message = "Name cannot be more than 255 characters") String name,
			@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email,
			Services services,
			@NotBlank(message = "Message is required") @Size(max = 5000, message = "Message cannot be more than 1000 words (5000 characters)") String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.serviceName = serviceName;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Services getServiceName() {
		return serviceName;
	}

	public void setServiceName(Services serviceName) {
		this.serviceName = serviceName;
	}

}
