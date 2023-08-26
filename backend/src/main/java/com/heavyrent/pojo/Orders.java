package com.heavyrent.pojo;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders_tbl")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_on")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date orderOn;
	
	@Column(name = "order_till")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date orderTill;
	
	@Column(name = "return_status")
	private boolean returnStatus=false;
	
	@Column(name = "cost_per_day")
	private double costPerDay;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private OrderStatus orderStatus;
	
	@Column(name = "order_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date orderDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	private User customer;
	
	@Column(name="org_id")
	private Long organisationId;
//	private int orgId;
		
	@Column(name = "amount")
    private double amount;
	
	@Embedded
	private OrderAddress address;

	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
}
