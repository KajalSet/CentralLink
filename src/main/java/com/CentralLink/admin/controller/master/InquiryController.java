package com.CentralLink.admin.controller.master;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralLink.admin.entity.Inquiry;
import com.CentralLink.admin.service.InquiryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Inquiry")
@Tag(name = "inquiry", description = "APIs for inquiry related operations")
public class InquiryController {

	@Autowired
	private InquiryService inquiryService;

	// Create a new Inquiry
	@PostMapping
	public ResponseEntity<Inquiry> createInquiry(@RequestBody @Valid Inquiry inquiry) {
		Inquiry createdInquiry = inquiryService.createInquiry(inquiry);
		return ResponseEntity.ok(createdInquiry);
	}

	// Get all Inquiries
	@GetMapping
	public List<Inquiry> getAllInquiries() {
		return inquiryService.getAllInquiries();
	}

	// Get Inquiry by ID
	@GetMapping("/{id}")
	public ResponseEntity<Inquiry> getInquiryById(@PathVariable Long id) {
		Optional<Inquiry> inquiry = inquiryService.getInquiryById(id);
		return inquiry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Update an existing Inquiry
	@PutMapping("/{id}")
	public ResponseEntity<Inquiry> updateInquiry(@PathVariable Long id, @RequestBody @Valid Inquiry inquiry) {
		Inquiry updatedInquiry = inquiryService.updateInquiry(id, inquiry);
		return ResponseEntity.ok(updatedInquiry);
	}

	// Delete an Inquiry
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
		inquiryService.deleteInquiry(id);
		return ResponseEntity.noContent().build();
	}
}
