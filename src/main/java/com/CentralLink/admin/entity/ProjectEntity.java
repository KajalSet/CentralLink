package com.CentralLink.admin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ProjectEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 
    private String title;
	  
	 
    private String description;
    
    private String category;
	
    @ElementCollection // Allows storing a list of strings directly
    private List<String> images;

	   
	    private String testimonials;


		

		
	    
    
}
