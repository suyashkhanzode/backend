package com.heavyrent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavyrent.pojo.User;

public interface UserDao  extends JpaRepository<User, Long>{

	
}
