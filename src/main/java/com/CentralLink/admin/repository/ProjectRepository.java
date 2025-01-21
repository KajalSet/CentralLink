package com.CentralLink.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.entity.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{
	 @Query("SELECT p FROM ProjectEntity p LEFT JOIN FETCH p.images WHERE p.id = :id")
	    Optional<ProjectEntity> findByIdWithImages(@Param("id") Long id);

	List<ProjectEntity> findByCategory(String category);
}
