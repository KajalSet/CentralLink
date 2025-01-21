package com.CentralLink.admin.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.ProjectEntity;

import com.CentralLink.admin.repository.ProjectRepository;
import com.CentralLink.admin.request.ProjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
    private ProjectRepository projectRepository;
	

	@Transactional
    public ProjectEntity createProject(ProjectRequest request) {
        ProjectEntity project = new ProjectEntity();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setCategory(request.getCategory()); // Set category
        project.setImages(request.getImages());
        project.setTestimonials(request.getTestimonials());

     

        return projectRepository.save(project);
    }
	
	@Transactional(readOnly = true)
    public List<ProjectEntity> getProjectsByCategory(String category) {
        return projectRepository.findByCategory(category);
    }
	
	@Transactional
    public ProjectEntity updateProject(Long id, ProjectRequest request) {
        ProjectEntity existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject != null) {
            existingProject.setTitle(request.getTitle());
            existingProject.setDescription(request.getDescription());
            existingProject.setCategory(request.getCategory());
            existingProject.setTestimonials(request.getTestimonials());

            existingProject.setImages(request.getImages());
            return projectRepository.save(existingProject);
        }
        return null;
    }
    

    @Transactional(readOnly = true)
    public ProjectEntity getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    @Transactional
    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
} 
    
    
    
 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
		
		
		
		
		
		
		
		
	

	
	
	
	


