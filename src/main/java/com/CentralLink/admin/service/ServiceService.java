package com.CentralLink.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.ServiceEntity;
import com.CentralLink.admin.request.ServiceRequest;

public interface ServiceService {

	
	ServiceEntity createService(ServiceRequest serviceRequest);

	ServiceEntity updateService(Long id, ServiceRequest serviceRequest);

	void deleteService(Long id);

	List<ServiceEntity> getAllServices();

	List<ServiceEntity> getServicesByCategory(String category);

	ServiceEntity getServiceById(Long id);

	

}
