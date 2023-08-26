package com.heavyrent.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavyrent.pojo.Orders;
import com.heavyrent.pojo.User;

public interface OrderDao  extends JpaRepository<Orders, Long>{

	
	 List<Orders> findAllByOrganisationIdOrderByOrderOnDesc(long OrganisationId);
	 List<Orders> findAllByCustomerOrderByOrderOnDesc(User Customer);
	 List<Orders> findAllByOrganisationIdAndOrderDate(long org_id,Date date);
}
