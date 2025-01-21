package com.CentralLink.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralLink.admin.request.BlogRequest;
import com.CentralLink.admin.request.CategoryRequest;
import com.CentralLink.admin.response.BlogResponse;
import com.CentralLink.admin.response.CategoryResponse;
import com.CentralLink.admin.service.BlogService;
import com.CentralLink.admin.service.CategoryService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	 @Autowired
	    private BlogService blogService;

	    @Autowired
	    private CategoryService categoryService;

	    @PostMapping("/create")
	    public ResponseEntity<Map<String, String>> createBlog(@RequestBody BlogRequest blogRequest) {
	        long blogId = blogService.createBlog(blogRequest);
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Blog created successfully");
	        response.put("blogId", String.valueOf(blogId));
	        return ResponseEntity.status(201).body(response);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<BlogResponse>> getAllBlogs() {
	        return ResponseEntity.ok(blogService.getAllBlogs());
	    }

	    @GetMapping("/category/{categoryName}")
	    public ResponseEntity<List<BlogResponse>> getBlogsByCategory(@PathVariable String categoryName) {
	        return ResponseEntity.ok(blogService.getBlogsByCategory(categoryName));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Map<String, String>> updateBlog(@PathVariable long id, @RequestBody BlogRequest blogRequest) {
	        blogService.updateBlog(id, blogRequest);
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Blog updated successfully");
	        return ResponseEntity.ok(response);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Map<String, String>> deleteBlog(@PathVariable long id) {
	        blogService.deleteBlog(id);
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Blog deleted successfully");
	        return ResponseEntity.ok(response);
	    }

	    @PostMapping("/categories")
	    public ResponseEntity<Map<String, String>> createCategory(@RequestBody CategoryRequest categoryRequest) {
	        long categoryId = categoryService.createCategory(categoryRequest);
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Category created successfully");
	        response.put("categoryId", String.valueOf(categoryId));
	        return ResponseEntity.status(201).body(response);
	    }

	    @GetMapping("/categories")
	    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
	        return ResponseEntity.ok(categoryService.getAllCategories());
	    }
}
