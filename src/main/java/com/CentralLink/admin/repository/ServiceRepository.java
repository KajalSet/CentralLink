package com.CentralLink.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.entity.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

}
