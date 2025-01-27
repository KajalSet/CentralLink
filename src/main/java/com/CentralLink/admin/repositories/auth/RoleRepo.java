package com.CentralLink.admin.repositories.auth;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.model.auth.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID> {

	Page<Role> findAllByRoleType(String roleType, PageRequest of);

	Role findByname(String retailerRoleName);
//    Role findByRoleName(String roleName);

	@Query("select s from Role s where (lower(s.description) like lower(concat('%', :str, '%'))) and s.isActive = :active")
	Page<Role> getAllRole(@Param("str") String str, @Param("active") boolean active, Pageable pageable);

	List<Role> findByUserId(UUID userId);

}
