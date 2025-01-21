package com.CentralLink.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.ProjectEntity;
import com.CentralLink.admin.request.ProjectRequest;

public interface ProjectService {

	

	

	List<ProjectEntity> getAllProjects();

	boolean deleteProject(Long id);

	ProjectEntity getProjectById(Long id);

	ProjectEntity createProject(ProjectRequest request);

	List<ProjectEntity> getProjectsByCategory(String category);

	ProjectEntity updateProject(Long id, ProjectRequest request);

	

	

//	List<ProjectEntity> getAllProjects();
//
//	Optional<ProjectEntity> getProjectById(Long id);

}
