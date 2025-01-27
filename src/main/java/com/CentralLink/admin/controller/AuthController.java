package com.CentralLink.admin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralLink.admin.config.CurrentUser;
import com.CentralLink.admin.config.JdbcUserDetailsService;
import com.CentralLink.admin.exception.RecordNotFoundException;
import com.CentralLink.admin.model.auth.RefreshToken;
import com.CentralLink.admin.model.auth.User;
import com.CentralLink.admin.pojo.request.AuthenticationRequest;
import com.CentralLink.admin.pojo.response.AuthenticationResponse;
import com.CentralLink.admin.repositories.auth.UserRepo;
import com.CentralLink.admin.service.auth.JwtUtil;
import com.CentralLink.admin.service.auth.RefreshTokenService;

import io.swagger.v3.oas.annotations.tags.Tag;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@Tag(name = "User Authentication", description = "APIs for User Authentication related operations")
public class AuthController {
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JdbcUserDetailsService jdbcUserDetailsService;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@PostMapping(value = "/authenticate", produces = "application/json")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		System.out.println(authenticationRequest.toString());
		try {
			String jwt = "";
			Optional<User> oldUser = userRepo.findByUserName(authenticationRequest.getUsername());
			// JDBC Check BCrypt the password
			// log4j.debug("Inside JDBC check");
			CurrentUser userDetails = null;
			try {
				userDetails = jdbcUserDetailsService.loadUserByUsernameAndPass(authenticationRequest.getUsername(),
						authenticationRequest.getPassword());
				
			} catch (Exception e) {
				throw new RecordNotFoundException("Authentication Failed " + e.getMessage());
			}

			RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

			jwt = jwtTokenUtil.generateToken(userDetails);
			AuthenticationResponse response = new AuthenticationResponse(jwt, refreshToken.getToken());

			return ResponseEntity.ok(response);

		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
}
