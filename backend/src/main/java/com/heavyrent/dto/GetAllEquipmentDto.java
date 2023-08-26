package com.heavyrent.dto;

import java.time.Year;
import java.util.List;

import com.heavyrent.pojo.Category;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEquipmentDto {

	private Long equpId;
	
	
	private String equipmentName;
	
	
	private Category category;
	
	
	private Year yearOfMfg;
	
	
	private String description;
	
	
	private boolean insurance_status;
	
	
	private String city;
	
	
	private String modelNo;
	
	
	private double costPerDay;
	
	
	private String parkLocation;
	
	private String equip_img1;
	
	
	
	private String rtoNo;
	
	
	private Status status;
	
	
	private String insuranceInvoice;
	
	
	private String rcBook;
	
	private User organization;
}
