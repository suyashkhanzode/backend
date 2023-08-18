package com.heavyrent.dto;

import com.heavyrent.pojo.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {

	private PaymentStatus payStatus=PaymentStatus.SUCCESSFUL;
	
	
}
