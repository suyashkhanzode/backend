package com.heavyrent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.pojo.Equipment;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao dao;
	
	@Override
	public Equipment addEquipment(Equipment equipment) {
		
		//To save equipment
		 Equipment eqp = dao.save(equipment);
		
		return eqp;
	}

	@Override
	public Equipment getEquipment(long id) {
		
		return null;
	}

}
