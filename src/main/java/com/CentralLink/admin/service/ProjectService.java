package com.CentralLink.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Project;
import com.CentralLink.admin.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository categoryRepository;

	public Project createCategory(String categoryName, MultipartFile file) throws IOException {
		byte[] photoBytes = file.getBytes();
		Project category = new Project(categoryName, photoBytes);
		return categoryRepository.save(category);
	}

	public List<Project> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Project> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	public Project updateCategory(Long id, String categoryName, MultipartFile file) throws IOException {
		Project category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		category.setCategoryName(categoryName);
		category.setPhoto(file.getBytes());
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
