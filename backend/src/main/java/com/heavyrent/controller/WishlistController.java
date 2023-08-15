package com.heavyrent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dto.AddToWishlistDto;
import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.User;
import com.heavyrent.service.UserService;
import com.heavyrent.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistservice;
	
	@Autowired
	private UserService userservice;
	
	 @PostMapping("/add/{user_id}")
	    public ResponseEntity<String> addEquipmentToWishlist(@RequestBody AddToWishlistDto DTO , 
	    		                                             @PathVariable("user_id") long user_id) {
		 
		        User user = userservice.getUserbyid(user_id);
	        try {
	            wishlistservice.addEquipmentToWishlist(user, DTO);
	            return ResponseEntity.ok("Equipment added to wishlist successfully.");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Failed to add equipment to wishlist: " + e.getMessage());
	        }
	    }
	 
	 @GetMapping("/get/{user_id}")
	    public ResponseEntity<List<EquipmentDto>> getWishList(@PathVariable("user_id") Long user_id) {
	       
		  User user = userservice.getUserbyid(user_id);
		 try {
	            List<EquipmentDto> wishlistItems = wishlistservice.getCartEquipments(user);
	            return ResponseEntity.ok(wishlistItems);
	        } catch (Exception e) {
	        	 throw new WishlistException("Failed to retrieve wishlist items.");
	        }
	    }
}
