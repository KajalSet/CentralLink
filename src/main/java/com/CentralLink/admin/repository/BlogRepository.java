package com.CentralLink.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentralLink.admin.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{
	 List<Blog> findByCategory_Name(String categoryName);

	void deleteById(long id);
}
