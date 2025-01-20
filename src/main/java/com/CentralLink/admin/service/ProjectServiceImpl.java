//package com.CentralLink.admin.service;
//
//import java.io.IOException;
//import java.util.Base64;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.CentralLink.admin.entity.ProjectEntity;
//import com.CentralLink.admin.entity.ProjectImage;
//import com.CentralLink.admin.repository.ProjectRepository;
//import com.CentralLink.admin.request.ProjectRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Service
//public class ProjectServiceImpl implements ProjectService{
//	
//	@Autowired
//    private ProjectRepository projectRepository;
//	
//
//    @Transactional
//    public ProjectEntity createProject(String title, String description, List<String> images, String testimonials) {
//        ProjectEntity project = new ProjectEntity();
//        project.setTitle(title);
//        project.setDescription(description);
//        project.setTestimonials(testimonials);
//
//        List<ProjectImage> projectImages = images.stream()
//                .map(image -> {
//                    ProjectImage projectImage = new ProjectImage();
//                    projectImage.setImage(image); // Save image as a string
//                    projectImage.setProject(project);
//                    return projectImage;
//                }).collect(Collectors.toList());
//
//        project.setImages(projectImages);
//        return projectRepository.save(project);
//    }
//
//    @Transactional
//    public ProjectEntity updateProject(Long id, String title, String description, List<String> images, String testimonials) {
//        ProjectEntity project = getProjectById(id);
//        if (project != null) {
//            project.setTitle(title);
//            project.setDescription(description);
//            project.setTestimonials(testimonials);
//
//            List<ProjectImage> projectImages = images.stream()
//                    .map(image -> {
//                        ProjectImage projectImage = new ProjectImage();
//                        projectImage.setImage(image); // Save image as a string
//                        projectImage.setProject(project);
//                        return projectImage;
//                    }).collect(Collectors.toList());
//
//            project.setImages(projectImages);
//            return projectRepository.save(project);
//        }
//        return null;
//    }
//
//    public ProjectRequest convertToDTO(ProjectEntity project) {
//        ProjectRequest request = new ProjectRequest();
//        request.setId(project.getId());
//        request.setTitle(project.getTitle());
//        request.setDescription(project.getDescription());
//
//        // Set images as plain strings
//        List<String> imageStrings = project.getImages().stream()
//                .map(ProjectImage::getImage) // Get image string directly
//                .collect(Collectors.toList());
//        request.setImages(imageStrings);
//
//        request.setTestimonials(project.getTestimonials());
//        return request;
//    }
//    
//    @Transactional(readOnly = true)
//    public ProjectEntity getProjectById(Long id) {
//        return projectRepository.findById(id).orElse(null);
//    }
//
//    @Transactional(readOnly = true)
//    public List<ProjectEntity> getAllProjects() {
//        return projectRepository.findAll();
//    }
//
//    @Transactional
//    public boolean deleteProject(Long id) {
//        if (projectRepository.existsById(id)) {
//            projectRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//    
//} 
//    
//    
//    
// 
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//	
//	
//		
//		
//		
//		
//		
//		
//		
//		
//	
//
//	
//	
//	
//	
//
//
