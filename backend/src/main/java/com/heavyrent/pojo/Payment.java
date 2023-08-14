package com.heavyrent.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payments_tbl")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Long paymentId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private PaymentStatus payStatus;
	
	@Column(name="paymnt_doc")
	private String paymentDocument;
	
	@ManyToOne
	@JoinColumn(name = "org_id")
	private User organization;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private User customer;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Orders order;

}

