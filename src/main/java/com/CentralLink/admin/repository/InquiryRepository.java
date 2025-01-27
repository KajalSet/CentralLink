package com.CentralLink.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.entity.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long>{

}
