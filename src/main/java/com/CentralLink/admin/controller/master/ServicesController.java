package com.CentralLink.admin.controller.master;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CentralLink.admin.entity.Services;
import com.CentralLink.admin.service.ServicesService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/services")
@Tag(name = "services", description = "APIs for service related operations")
public class ServicesController {

	@Autowired
	private ServicesService serviceService;

	@PostMapping
	public ResponseEntity<Services> createService(@RequestParam String title, @RequestParam("icon") MultipartFile icon,
			@RequestParam String shortDescription, @RequestParam String mainDescription,
			@RequestParam("photo") MultipartFile photo) throws IOException {
		Services createdService = serviceService.createService(title, icon, shortDescription, mainDescription, photo);
		return ResponseEntity.ok(createdService);
	}

	@GetMapping
	public List<Services> getAllServices() {
		return serviceService.getAllServices();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Services> getServiceById(@PathVariable Long id) {
		Optional<Services> service = serviceService.getServiceById(id);
		return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestParam String title,
			@RequestParam("icon") MultipartFile icon, @RequestParam String shortDescription,
			@RequestParam String mainDescription, @RequestParam("photo") MultipartFile photo) throws IOException {
		Services updatedService = serviceService.updateService(id, title, icon, shortDescription, mainDescription,
				photo);
		return ResponseEntity.ok(updatedService);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteService(@PathVariable Long id) {
		serviceService.deleteService(id);
		return ResponseEntity.noContent().build();
	}
}
