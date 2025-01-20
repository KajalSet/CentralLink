//package com.CentralLink.admin.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.CentralLink.admin.entity.ProjectEntity;
//import com.CentralLink.admin.request.ProjectRequest;
//import com.CentralLink.admin.service.ProjectService;
//
//
//
//@RestController
//@RequestMapping("/api/projects")
//public class ProjectController {
//	@Autowired
//    private ProjectService projectService;
//	
//	@PostMapping("/create")
//    public ResponseEntity<ProjectEntity> createProject(
//            @RequestParam String title,
//            @RequestParam String description,
//            @RequestParam List<String> images, // Normal strings for images
//            @RequestParam String testimonials) {
//
//        ProjectEntity project = projectService.createProject(title, description, images, testimonials);
//        if (project != null) {
//            return new ResponseEntity<>(project, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//	
//}
//	
//	 @PutMapping("/update/{id}")
//	    public ResponseEntity<ProjectEntity> updateProject(
//	            @PathVariable Long id,
//	            @RequestParam String title,
//	            @RequestParam String description,
//	            @RequestParam List<String> images, // Normal strings for images
//	            @RequestParam String testimonials) {
//
//	        ProjectEntity updatedProject = projectService.updateProject(id, title, description, images, testimonials);
//	        if (updatedProject != null) {
//	            return new ResponseEntity<>(updatedProject, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }	
//	
//	 @GetMapping("/{id}")
//	 public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Long id) {
//	     ProjectEntity project = projectService.getProjectById(id);
//	     if (project != null) {
//	         return new ResponseEntity<>(project, HttpStatus.OK);
//	     } else {
//	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	     }
//	 }
//	 
//	 @GetMapping("/all")
//	 public ResponseEntity<List<ProjectEntity>> getAllProjects() {
//		    List<ProjectEntity> projects = projectService.getAllProjects();
//		    if (!projects.isEmpty()) {
//		        return new ResponseEntity<>(projects, HttpStatus.OK);
//		    } else {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		    }
//		}
//	 
//	 @DeleteMapping("/delete/{id}")
//	 public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
//	     boolean isDeleted = projectService.deleteProject(id);
//	     if (isDeleted) {
//	         return new ResponseEntity<>(HttpStatus.OK);
//	     } else {
//	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	     }
//	 }
//}
//	
//	
