package com.heavyrent.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.dto.EquipmentDto;

import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;
import com.heavyrent.service.EquipmentManagementServiceImpl;
import com.heavyrent.service.UserService;

@RestController
@RequestMapping("/organization/manageequipment")
@CrossOrigin(origins = "*")
public class ManageEquipmentController {

	@Autowired
	private EquipmentManagementServiceImpl service;

	@Autowired
	private UserService userService;

	@GetMapping("/geteqp/{orgId}")
	public ResponseEntity<?> getAllEquipmentForOrg(@PathVariable long orgId) {
		User user = userService.getUserbyid(orgId);

		return new ResponseEntity<List<EquipmentDto>>(service.getAllEquipmentForOrganization(user), HttpStatus.OK);

	}

	@PutMapping("/disable/{eqpId}")
	public Status disableequipment(@PathVariable long eqpId) {

		Status s = service.disableEquipment(eqpId);

		return s;

	}

	@PutMapping("/enable/{eqpId}")
	public Status enableequipment(@PathVariable long eqpId) {

		Status s = service.enableEquipment(eqpId);

		return s;

	}

}
