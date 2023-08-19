package com.heavyrent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.dao.UserDao;
import com.heavyrent.pojo.User;



@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
    private final UserDao userDao;
	
	@Autowired
    public RegistrationServiceImpl(UserDao userRepository) {
        this.userDao = userRepository;
    }

	@Override
	public void saveUser(User user) {
		userDao.save(user);
		
	}

}
