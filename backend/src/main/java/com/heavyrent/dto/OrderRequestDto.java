package com.heavyrent.dto;

import java.util.Date;

import org.modelmapper.internal.bytebuddy.description.modifier.EnumerationState;

import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.OrderAddress;
import com.heavyrent.pojo.OrderStatus;
import com.heavyrent.pojo.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

	
	
	
	
	private Date orderOn;
	
	
	private Date orderTill;
	

	private boolean returnStatus=false;
	

	private double costPerDay;
	
	
	private OrderStatus orderStatus = OrderStatus.NOTCONFIRMED;
	
	
	private Date orderDate;
	

	private Long equipId;
	
	
	private OrderAddress orderaddress;
	
	 private double amount;
	
}
