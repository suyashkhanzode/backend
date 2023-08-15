package com.heavyrent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.dao.UserDao;
import com.heavyrent.dao.WishlistDao;
import com.heavyrent.dto.AddToWishlistDto;
import com.heavyrent.dto.EquipmentDto;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.User;
import com.heavyrent.pojo.Wishlist;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	private WishlistDao wdao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private EquipmentDao equipmentdao;

	@Autowired
	private EquipmentService equipservice;
	

	@Override
	public void addEquipmentToWishlist( User user ,AddToWishlistDto dto ) {
		// TODO Auto-generated method stub
       Equipment equipment = equipmentdao.findById(dto.getEqupId()).orElseThrow(()->new ResourceNotFoundException("respource not found"));
		Wishlist wishlist = new Wishlist();
		wishlist.setEquipwlist(equipment);
		wishlist.setUser(user);
		
		wdao.save(wishlist);

		
	}



	@Override
	public List<EquipmentDto> getCartEquipments(User user) {
		// TODO Auto-generated method stub
		List<Wishlist> wishlist = wdao.findAllByUserOrderByCreatedDateDesc(user);
		List<EquipmentDto> equipdto= new ArrayList<>();
		
		
		for (Wishlist w : wishlist) {
			
			equipdto.add(equipservice.getEquipmentForWishlist(w.getEquipwlist()));
			
		}
		return equipdto;
	}
	
	
	
	 
	
	
	
	

}
