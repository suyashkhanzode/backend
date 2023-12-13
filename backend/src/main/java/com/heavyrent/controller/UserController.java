package com.heavyrent.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.dto.MsgWithReqStatusResponse;
import com.heavyrent.dto.UserRequestDto;
import com.heavyrent.dto.EmailPasswordDTO;
import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.User;
import com.heavyrent.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/resetPassword")
	public ResponseEntity<MsgWithReqStatusResponse> resetPassword(@RequestBody @Valid EmailPasswordDTO forPassRequest) {
		
		String message = userService.setNewPassword(forPassRequest) ;

			return ResponseEntity.ok(new MsgWithReqStatusResponse(message,true));
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<MsgWithReqStatusResponse> changePassword(@RequestBody @Valid EmailPasswordDTO forPassRequest) {
		
		String message = userService.setchangedPassword(forPassRequest) ;

			return ResponseEntity.ok(new MsgWithReqStatusResponse(message,true));
	}
	
	@GetMapping("/edit/{userId}")
	public ResponseEntity<UserResponse> getUserDetails(@PathVariable Long userId) {
		return ResponseEntity.ok(mapper.map(userService.getUserbyid(userId),UserResponse.class));
	}
	
	@PutMapping("/update/customer")
	public User updateCustomer(@RequestBody UserRequestDto userForUpdate){
		
		return userService.CustomerForUpdate(userForUpdate);
	}
	
	@PutMapping("/update/organization")
	public ResponseEntity<MsgWithReqStatusResponse> updateOrganization(@RequestBody UserRequestDto userForUpdate){
		String message=userService.OrgForUpdate(userForUpdate);
		return ResponseEntity.ok(new MsgWithReqStatusResponse(message,true));
	}
	
	@GetMapping("/allUsers")
	public List<UserResponse> getAllUser() {
		
		return userService.getAllUser();
	}
	
}
