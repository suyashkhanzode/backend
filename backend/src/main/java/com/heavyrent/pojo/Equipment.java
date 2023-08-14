package com.heavyrent.pojo;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equip")
public class Equipment {

	@Id
	@Column(name = "equi-id")
	private Long equpid;
	
	@Column(name = "equi_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private Category category;
	
	@Column(name = "yearofmfg")
	private Year yearOfMfg;
	
	
	private String description;
	
	
	private boolean insurance_status;
	
	@Column(length = 50)
	private String city;
	
	@Column(name = "model_no")
	private String modelNo;
	
	
	private double costPerDay;
	
	@Column(length = 50)
	private String parkLocation;
	
	private Long equip_img1;
	
	private Long equip_img2;
	
	private String rtoNo;
	
	private Status status;
	
	@OneToMany(mappedBy="equipwlist")
	private List<Wishlist> Equipmentlist = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "org_id")
	private User organization;
	

	public Equipment() {
		
	}

	public Equipment(Long equpid, String name, String modelNo) {
		super();
		this.equpid = equpid;
		this.name = name;
		this.modelNo = modelNo;
	}

	public Long getEqupid() {
		return equpid;
	}

	public void setEqupid(Long equpid) {
		this.equpid = equpid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	
	
	
	
}
