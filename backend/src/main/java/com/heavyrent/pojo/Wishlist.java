package com.heavyrent.pojo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="wishlist_tbl")
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wish_id")
	private int wishlist_id;
	
	@ManyToOne
	@JoinColumn(name="equip_id")
	private Equipment equipwlist;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userwlist;
	
	@Column(name = "date_addin_wishlist")
	private Date addedInWishlist;
}
