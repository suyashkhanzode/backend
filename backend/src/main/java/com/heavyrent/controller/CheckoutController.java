package com.heavyrent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.pojo.User;
import com.heavyrent.pojo.Wishlist;
import com.heavyrent.service.UserService;
import com.heavyrent.service.WishlistService;

@RestController
@RequestMapping("/checkout")
@CrossOrigin(origins = "*")
public class CheckoutController {

	@Autowired
	private WishlistService wservice;
	
   @Autowired
   private UserService userservice;
    
	
	@GetMapping("/{user_Id}")
	public List<Wishlist> checkoutEquipList(@PathVariable long user_Id){
		
		
	       
	User user=	userservice.getUserbyid(user_Id);
		
		
	
		return null;
	}
	
	
}
