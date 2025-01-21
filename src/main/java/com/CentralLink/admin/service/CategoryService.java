package com.CentralLink.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.Category;
import com.CentralLink.admin.repository.CategoryRepository;
import com.CentralLink.admin.request.CategoryRequest;
import com.CentralLink.admin.response.CategoryResponse;

@Service
public class CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;

    public long createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category).getId();
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    CategoryResponse response = new CategoryResponse();
                    response.setId(category.getId());
                    response.setName(category.getName());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
