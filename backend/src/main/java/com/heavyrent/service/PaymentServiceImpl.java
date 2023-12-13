package com.heavyrent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.dao.OrderDao;
import com.heavyrent.dao.PaymentDao;
import com.heavyrent.dto.PaymentRequestDto;
import com.heavyrent.pojo.Orders;
import com.heavyrent.pojo.Payment;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
    @Autowired
	private PaymentDao pdao;
    
    @Autowired
    private OrderDao orderdao;
    
    @Autowired
    private EquimentManagementService service;
	
	@Override
	public String doPayment(Orders order,PaymentRequestDto pdto) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		
		payment.setOrder(order);
		
		payment.setCustomerId(order.getCustomer().getUserId());
		payment.setOrganizationId(order.getOrganisationId());
		payment.setAmount(order.getAmount());
		payment.setPayStatus(pdto.getPayStatus());
		pdao.save(payment);
		order.setPayment(payment);
		orderdao.save(order);
		service.rentEuipment(order.getEquipment().getEqupId());
		return "payment done sucessfully";
	}

}
