package com.CentralLink.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralLink.admin.entity.Inquiry;
import com.CentralLink.admin.repository.InquiryRepository;

@Service
public class InquiryService {

	@Autowired
	private InquiryRepository inquiryRepository;

	// Create new Inquiry
	public Inquiry createInquiry(Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}

	// Get all Inquiries
	public List<Inquiry> getAllInquiries() {
		return inquiryRepository.findAll();
	}

	// Get Inquiry by ID
	public Optional<Inquiry> getInquiryById(Long id) {
		return inquiryRepository.findById(id);
	}

	// Update an Inquiry
	public Inquiry updateInquiry(Long id, Inquiry inquiry) {
		if (!inquiryRepository.existsById(id)) {
			throw new RuntimeException("Inquiry not found with ID: " + id);
		}
		inquiry.setId(id);
		return inquiryRepository.save(inquiry);
	}

	// Delete an Inquiry
	public void deleteInquiry(Long id) {
		if (!inquiryRepository.existsById(id)) {
			throw new RuntimeException("Inquiry not found with ID: " + id);
		}
		inquiryRepository.deleteById(id);
	}
}
