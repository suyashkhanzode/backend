package com.heavyrent.service;

import java.util.ArrayList;
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
	public List<GetAllEquipmentDto> getAllEquipmentForOrganization(User user) {
		List<Equipment> list = null;
		list =  dao.findByOrganization(user) ;
		
		List<GetAllEquipmentDto> getEqpList = new ArrayList<GetAllEquipmentDto>();
		
		for (Equipment eqp : list) {
			 
			GetAllEquipmentDto dto = new GetAllEquipmentDto();
			User org = new User();
			    dto.setCategory(eqp.getCategory());
			    dto.setCity(eqp.getCity());
			    dto.setCostPerDay(eqp.getCostPerDay());
			    dto.setDescription(eqp.getDescription());
			    dto.setEquipmentName(eqp.getEquipmentName());
			    dto.setEqupId(eqp.getEqupId());
			    dto.setYearOfMfg(eqp.getYearOfMfg());
			    dto.setStatus(eqp.getStatus());
			    dto.setRtoNo(eqp.getRtoNo());
			    dto.setModelNo(eqp.getModelNo());
			    org.setUserId(eqp.getOrganization().getUserId());
			    dto.setOrganization(org);
			    getEqpList.add(dto);
			
		}
		
		
		
		
		return getEqpList;
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
