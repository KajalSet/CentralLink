package com.CentralLink.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.ServiceEntity;
@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long>{
	List<ServiceEntity> findByCategory(String category);
	
}
