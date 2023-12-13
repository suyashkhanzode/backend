package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.dto.LoginRequestAuth;
import com.heavyrent.dto.UserResponse;
import com.heavyrent.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private UserService userService; 
	
	@PostMapping()
	public ResponseEntity<UserResponse> signInEmployee(@RequestBody @Valid LoginRequestAuth loginRequestobj) {
		
		UserResponse resp = userService.getUserDetails(loginRequestobj);
			return ResponseEntity.ok(resp);

	}
	
}
