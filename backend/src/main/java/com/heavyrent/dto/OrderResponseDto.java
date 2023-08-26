package com.heavyrent.dto;

import java.time.Year;
import java.util.Date;

import com.heavyrent.pojo.Category;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.OrderAddress;
import com.heavyrent.pojo.OrderStatus;
import com.heavyrent.pojo.Payment;

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
public class OrderResponseDto {

	private int orderId;
	
	
	private Date orderOn;
	
	
	private Date orderTill;
	

	private boolean returnStatus;
	

	private double costPerDay;
	
	
	private OrderStatus orderStatus;
	
	
	private Date orderDate;
	

	private Equipment equipment;
	
	 private double amount;
	 
	 private Payment payment;
	    
	
}
