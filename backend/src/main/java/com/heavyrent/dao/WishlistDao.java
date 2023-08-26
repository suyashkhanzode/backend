package com.heavyrent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavyrent.pojo.User;
import com.heavyrent.pojo.Wishlist;

public interface WishlistDao extends JpaRepository<Wishlist, Long>{

	 List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);
	
}
