package com.heavyrent.dto;

import java.time.Year;

import com.heavyrent.pojo.Category;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {
	
    private Long equpId;
	
	
	private String equipmentName;
	
	
	private Category category;
	

	private Year yearOfMfg;
	
	

	private String city;
	
	
	private String modelNo;
	
	
	private double costPerDay;
	
}
