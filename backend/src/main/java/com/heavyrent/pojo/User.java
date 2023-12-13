package com.heavyrent.pojo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length=100)
	private String address;
	
	@Column(name = "mobile_no" ,length=11)
	private String mobile_no;
	
	@Column(length=10)
	private String pin;
	
	@Column(length=25)
	private String url;
	
	
	@Column(length=10)
	private String cin_no;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50,unique = true)
	private String email;
	
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private RoleType role;
	
	@OneToMany(mappedBy = "organization", cascade =  CascadeType.ALL,orphanRemoval = true)
	private List<Equipment> myEquipments = new ArrayList<Equipment>();
	
	
	
	@OneToOne(mappedBy="user")
	private Document document;
	
	
	
	
	

	
	
}
