package com.heavyrent.service;

import org.springframework.stereotype.Service;

//import com.heavyrent.dto.LoginRequestAuth;
import com.heavyrent.pojo.User;

import jakarta.transaction.Transactional;


public interface UserService {

	//User getUser(LoginRequestAuth loginRequest);
	
	User getUserbyid(Long user_id);
}
