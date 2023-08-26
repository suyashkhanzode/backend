package com.heavyrent.service;

import java.util.List;

import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;

public interface EquipmentService {

	public Equipment addEquipment(Equipment equipment);
	
	public Equipment getEquipment(long id);
	
	public EquipmentDto getEquipmentDto(long id);

	
	public EquipmentDto getEquipmentForWishlist(Equipment equipment);
	

	
	
	
	public List<EquipmentDto> getAllEquipment();
}
