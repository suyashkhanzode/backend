package com.heavyrent.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dao.UserDao;
import com.heavyrent.dto.LoginRequestAuth;
import com.heavyrent.dto.UserRequestDto;
import com.heavyrent.dto.EmailPasswordDTO;
import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.Document;
import com.heavyrent.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public User getUserbyid(Long user_id) {
		// TODO Auto-generated method stub
      //User user=userDao.findById(user_id).orElseThrow(()->new WishlistException("Invalid user ID !!!!!"));
		//return user;
		return userDao.findById(user_id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

	@Override
	public UserResponse getUserDetails(LoginRequestAuth loginRequestobj) {
		User userFromDB = userDao.findByEmailAndPassword(loginRequestobj.getEmail(),loginRequestobj.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email Id or Password !!!!!"));
		
//		Document doc=new Document();
//		doc.setAadharDoc(userFromDB.getDocument().getAadharDoc());
//		doc.setPanDoc(userFromDB.getDocument().getPanDoc());
//		doc.setCommpanyVerDoc1(userFromDB.getDocument().getCommpanyVerDoc1());
//		doc.setCommpanyVerDoc2(userFromDB.getDocument().getCommpanyVerDoc2());
//		userFromDB.setDocument(doc);
		return mapper.map(userFromDB, UserResponse.class);
	}

	@Override
	public String setNewPassword(EmailPasswordDTO forPassRequest) {
		User user=userDao.findByEmail(forPassRequest.getEmail())
		.orElseThrow(() -> new ResourceNotFoundException("Invalid Email Id or Password !!!!!"));
		
		user.setPassword(forPassRequest.getPassword());
		userDao.save(user);
		return "New Password set successfully";
	}

	@Override
	public String setchangedPassword(EmailPasswordDTO forPassRequest) {
		User user=userDao.findByEmailAndPassword(forPassRequest.getEmail(), forPassRequest.getOldPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid old Password !!!!!"));
				
		user.setPassword(forPassRequest.getPassword());
		userDao.save(user);
		return "New Password set successfully";
	}

	@Override
	public User CustomerForUpdate(UserRequestDto userToUpdate) {
		User user=userDao.findById(userToUpdate.getUserId())
				.orElseThrow(()->new WishlistException("Something went wrong... please try again  !!!!!"));
		user.setAddress(userToUpdate.getAddress());
		user.setMobile_no(userToUpdate.getMobile_no());
		user.setName(userToUpdate.getName());
		user.setPin(userToUpdate.getPin());
		
		userDao.save(user);
		return userDao.findById(user.getUserId())
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	
	}

	@Override
	public String OrgForUpdate(UserRequestDto userToUpdate) {
		User user=userDao.findById(userToUpdate.getUserId())
				.orElseThrow(()->new WishlistException("Something went wrong... please try again  !!!!!"));
		user.setAddress(userToUpdate.getAddress());
		user.setMobile_no(userToUpdate.getMobile_no());
		user.setName(userToUpdate.getName());
		user.setPin(userToUpdate.getPin());
		user.setUrl(userToUpdate.getUrl());
		
		userDao.save(user);
		return "Successfully updated Deatils";
	}

	@Override
	public List<UserResponse> getAllUser() {
		List <User> user=userDao.findAll();
		List<UserResponse> userResp=new ArrayList<UserResponse>();
		for (User u:user) {
			userResp.add(mapper.map(u, UserResponse.class));
		}
	    return userResp;
	            
	}

	


}
