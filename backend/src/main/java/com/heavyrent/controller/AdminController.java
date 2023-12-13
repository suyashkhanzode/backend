package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.RoleType;
import com.heavyrent.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/userDetails/{role}")
	private List<UserResponse> getMultipleUser(@PathVariable RoleType role){
		return adminService.getUsers(role);
	}
	
//	@GetMapping("/filter/{keyword}")
//	private List<UserResponse> getUserUsingFilter(@PathVariable String keyword){
//		return adminService.getFilteredUsers(keyword,"name");
//	}
	
	@GetMapping("/search")
    public ResponseEntity<List<UserResponse>> searchUsers(
    	@RequestParam(required = false) String mobileNo,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String address,
        @RequestParam(required = false) String name) {
         
        return ResponseEntity.ok(adminService.searchUsersWithFilters(email, address, name));
	}
}
