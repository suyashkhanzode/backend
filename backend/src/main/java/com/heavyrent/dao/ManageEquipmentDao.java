package com.heavyrent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.User;



public interface ManageEquipmentDao extends JpaRepository<Equipment, User>{
	
	
	List<Equipment> findByOrganization(User user);
	
	

}
