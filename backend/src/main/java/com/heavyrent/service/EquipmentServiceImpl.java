package com.heavyrent.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.dao.UserDao;
import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao dao;
	
	@Autowired
	private ModelMapper map;
	
	@Autowired
	private UserDao daoUser;
	
	@Override
	public Equipment addEquipment(Equipment equipment) {
		
		//To save equipment
		 Equipment eqp = dao.save(equipment);
		
		return eqp;
	}

	@Override
	public EquipmentDto getEquipment(long id) {
		   
		    EquipmentDto dto = new EquipmentDto();
		   Equipment eqp =   dao.findById(id).orElseThrow(() -> new RuntimeException());
		   
		     User org = daoUser.findById(eqp.getOrganization().getUserId()).orElseThrow(() -> new RuntimeException());
		    
		    
		    
		    dto.setOrgId(eqp.getOrganization().getUserId());
		    dto.setCategory(eqp.getCategory());
		    dto.setCity(eqp.getCity());
		    dto.setCostPerDay(eqp.getCostPerDay());
		    dto.setDescription(eqp.getDescription());
		    dto.setEquipmentName(eqp.getEquipmentName());
		    dto.setEqupId(id);
		    dto.setYearOfMfg(eqp.getYearOfMfg());
		    dto.setStatus(eqp.getStatus());
		    dto.setRtoNo(eqp.getRtoNo());
		    dto.setModelNo(eqp.getModelNo());
		
		return dto;
	}
	
	
	
	
	

	@Override
	public EquipmentDto getEquipmentForWishlist(Equipment equipment) {
		// TODO Auto-generated method stub
		EquipmentDto equipdto = new EquipmentDto();
		equipdto.setEqupId(equipment.getEqupId());
		equipdto.setCostPerDay(equipment.getCostPerDay());
		equipdto.setEquipmentName(equipment.getEquipmentName());
		equipdto.setCity(equipment.getCity());
		equipdto.setCategory(equipment.getCategory());
		equipdto.setModelNo(equipment.getModelNo());
		equipdto.setYearOfMfg(equipment.getYearOfMfg());
		return equipdto;
	}

	
}
