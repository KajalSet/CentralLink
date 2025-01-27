package com.CentralLink.admin.controller.master;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Blog;
import com.CentralLink.admin.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping
	public ResponseEntity<Blog> createBlog(@RequestParam String categoryName, @RequestParam String title,
			@RequestParam String shortDescription, @RequestParam String mainDescription,
			@RequestParam("photo") MultipartFile photo) throws IOException {
		Blog createdBlog = blogService.createBlog(categoryName, title, shortDescription, mainDescription, photo);
		return ResponseEntity.ok(createdBlog);
	}

	@GetMapping
	public List<Blog> getAllBlogs() {
		return blogService.getAllBlogs();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
		Optional<Blog> blog = blogService.getBlogById(id);
		return blog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestParam String categoryName,
			@RequestParam String title, @RequestParam String shortDescription, @RequestParam String mainDescription,
			@RequestParam(value = "photo", required = false) MultipartFile photo) throws IOException {
		Blog updatedBlog = blogService.updateBlog(id, categoryName, title, shortDescription, mainDescription, photo);
		return ResponseEntity.ok(updatedBlog);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
		blogService.deleteBlog(id);
		return ResponseEntity.noContent().build();
	}
}
