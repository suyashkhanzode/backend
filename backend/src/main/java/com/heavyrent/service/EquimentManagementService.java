package com.heavyrent.service;

import java.util.List;

import com.heavyrent.dto.GetAllEquipmentDto;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;

public interface EquimentManagementService {
	
	List<GetAllEquipmentDto> getAllEquipmentForOrganization(User user);

	public  Status  disableEquipment(long id);
	
	public  Status enableEquipment(long id);
	
	public Status rentEuipment(long id);
	
	public String  deleteEquipment(long id);
}
