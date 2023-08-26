package com.heavyrent.controller;


import java.io.IOException;
import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
@CrossOrigin(origins = "http://localhost:3000")
public class EquipmentController {
	
	@Autowired
	private EquipmentService service; 
	
	@PostMapping(value =  "/add/{orgId}",consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?>  addEquipment(@RequestBody Equipment eqp ,@PathVariable long orgId )
	{
		return new ResponseEntity<EquipmentDto>(service.addEquipment(eqp, orgId),HttpStatus.OK);
	}
	
	@GetMapping("/get/{eqpId}")
	public ResponseEntity<?> getEquipment(@PathVariable("eqpId") long eqpId)
	{
		return new ResponseEntity<EquipmentDto>(service.getEquipmentDto(eqpId),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEquipment()
	{

		return new ResponseEntity<List<EquipmentDto>>(service.getAllEquipment(),HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEquipment()
	{
		return new ResponseEntity<List<EquipmentDto>>(service.getAllEquipment(),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	

}
