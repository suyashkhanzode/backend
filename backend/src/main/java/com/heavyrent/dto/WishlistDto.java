package com.heavyrent.dto;



import java.time.Year;

import com.heavyrent.pojo.Category;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistDto {
	
    private Long equpId;
	
	
	private String equipmentName;
	
	
	private Category category;
	

	private String yearOfMfg;
	
	private String description;
	
	private boolean insurance_status;

	private String city;
	
	
	private String modelNo;
	
	private String equip_img1;
	
	private double costPerDay;
	
	private String parkLocation;
	
    private String rtoNo;
	
	private Status status;
	
	//private User organization;
	
	private long orgId ;
	

    private long wish_id;


}

