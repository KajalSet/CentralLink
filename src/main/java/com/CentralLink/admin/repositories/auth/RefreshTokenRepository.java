package com.CentralLink.admin.repositories.auth;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.CentralLink.admin.model.auth.RefreshToken;
import com.CentralLink.admin.model.auth.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
	Optional<RefreshToken> findByToken(String token);

	@Modifying
	int deleteByUser(User user);
}
