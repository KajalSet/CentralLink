package com.CentralLink.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Services;
import com.CentralLink.admin.repository.ServiceRepository;

@Service
public class ServicesService {

	@Autowired
	private ServiceRepository serviceRepository;

	public Services createService(String title, MultipartFile icon, String shortDescription, String mainDescription,
			MultipartFile photo) throws IOException {
		byte[] iconBytes = icon.getBytes();
		byte[] photoBytes = photo.getBytes();
		Services service = new Services(title, iconBytes, shortDescription, mainDescription, photoBytes);
		return serviceRepository.save(service);
	}

	public List<Services> getAllServices() {
		return serviceRepository.findAll();
	}

	public Optional<Services> getServiceById(Long id) {
		return serviceRepository.findById(id);
	}

	public Services updateService(Long id, String title, MultipartFile icon, String shortDescription,
			String mainDescription, MultipartFile photo) throws IOException {
		Services service = serviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
		service.setTitle(title);
		service.setIcon(icon.getBytes());
		service.setShortDescription(shortDescription);
		service.setMainDescription(mainDescription);
		service.setPhoto(photo.getBytes());
		return serviceRepository.save(service);
	}

	public void deleteService(Long id) {
		serviceRepository.deleteById(id);
	}
}
