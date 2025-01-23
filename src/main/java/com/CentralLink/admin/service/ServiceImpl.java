package com.CentralLink.admin.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.ServiceEntity;
import com.CentralLink.admin.repository.ServiceRepository;
import com.CentralLink.admin.request.ServiceRequest;

@Service
public class ServiceImpl implements ServiceService {
	@Autowired
    private ServiceRepository serviceRepository;
	
	
	
	
	
	@Override
    public ServiceEntity createService(ServiceRequest serviceRequest) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName(serviceRequest.getName());
        serviceEntity.setDescription(serviceRequest.getDescription());
        serviceEntity.setCategory(serviceRequest.getCategory());
        serviceEntity.setCreatedDate(LocalDateTime.now());
        serviceEntity.setImages(serviceRequest.getImages()); // Set multiple images

        return serviceRepository.save(serviceEntity);
    }

    @Override
    public ServiceEntity updateService(Long id, ServiceRequest serviceRequest) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        serviceEntity.setName(serviceRequest.getName());
        serviceEntity.setDescription(serviceRequest.getDescription());
        serviceEntity.setCategory(serviceRequest.getCategory());
        serviceEntity.setImages(serviceRequest.getImages()); // Update images

        return serviceRepository.save(serviceEntity);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public List<ServiceEntity> getServicesByCategory(String category) {
        return serviceRepository.findByCategory(category);
    }

    @Override
    public ServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }
	
}
