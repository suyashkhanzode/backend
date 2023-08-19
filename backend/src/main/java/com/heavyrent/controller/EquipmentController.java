package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.pojo.Equipment;
import com.heavyrent.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
	
	@Autowired
	private EquipmentService service; 
	
	@PostMapping("/add")
	public Equipment addEquipment(@RequestBody Equipment eqp)
	{
		 Equipment e = service.addEquipment(eqp);
		 
		 if(e != null)
		 {
			 return e;
			 
		 }
		 else {
			 return null;
		 }
		
	}
	
	
	

}
