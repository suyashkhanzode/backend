package com.app.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int list_id;
	
	@ManyToOne
	@JoinColumn(name="equip_id")
	private Equipment equipwlist;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userwlist;
}
