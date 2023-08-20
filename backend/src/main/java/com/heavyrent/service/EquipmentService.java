package com.heavyrent.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;

public interface EquipmentService {

	public Equipment addEquipment(Equipment equipment) ;
	
	public Equipment getEquipment(long id);
	
	public EquipmentDto getEquipmentDto(long id);
	
	public EquipmentDto getEquipmentForWishlist(Equipment equipment);
	

}
