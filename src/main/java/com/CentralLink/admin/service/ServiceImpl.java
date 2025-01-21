package com.CentralLink.admin.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.ServiceEntity;
import com.CentralLink.admin.repository.ServiceRepository;

@Service
public class ServiceImpl implements ServiceService {
	@Autowired
    private ServiceRepository serviceRepository;
	public ServiceEntity createService(String name, String description, String category, String imageFile) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName(name);
        serviceEntity.setDescription(description);
        serviceEntity.setCategory(category);
        serviceEntity.setCreatedDate(LocalDateTime.now());

        
        serviceEntity.setImageUrl(imageFile);

        return serviceRepository.save(serviceEntity);
    }

    public ServiceEntity updateService(Long id, String name, String description, String category, String imageFile) {
        ServiceEntity serviceEntity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        serviceEntity.setName(name);
        serviceEntity.setDescription(description);
        serviceEntity.setCategory(category);

        
        if (imageFile != null && !imageFile.isEmpty()) {
            serviceEntity.setImageUrl(imageFile);
        }

        return serviceRepository.save(serviceEntity);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<ServiceEntity> getServicesByCategory(String category) {
        return serviceRepository.findByCategory(category);
    }

    public ServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }
	
}
