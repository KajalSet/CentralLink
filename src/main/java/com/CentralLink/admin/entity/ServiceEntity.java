package com.CentralLink.admin.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class ServiceEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String category;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl; // This will store the image as a normal string (e.g., file name)

    private LocalDateTime createdDate;
}
