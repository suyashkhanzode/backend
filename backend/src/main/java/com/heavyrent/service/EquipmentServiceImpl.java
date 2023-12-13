package com.heavyrent.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
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

	@Autowired
	private ModelMapper mapper;

	@Override
	public EquipmentDto addEquipment(Equipment equipment, long orgId) {

		User organization = daoUser.findById(orgId)
				.orElseThrow(() -> new ResourceNotFoundException("Organization With Given Id Is Not Found"));

		equipment.setOrganization(organization);

		// To save equipment
		Equipment eqp = dao.save(equipment);
		EquipmentDto dto = new EquipmentDto();

		return mapper.map(eqp, EquipmentDto.class);
	}

	public EquipmentDto getEquipmentDto(long equipmentId) {

		Equipment equipment = dao.findById(equipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("No Equipment With Given Id"));
		// find equipmnet from equipment id

		EquipmentDto dto = new EquipmentDto(equipment.getEqupId(), equipment.getEquipmentName(),
				equipment.getCategory(), equipment.getYearOfMfg(), equipment.getDescription(),
				equipment.isInsurance_status(), equipment.getCity(), equipment.getModelNo(), equipment.getCostPerDay(),
				equipment.getParkLocation(), equipment.getRtoNo(), equipment.getStatus(), equipment.getEquip_img1(),
				equipment.getInsuranceInvoice(), equipment.getRcBook(), equipment.getOrganization().getUserId());
		// Intialize EquipmentDto fillds using constructor

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

	@Override
	public List<EquipmentDto> getAllEquipment() {

		List<Equipment> eqp = dao.findAll();
		List<EquipmentDto> eqpDto = new ArrayList<EquipmentDto>();

		eqp.forEach(equipment -> {
			eqpDto.add(new EquipmentDto(equipment.getEqupId(), equipment.getEquipmentName(), equipment.getCategory(),
					equipment.getYearOfMfg(), equipment.getDescription(), equipment.isInsurance_status(),
					equipment.getCity(), equipment.getModelNo(), equipment.getCostPerDay(), equipment.getParkLocation(),
					equipment.getRtoNo(), equipment.getStatus(), equipment.getEquip_img1(),
					equipment.getInsuranceInvoice(), equipment.getRcBook(), equipment.getOrganization().getUserId()));
		});

		return eqpDto;
	}

	@Override
	public Equipment getEquipment(long equipmentId) {
		Equipment eqp = dao.findById(equipmentId).orElseThrow(() -> new RuntimeException());
		return eqp;
	}

	@Override
	public EquipmentDto updateEquipment(EquipmentDto equipment) {

		Equipment equipmentToSave = mapper.map(equipment, Equipment.class);

		dao.save(equipmentToSave);

		return null;
	}

}
