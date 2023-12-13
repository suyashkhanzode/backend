package com.heavyrent.service;

import java.util.Date;
import java.util.List;

import org.apache.el.stream.Optional;

import com.heavyrent.dto.AddToWishlistDto;
import com.heavyrent.dto.OrderRequestDto;
import com.heavyrent.dto.OrderResponseDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Orders;
import com.heavyrent.pojo.User;

public interface OrderService {

	
	Orders placeOrderService(OrderRequestDto odto,Equipment equipment ,  User user);
	
	List<OrderResponseDto> getOrderForOrg( long org_id);
	List<OrderResponseDto> getOrderForCust( User cust_id);
	
	String confirmOrder(long ord_id );
	
	Orders getOrderById(long ord_id);
	 
	String returnOrder(long ord_id ); 
	
	 List<OrderResponseDto> getTodaysOrderOfOrg(long org_id,Date date);
	 
	 Orders   getOrder(long ord_id);
	 
	 
	
}
