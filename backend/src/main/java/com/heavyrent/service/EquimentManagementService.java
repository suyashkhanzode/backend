package com.heavyrent.service;

import java.util.List;

import com.heavyrent.dto.EquipmentDto;

import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;

public interface EquimentManagementService {

	List<EquipmentDto> getAllEquipmentForOrganization(User user);

	public Status disableEquipment(long id);

	public Status enableEquipment(long id);

	public Status rentEuipment(long id);

}
