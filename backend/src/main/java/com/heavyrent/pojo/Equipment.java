package com.heavyrent.pojo;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "equip_tbl")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
	
	private String rtoNo;
	
	@Enumerated(EnumType.STRING)

	@Column(length = 25)
	private Status status;
	
	@Column(name = "insrc_inv")
	private String insuranceInvoice;
	
	@Column(name = "rc_book")
	private String rcBook;
	
	
	
	@OneToMany(mappedBy="equipwlist")
	private List<Wishlist> Equipmentlist = new ArrayList<>();
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "org_id")
	private User organization;
	
	


}
