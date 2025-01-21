package com.CentralLink.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.ProjectEntity;
import com.CentralLink.admin.request.ProjectRequest;
import com.CentralLink.admin.service.ProjectService;



@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
    private ProjectService projectService;
	
	@PostMapping("/create")
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectRequest request) {
        ProjectEntity project = projectService.createProject(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }
	
	@GetMapping("/category/{category}")
    public ResponseEntity<List<ProjectEntity>> getProjectsByCategory(@PathVariable String category) {
        List<ProjectEntity> projects = projectService.getProjectsByCategory(category);
        return ResponseEntity.ok(projects);
    }
	

	 @PutMapping("/update/{id}")
	    public ResponseEntity<ProjectEntity> updateProject(
	            @PathVariable Long id, @RequestBody ProjectRequest request) {
	        ProjectEntity updatedProject = projectService.updateProject(id, request);
	        if (updatedProject != null) {
	            return ResponseEntity.ok(updatedProject);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        boolean deleted = projectService.deleteProject(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Long id) {
        ProjectEntity project = projectService.getProjectById(id);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
	
	
