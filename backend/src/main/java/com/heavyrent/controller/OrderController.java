package com.heavyrent.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dto.AddToWishlistDto;
import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.dto.MsgWithReqStatusResponse;
import com.heavyrent.dto.OrderPlacedResponseDto;
import com.heavyrent.dto.OrderRequestDto;
import com.heavyrent.dto.OrderResponseDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Orders;
import com.heavyrent.pojo.User;
import com.heavyrent.service.EquipmentService;
import com.heavyrent.service.OrderService;
import com.heavyrent.service.UserService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private EquipmentService equipmentservice;
	
	@Autowired
	private OrderService orderservice;

	@PostMapping("/place/{equipmentId}")
	    public ResponseEntity<OrderPlacedResponseDto> placeOrder(@RequestBody OrderRequestDto odto, 
	    		                                             @PathVariable("equipmentId") long equipmentId,
	    		                                             @RequestParam("user_id") long user_id) {
		
		System.out.println(user_id);
		System.out.println(equipmentId);
		//System.out.println(xyz);
		 
		        User user = userservice.getUserbyid(user_id);
		        Equipment equipment = equipmentservice.getEquipment(equipmentId);
	        try {
	        	Orders ord=orderservice.placeOrderService(odto, equipment, user);
	        	;
	            return ResponseEntity.ok(new OrderPlacedResponseDto(ord.getOrderId()));
	        } catch (Exception e) {
	        	throw new WishlistException("Failed to retrieve Order .");
	        }
	    }
	
	 @GetMapping("/get/{org_id}")
	    public ResponseEntity<List<OrderResponseDto>> getOrder(@PathVariable("org_id") Long org_id) {
	       
		
		 try {
			 List<OrderResponseDto> order = orderservice.getOrderForOrg(org_id);
			 
	            return ResponseEntity.ok(order);
	        } catch (Exception e) {
	        	 throw new WishlistException("Failed to retrieve Order items.");
	        }
		 
	 }

       @PutMapping("/confirmedOrder/{ord_id}")
        public ResponseEntity<MsgWithReqStatusResponse > confirmedOrder(@PathVariable("ord_id") long ord_id)
      {
                          
	              
			try {
			String message	=orderservice.confirmOrder(ord_id);
				 
		            return ResponseEntity.ok( new  MsgWithReqStatusResponse(message,true));
		        } catch (Exception e) {
		        	 throw new ResourceNotFoundException ("Failed to confirmed Order items.");
		        }
        	 
         }

         @PutMapping("/returnOrder/{ord_id}")
         public ResponseEntity<MsgWithReqStatusResponse > returnOrder(@PathVariable("ord_id") long ord_id)
         {           
                         
	              
			try {
			String message	=orderservice.returnOrder(ord_id);
				 
		            return ResponseEntity.ok( new  MsgWithReqStatusResponse(message,true));
		        } catch (Exception e) {
		        	 throw new ResourceNotFoundException ("Failed to confirmed Order items.");
		        }
       	 
        }
         @GetMapping("/custorder/{cust_id}")
 	    public ResponseEntity<List<OrderResponseDto>> getOrderByCustId(@PathVariable("cust_id") Long cust_id)
         {
 	       
        User user=	 userservice.getUserbyid(cust_id);
 		 try {
 			 List<OrderResponseDto> order = orderservice.getOrderForCust(user);
 			 
 	            return ResponseEntity.ok(order);
 	        } catch (Exception e) {
 	        	 throw new WishlistException("Failed to retrieve Order items.");
 	        }
 		 
 	 }
         
         @GetMapping("/getTodaysOrders")
  	    public ResponseEntity<List<OrderResponseDto>> getOrder(@RequestParam Long org_id,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
  	       
  		
  		 try {
  			 List<OrderResponseDto> order = orderservice.getTodaysOrderOfOrg(org_id,date);
  			 
  	            return ResponseEntity.ok(order);
  	        } catch (Exception e) {
  	        	 throw new WishlistException("Failed to retrieve Order items.");
  	        }}
  		 
  		
         
}
