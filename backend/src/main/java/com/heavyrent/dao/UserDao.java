package com.heavyrent.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.RoleType;
import com.heavyrent.pojo.User;

@Repository
public interface UserDao  extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email,String password);
	Optional<User> findByEmail(String email);
	List<User> findAllByRole(RoleType role);
	
	boolean existsByEmail(String email);
	List<User> findByEmailContainingAndAddressContainingAndNameContaining(String email,String address,String name);
 
}
