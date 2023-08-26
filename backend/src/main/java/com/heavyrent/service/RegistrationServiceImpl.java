package com.heavyrent.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.heavyrent.dao.UserDao;
import com.heavyrent.dto.UserDto;
import com.heavyrent.pojo.User;



@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
    private final UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	
	@Autowired
    public RegistrationServiceImpl(UserDao userRepository) {
        this.userDao = userRepository;
    }

	@Override
	public void saveUser(User user) {
		userDao.save(user);
		
	}
//
//	@Override
//	public UserDto registerUser(UserDto user) {
//		
//		User user1 = mapper.map(user, User.class);
//		
//		user.setPassword(encoder.encode(user.getPassword()));
//		
//		User user2 = userDao.save(user1);
//		
//		return mapper.map(user2, UserDto.class);
//	}
	
	

}
