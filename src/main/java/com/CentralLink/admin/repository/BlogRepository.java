package com.CentralLink.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
