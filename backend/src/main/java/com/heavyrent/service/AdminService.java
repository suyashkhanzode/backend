package com.heavyrent.service;

import java.util.List;

import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.RoleType;


public interface AdminService {
	List<UserResponse> getUsers(RoleType role);
//	List<UserResponse> getFilteredUsers(String keyword,String column);
	List<UserResponse> searchUsersWithFilters(String email, String address, String name);
}
