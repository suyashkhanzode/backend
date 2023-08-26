package com.heavyrent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavyrent.pojo.User;

public interface UserDao  extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email,String password);
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
