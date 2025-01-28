package com.CentralLink.admin.controller.master;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Project;
import com.CentralLink.admin.service.ProjectService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/project")
@Tag(name = "project", description = "APIs for project related operations")
public class ProjectController {

	@Autowired
	private ProjectService categoryService;

	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

	@PostMapping
	public ResponseEntity<Project> createCategory(@RequestParam String categoryName,
			@RequestParam("photo") MultipartFile file) throws IOException {
		Project createdCategory = categoryService.createCategory(categoryName, file);
		return ResponseEntity.ok(createdCategory);
	}

	@GetMapping
	public ResponseEntity<?> getAllCategories() {
		try {
			List<Project> categories = categoryService.getAllCategories();
			if (categories.isEmpty()) {
				log.warn("No categories found.");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No projects found in the database.");
			}
			return ResponseEntity.ok(categories);
		} catch (Exception e) {
			log.error("Error getting all projects: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while fetching the projects: " + e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
		try {
			Optional<Project> category = categoryService.getCategoryById(id);
			if (category.isEmpty()) {
				log.warn("Category with ID {} not found.", id);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project with ID " + id + " not found.");
			}
			return ResponseEntity.ok(category.get());
		} catch (Exception e) {
			log.error("Error fetching project with ID {}: {}", id, e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while fetching the project: " + e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Project> updateCategory(@PathVariable Long id, @RequestParam String categoryName,
			@RequestParam("photo") MultipartFile file) throws IOException {
		Project updatedCategory = categoryService.updateCategory(id, categoryName, file);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
