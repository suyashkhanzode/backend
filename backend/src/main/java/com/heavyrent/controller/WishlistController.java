package com.heavyrent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.custom_exception.WishlistException;
import com.heavyrent.dto.AddToWishlistDto;
import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.dto.MsgWithReqStatusResponse;
import com.heavyrent.dto.WishlistDto;
import com.heavyrent.pojo.User;
import com.heavyrent.service.UserService;
import com.heavyrent.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {

	@Autowired
	private WishlistService wishlistservice;
	
	@Autowired
	private UserService userservice;
	
	 @PostMapping("/add/{user_id}")
	    public ResponseEntity<MsgWithReqStatusResponse> addEquipmentToWishlist(@RequestBody AddToWishlistDto DTO , 
	    		                                             @PathVariable("user_id") long user_id) {
		       String message="added to wishlist scuuccesfully";
		        User user = userservice.getUserbyid(user_id);
	        try {
	            wishlistservice.addEquipmentToWishlist(user, DTO);
	            return ResponseEntity.ok(new MsgWithReqStatusResponse(message,true));
	        } catch (Exception e) {
	        	 throw new ResourceNotFoundException ("Failed to add wishlist.");
	        }
	    }
	 
	 @GetMapping("/get/{user_id}")
	    public ResponseEntity<List<WishlistDto>> getWishList(@PathVariable("user_id") Long user_id) {
	       
		  User user = userservice.getUserbyid(user_id);
		 try {
	            List<WishlistDto> wishlistItems = wishlistservice.getCartEquipments(user);
	            return ResponseEntity.ok(wishlistItems);
	        } catch (Exception e) {
	        	 throw new WishlistException("Failed to retrieve wishlist items.");
	        }
	    }
	 
	 @DeleteMapping("/remove/{wish_id}")
	  public ResponseEntity<MsgWithReqStatusResponse > returnOrder(@PathVariable("wish_id") long wish_id)
     {           
                     
              
		try {
		String message	=wishlistservice.deleteFromWishlist(wish_id);
			 
	            return ResponseEntity.ok( new  MsgWithReqStatusResponse(message,true));
	        } catch (Exception e) {
	        	 throw new ResourceNotFoundException ("Failed to confirmed Order items.");
	        }
   	 
    }
}
