package com.heavyrent.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;

public interface EquipmentService {

	public EquipmentDto  addEquipment(Equipment equipment,long  orgId) ;
	
	public EquipmentDto getEquipmentDto(long id);
	
	public Equipment getEquipment(long equipmentId);
	
	public List<EquipmentDto> getAllEquipment();
	
	public EquipmentDto getEquipmentForWishlist(Equipment equipment);
	
	public EquipmentDto updateEquipment(EquipmentDto equipment);

}
