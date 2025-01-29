package com.CentralLink.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Inquiry;
import com.CentralLink.admin.entity.Services;
import com.CentralLink.admin.exception.GenericException;
import com.CentralLink.admin.repository.InquiryRepository;
import com.CentralLink.admin.repository.ServiceRepository;

@Service
public class ServicesService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private InquiryRepository inquiryRepository;

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
		Optional<Services> service = serviceRepository.findById(id);
		if (service.isPresent()) {
			// First, delete related Inquiries
			List<Inquiry> inquiries = inquiryRepository.findByServiceName(service.get());
			for (Inquiry inquiry : inquiries) {
				inquiryRepository.delete(inquiry);
			}

			// Now delete the Service
			serviceRepository.deleteById(id);
		} else {
			throw new GenericException("Service not found with id: " + id);
		}
	}

}
