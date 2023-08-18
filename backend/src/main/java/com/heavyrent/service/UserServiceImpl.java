package com.heavyrent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dao.UserDao;
import com.heavyrent.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserbyid(Long user_id) {
		// TODO Auto-generated method stub
      //User user=userDao.findById(user_id).orElseThrow(()->new WishlistException("Invalid user ID !!!!!"));
		//return user;
		return userDao.findById(user_id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

//	@Override
//	public User getUser(String email) {
//		User userFromDB = userDao.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!!!"));
//		// TODO Auto-generated method stub
//		return userFromDB;
//	}

}
