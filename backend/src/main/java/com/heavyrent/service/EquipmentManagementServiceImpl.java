package com.heavyrent.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.dao.ManageEquipmentDao;
import com.heavyrent.dto.EquipmentDto;

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

	@Override
	public List<EquipmentDto> getAllEquipmentForOrganization(User user) {

		List<Equipment> equipmentList = dao.findByOrganization(user);

		List<EquipmentDto> returnedEquipmentList = new ArrayList<EquipmentDto>();

		equipmentList.forEach(equipment -> {
			returnedEquipmentList.add(new EquipmentDto(equipment.getEqupId(), equipment.getEquipmentName(),
					equipment.getCategory(), equipment.getYearOfMfg(), equipment.getDescription(),
					equipment.isInsurance_status(), equipment.getCity(), equipment.getModelNo(),
					equipment.getCostPerDay(), equipment.getParkLocation(), equipment.getRtoNo(), equipment.getStatus(),
					equipment.getEquip_img1(), equipment.getInsuranceInvoice(), equipment.getRcBook(),
					equipment.getOrganization().getUserId()));
		});

		return returnedEquipmentList;

	}

	@Override
	public Status disableEquipment(long id) {
		Equipment eqp = eqpDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equimnet Not found"));

		eqp.setStatus(Status.DISABLE);

		return eqp.getStatus();

	}

	@Override
	public Status enableEquipment(long id) {

		Equipment eqp = eqpDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equimnet Not found"));

		if (eqp.getStatus() == Status.RENTED) {
			return Status.CANNOTDISABLED;
		}
		eqp.setStatus(Status.AVAILABLE);

		return eqp.getStatus();
	}

	@Override
	public Status rentEuipment(long id) {

		Equipment eqp = eqpDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equimnet Not found"));

		eqp.setStatus(Status.RENTED);
		return eqp.getStatus();
	}

}
