package com.heavyrent.pojo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
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
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id" )
	private User user;
	
	@Column(name = "date_addin_wishlist")
	private Date createdDate;
	
}
