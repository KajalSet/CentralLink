package com.CentralLink.admin.repositories.auth;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.model.auth.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, UUID> {

	Optional<Profile> findByphone(String mobileNumber);

}
