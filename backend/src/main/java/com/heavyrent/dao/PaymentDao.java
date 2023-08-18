package com.heavyrent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavyrent.pojo.Payment;

public interface PaymentDao extends JpaRepository<Payment, Long>{

}
