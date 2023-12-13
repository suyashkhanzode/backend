package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.dto.RegistrationRequestDTO;
import com.heavyrent.pojo.RoleType;
import com.heavyrent.pojo.User;
import com.heavyrent.service.RegistrationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegistrationController {
  
	@Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequestDTO registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setRole(registrationRequest.getRole());

        if (user.getRole() == RoleType.CUSTOMER) {
           
        	// Populate CUSTOMER-specific fields
        	user.setName(registrationRequest.getName());
        	user.setAddress(registrationRequest.getAddress());
        	user.setMobile_no(registrationRequest.getMobileNo());
        	user.setEmail(registrationRequest.getEmail());
        	user.setPassword(registrationRequest.getPassword());
        	user.setPin(registrationRequest.getPin());
        	
        } else if (user.getRole() == RoleType.ORGANIZATION) {
           
        	// Populate ORGANISATION-specific fields
        	user.setName(registrationRequest.getName());
        	user.setAddress(registrationRequest.getAddress());
        	user.setMobile_no(registrationRequest.getMobileNo());
        	user.setEmail(registrationRequest.getEmail());
        	user.setPassword(registrationRequest.getPassword());
        	user.setPin(registrationRequest.getPin());
        	 user.setUrl(registrationRequest.getUrl());
        	 user.setCin_no(registrationRequest.getCinNo());
        }

        registrationService.saveUser(user);

        return ResponseEntity.ok("User registered successfully!");
    }
    

}

