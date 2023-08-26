package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dto.MsgWithReqStatusResponse;
import com.heavyrent.dto.OrderPlacedResponseDto;
import com.heavyrent.dto.OrderRequestDto;
import com.heavyrent.dto.PaymentRequestDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.Orders;
import com.heavyrent.pojo.User;
import com.heavyrent.service.OrderService;
import com.heavyrent.service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/dopay/{orderId}")
    public ResponseEntity<MsgWithReqStatusResponse> placeOrder( @RequestBody PaymentRequestDto pdto,@PathVariable("orderId") long orderId){
            
    		                                             
	
	        Orders order= orderservice.getOrder(orderId);
	 
	  
        try {
        	       
        String message=	paymentservice.doPayment(order,pdto);
        	 return ResponseEntity.ok( new  MsgWithReqStatusResponse(message,true));
        } catch (Exception e) {
        	 throw new ResourceNotFoundException ("payment failed !!!!");
        }
    }

}
