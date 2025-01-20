//package com.CentralLink.admin.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.CentralLink.admin.entity.RegisterEntity;
//
//
//@Repository
//public interface RegisterRepository extends JpaRepository<RegisterEntity, Long> {
//
//	boolean existsByEmail(String email);
//
//	boolean existsByPhoneNumber(Long phoneNumber);
//
//	RegisterEntity findByEmail(String email);
//
//	RegisterEntity findByPhoneNumber(long phoneNumber);
//
//}
