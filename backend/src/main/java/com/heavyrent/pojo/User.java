package com.heavyrent.pojo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100)
	private String address;
	
	@Column(length=11)
	private String mobile_no;
	
	@Column(length=10)
	private String pin;
	
	@Column(length=10)
	private String url;
	
	
	@Column(length=10)
	private String cin_no;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 50)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private RoleType role;
	
	@OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Equipment> myEquipments = new ArrayList<Equipment>();
	
	@OneToOne
	@JoinColumn(name="doc_id")
	private Document document;
	
	@OneToMany(mappedBy="userwlist")
	private List<Wishlist> myWishlist = new ArrayList<>();	

	public User(Long id, String name, String email, String password, RoleType role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	

	public User() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}
	
	
	
	
}
