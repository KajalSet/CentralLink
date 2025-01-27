package com.CentralLink.admin.controller.master;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping
	public ResponseEntity<Project> createCategory(@RequestParam String categoryName,
			@RequestParam("photo") MultipartFile file) throws IOException {
		Project createdCategory = categoryService.createCategory(categoryName, file);
		return ResponseEntity.ok(createdCategory);
	}

	@GetMapping
	public List<Project> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Project> getCategoryById(@PathVariable Long id) {
		Optional<Project> category = categoryService.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
