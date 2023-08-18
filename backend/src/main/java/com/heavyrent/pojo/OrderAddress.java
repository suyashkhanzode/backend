package com.heavyrent.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderAddress {
     @Column(length=70)
	private String Address;
     @Column(length=20)
	private String city;
     @Column(length=15)
	private String state;
     @Column(length=10)
	private int pincode;
	
}
