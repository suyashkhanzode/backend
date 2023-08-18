package com.heavyrent.controller;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.dto.GetAllEquipmentDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;
import com.heavyrent.service.EquipmentManagementServiceImpl;
import com.heavyrent.service.UserService;

@RestController
@RequestMapping("/mngeqp")
public class ManageEquipmentController {
	
	@Autowired
	private EquipmentManagementServiceImpl service;
	
	@Autowired
	private UserService userService;

	@GetMapping("/geteqp/{orgId}")
	public List<Equipment> getAllEquipmentForOrg(@PathVariable long orgId)
	{
		User user = userService.getUserbyid(orgId);
		
		user.getMyEquipments();
		System.out.println(user.getMyEquipments());
		
		GetAllEquipmentDto dto = new GetAllEquipmentDto();
		
		
		 dto = service.getAllEquipmentForOrganization(user);
		
		 
		 return dto.getList();
		
	}
	
	@PostMapping("/disable/{orgId}")
	 public Status disableequipment(@PathVariable long orgId)
	 {
		
	      Status s =  service.disableEquipment(orgId);
	      
	      return s;
		 
	 }
	
	@PostMapping("/enable/{orgId}")
	 public Status enableequipment(@PathVariable long orgId)
	 {
		
	      Status s =  service.enableEquipment(orgId);
	      
	      return s;
		 
	 }
	
	   
	  
}
