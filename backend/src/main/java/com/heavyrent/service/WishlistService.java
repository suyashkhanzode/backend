package com.heavyrent.service;

import java.util.List;

import com.heavyrent.dto.AddToWishlistDto;
import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.dto.WishlistDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.User;
import com.heavyrent.pojo.Wishlist;

public interface WishlistService {

	List<WishlistDto> getCartEquipments(User user);

	void addEquipmentToWishlist(User user, AddToWishlistDto Dto);
	
	String deleteFromWishlist(long wish_id);
	
}
