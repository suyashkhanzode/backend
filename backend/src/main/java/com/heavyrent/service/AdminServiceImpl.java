package com.heavyrent.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heavyrent.dao.UserDao;
import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.Document;
import com.heavyrent.pojo.RoleType;
import com.heavyrent.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDao userDao; 
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<UserResponse> getUsers(RoleType role) {

		List<User> userFormDb=userDao.findAllByRole(role);
				
		List<UserResponse> user=new ArrayList<UserResponse>();
		for(User u : userFormDb) {
//			Document doc=new Document();
//			doc.setAadharDoc(u.getDocument().getAadharDoc());
//			doc.setPanDoc(u.getDocument().getPanDoc());
//			doc.setCommpanyVerDoc1(u.getDocument().getCommpanyVerDoc1());
//			doc.setCommpanyVerDoc2(u.getDocument().getCommpanyVerDoc2());
//			u.setDocument(doc);
			user.add(mapper.map(u, UserResponse.class));
		}
		return user;

	}
	
	@Override
	public List<UserResponse> searchUsersWithFilters(String email, String address, String name) {
		List<User> userFormDb= 
				userDao.findByEmailContainingAndAddressContainingAndNameContaining(
				email, address, name);
        
        List<UserResponse> user=new ArrayList<UserResponse>();
		for(User u : userFormDb) {
			
			user.add(mapper.map(u, UserResponse.class));
		}
        
        return user;
    }
	

}
