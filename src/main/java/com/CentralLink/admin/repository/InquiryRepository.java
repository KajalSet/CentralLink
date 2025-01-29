package com.CentralLink.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.entity.Inquiry;
import com.CentralLink.admin.entity.Services;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long>{

	List<Inquiry> findByServiceName(Services services);

}
