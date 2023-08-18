package com.heavyrent.service;

import com.heavyrent.dto.PaymentRequestDto;
import com.heavyrent.pojo.Orders;

public interface PaymentService {

	String doPayment(Orders order , PaymentRequestDto pdto);
}
