package com.heavyrent.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.dao.ManageEquipmentDao;
import com.heavyrent.dto.GetAllEquipmentDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EquipmentManagementServiceImpl implements EquimentManagementService {
	
	@Autowired
	private ManageEquipmentDao dao;
	
	@Autowired
	private EquipmentDao eqpDao;

	@Autowired
	private ModelMapper map;
	
	@Override
	public  GetAllEquipmentDto getAllEquipmentForOrganization(User user) {
		//List<Equipment> list = null;
		List<Equipment> list =  dao.findByOrganization(user) ;
		
		GetAllEquipmentDto dto = new GetAllEquipmentDto();
		
		//list = dao.findByOrganization(user);
		
		dto.setList(list);
		
		return map.map(dto, GetAllEquipmentDto.class);
	}

	@Override
	public Status  disableEquipment(long id) {
		     Equipment eqp = eqpDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Equimnet Not found"));
				
		     eqp.setStatus(Status.DISABLE);
		     
		     return eqp.getStatus();
		
	}

	@Override
	public Status enableEquipment(long id) {
		
		Equipment eqp = eqpDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("Equimnet Not found"));
		
	     eqp.setStatus(Status.AVAILABLE);
	     
	     return eqp.getStatus();
	}

	

	

}
