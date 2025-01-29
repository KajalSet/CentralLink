package com.CentralLink.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Blog;
import com.CentralLink.admin.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public Blog createBlog(String categoryName, String title, String shortDescription, String mainDescription,
			MultipartFile photo) throws IOException {
		byte[] photoBytes = photo.getBytes();

// Create and populate the Blog object
		Blog blog = new Blog();
		blog.setCategoryName(categoryName);
		blog.setTitle(title);
		blog.setShortDescription(shortDescription);
		blog.setMainDescription(mainDescription);
		blog.setPhoto(photoBytes); // assuming you have a field of type byte[] for photo

// Save the Blog object
		return blogRepository.save(blog);
	}

	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	public Optional<Blog> getBlogById(Long id) {
		return blogRepository.findById(id);
	}

	public Blog updateBlog(Long id, String categoryName, String title, String shortDescription, String mainDescription,
			MultipartFile photo) throws IOException {
		Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
		blog.setCategoryName(categoryName);
		blog.setTitle(title);
		blog.setShortDescription(shortDescription);
		blog.setMainDescription(mainDescription);
		if (photo != null && !photo.isEmpty()) {
			blog.setPhoto(photo.getBytes());
		}
		return blogRepository.save(blog);
	}

	public void deleteBlog(Long id) {
		blogRepository.deleteById(id);
	}
}
