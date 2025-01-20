//package com.CentralLink.admin.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.CentralLink.admin.entity.Blog;
//import com.CentralLink.admin.entity.Category;
//import com.CentralLink.admin.repository.BlogRepository;
//import com.CentralLink.admin.repository.CategoryRepository;
//import com.CentralLink.admin.request.BlogRequest;
//import com.CentralLink.admin.response.BlogResponse;
//
//@Service
//public class BlogService {
//	
//	@Autowired
//    private BlogRepository blogRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    public long createBlog(BlogRequest blogRequest) {
//        Category category = categoryRepository.findById(blogRequest.getCategoryId())
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//
//        Blog blog = new Blog();
//        blog.setTitle(blogRequest.getTitle());
//        blog.setContent(blogRequest.getContent());
//        blog.setImage(blogRequest.getImage());
//        blog.setTags(blogRequest.getTags());
//        blog.setCategory(category);
//        blog.setCreatedAt(LocalDateTime.now());
//        blog.setUpdatedAt(LocalDateTime.now());
//
//        return blogRepository.save(blog).getId();
//    }
//
//    public List<BlogResponse> getAllBlogs() {
//        return blogRepository.findAll()
//                .stream()
//                .map(this::convertToBlogResponse)
//                .collect(Collectors.toList());
//    }
//
//    public List<BlogResponse> getBlogsByCategory(String categoryName) {
//        return blogRepository.findByCategory_Name(categoryName)
//                .stream()
//                .map(this::convertToBlogResponse)
//                .collect(Collectors.toList());
//    }
//
//    public void updateBlog(long id, BlogRequest blogRequest) {
//        Blog blog = blogRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Blog not found"));
//
//        Category category = categoryRepository.findById(blogRequest.getCategoryId())
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//
//        blog.setTitle(blogRequest.getTitle());
//        blog.setContent(blogRequest.getContent());
//        blog.setImage(blogRequest.getImage());
//        blog.setTags(blogRequest.getTags());
//        blog.setCategory(category);
//        blog.setUpdatedAt(LocalDateTime.now());
//
//        blogRepository.save(blog);
//    }
//
//    public void deleteBlog(long id) {
//        blogRepository.deleteById(id);
//    }
//
//    private BlogResponse convertToBlogResponse(Blog blog) {
//        BlogResponse response = new BlogResponse();
//        response.setId(blog.getId());
//        response.setTitle(blog.getTitle());
//        response.setContent(blog.getContent());
//        response.setImage(blog.getImage());
//        response.setTags(blog.getTags());
//        response.setCategoryName(blog.getCategory().getName());
//        response.setCreatedAt(blog.getCreatedAt());
//        response.setUpdatedAt(blog.getUpdatedAt());
//        return response;
//    }
//    
//}
