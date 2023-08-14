package com.heavyrent.pojo;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_on")
	private Date orderOn;
	
	@Column(name = "order_till")
	private Date orderTill;
	
	@Column(name = "return_status")
	private boolean returnStatus;
	
	@Column(name = "cost_per_day")
	private double costPerDay;
	
	@Column(name = "order_status",length = 50 )
	private String orderStatus;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@OneToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "org_id")
	private User organisation;
//	private int orgId;
		
	
	
	

}
