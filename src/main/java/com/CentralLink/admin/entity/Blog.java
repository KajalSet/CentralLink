package com.CentralLink.admin.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Blog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
  
    private String image;

    @ElementCollection
    private List<String> tags;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
