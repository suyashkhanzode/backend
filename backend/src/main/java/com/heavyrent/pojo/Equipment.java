package com.heavyrent.pojo;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equip_tbl")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equip-id")
	private Long equpId;
	
	@Column(name = "equi_name")
	private String equipmentName;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private Category category;
	
	@Column(name = "year_of_mfg")
	private Year yearOfMfg;
	
	
	private String description;
	
	@Column(name = "insr_sts")
	private boolean insurance_status;
	
	@Column(length = 50)
	private String city;
	
	@Column(name = "model_no")
	private String modelNo;
	
	@Column(name = "cost_per_day")
	private double costPerDay;
	
	@Column(length = 50)
	private String parkLocation;
	
	private String equip_img1;
	
	private String equip_img2;
	
	private String rtoNo;
	
	private Status status;
	
	@Column(name = "insrc_inv")
	private String insuranceInvoice;
	
	@Column(name = "rc_book")
	private String rcBook;
	
	
	
	@OneToMany(mappedBy="equipwlist")
	private List<Wishlist> Equipmentlist = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "org_id")
	private User organization;
	

	public Equipment() {
		
	}


	public Long getEqupId() {
		return equpId;
	}


	public void setEqupId(Long equpId) {
		this.equpId = equpId;
	}


	public String getEquipmentName() {
		return equipmentName;
	}


	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Year getYearOfMfg() {
		return yearOfMfg;
	}


	public void setYearOfMfg(Year yearOfMfg) {
		this.yearOfMfg = yearOfMfg;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isInsurance_status() {
		return insurance_status;
	}


	public void setInsurance_status(boolean insurance_status) {
		this.insurance_status = insurance_status;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getModelNo() {
		return modelNo;
	}


	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}


	public double getCostPerDay() {
		return costPerDay;
	}


	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}


	public String getParkLocation() {
		return parkLocation;
	}


	public void setParkLocation(String parkLocation) {
		this.parkLocation = parkLocation;
	}


	public String getEquip_img1() {
		return equip_img1;
	}


	public void setEquip_img1(String equip_img1) {
		this.equip_img1 = equip_img1;
	}


	public String getEquip_img2() {
		return equip_img2;
	}


	public void setEquip_img2(String equip_img2) {
		this.equip_img2 = equip_img2;
	}


	public String getRtoNo() {
		return rtoNo;
	}


	public void setRtoNo(String rtoNo) {
		this.rtoNo = rtoNo;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getInsuranceInvoice() {
		return insuranceInvoice;
	}


	public void setInsuranceInvoice(String insuranceInvoice) {
		this.insuranceInvoice = insuranceInvoice;
	}


	public String getRcBook() {
		return rcBook;
	}


	public void setRcBook(String rcBook) {
		this.rcBook = rcBook;
	}


	public List<Wishlist> getEquipmentlist() {
		return Equipmentlist;
	}


	public void setEquipmentlist(List<Wishlist> equipmentlist) {
		Equipmentlist = equipmentlist;
	}


	public User getOrganization() {
		return organization;
	}


	public void setOrganization(User organization) {
		this.organization = organization;
	}

	
	
	
	
}
