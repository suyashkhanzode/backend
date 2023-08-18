package com.heavyrent.service;

import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;

public interface EquipmentService {

	public Equipment addEquipment(Equipment equipment);
	
	public EquipmentDto getEquipment(long id);
	
	public EquipmentDto getEquipmentForWishlist(Equipment equipment);
	

}
