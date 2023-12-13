package com.heavyrent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.el.stream.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavyrent.custom_exception.ResourceNotFoundException;
import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.dao.OrderDao;
import com.heavyrent.dto.OrderRequestDto;
import com.heavyrent.dto.OrderResponseDto;
import com.heavyrent.dto.UserResponse;
import com.heavyrent.pojo.Equipment;
import com.heavyrent.pojo.OrderStatus;
import com.heavyrent.pojo.Orders;
import com.heavyrent.pojo.Payment;
import com.heavyrent.pojo.User;
import com.heavyrent.pojo.Wishlist;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl  implements OrderService{

	@Autowired
	private EquipmentDao equipmentdao;
	
	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EquimentManagementService service;


	@Override
	public Orders placeOrderService(OrderRequestDto odto, Equipment equipment, User user) {
		// TODO Auto-generated method stub
		
		//Equipment equip=equipmentdao.findById(odto.getEquipId()).orElseThrow(()->new ResourceNotFoundException("Equipment not found"));
		Orders order = new Orders();
		order.setCustomer(user);
		order.setEquipment(equipment);
		order.setAddress(odto.getOrderaddress());
		order.setAmount(odto.getAmount());
		order.setOrderOn(odto.getOrderOn());
		order.setOrderDate(odto.getOrderDate());
		order.setCostPerDay(odto.getCostPerDay());
		order.setOrderStatus(odto.getOrderStatus());
		order.setOrderTill(odto.getOrderTill());
		order.setOrganisationId(equipment.getOrganization().getUserId());
		order.setReturnStatus(false);
		Orders or=orderdao.save(order);
		return  or;
	}

	@Override
	public List<OrderResponseDto> getOrderForOrg(long org_id) {
		// TODO Auto-generated method stub
		List<Orders> ord=orderdao.findAllByOrganisationIdOrderByOrderOnDesc(org_id);
		List<OrderResponseDto> orderdto=new ArrayList<>();
		       
            for (Orders o : ord) {
            	OrderResponseDto dto = new OrderResponseDto();
            	Equipment equipment = new Equipment();
            	dto.setOrderId(o.getOrderId());
                dto.setOrderOn(o.getOrderOn());
                dto.setOrderTill(o.getOrderTill());
                dto.setReturnStatus(o.isReturnStatus());
                dto.setCostPerDay(o.getCostPerDay());
                dto.setOrderStatus(o.getOrderStatus());
                dto.setOrderDate(o.getOrderDate());
               //dto.setEquipment(o.getEquipment()); 
                equipment.setEquip_img1(o.getEquipment().getEquip_img1());   
                equipment.setEqupId(o.getEquipment().getEqupId());;
                equipment.setEquipmentName(o.getEquipment().getEquipmentName());
                equipment.setCity(o.getEquipment().getCity());
                equipment.setModelNo(o.getEquipment().getModelNo());
                dto.setAmount(o.getAmount());
                dto.setEquipment(equipment);
                orderdto.add(dto);
		}
		return orderdto;
	}

	
	@Override
	public String confirmOrder(long ord_id) {
		// TODO Auto-generated method stub
		Orders Order =orderdao.findById(ord_id).orElseThrow(()->new ResourceNotFoundException("order not found"));

        
           Order.setOrderStatus(OrderStatus.CONFIRMED);
           orderdao.save(Order);
        
    
		return "order confirmed";
	}
	@Override
	public Orders getOrderById(long ord_id) {
		// TODO Auto-generated method stub
		Orders ord1 =orderdao.findById(ord_id).orElseThrow(()->new ResourceNotFoundException("order not found"));

		return ord1;
	}

	

	@Override
	public String returnOrder(long ord_id) {
		// TODO Auto-generated method stub
		Orders ord1 =orderdao.findById(ord_id).orElseThrow(()->new ResourceNotFoundException("order not found"));
		ord1.setReturnStatus(true);
		orderdao.save(ord1);
		service.enableEquipment(ord1.getEquipment().getEqupId());
		return "equipment returned successfully";
	}

	@Override
	public List<OrderResponseDto> getOrderForCust(User cust) {
		// TODO Auto-generated method stub
		List<Orders> ord=orderdao.findAllByCustomerOrderByOrderOnDesc(cust);
		List<OrderResponseDto> orderdto=new ArrayList<>();
		       
            for (Orders o : ord) {
            	OrderResponseDto dto = new OrderResponseDto();
            	Equipment equipment = new Equipment();
            	Payment payment = new Payment();
            	dto.setOrderId(o.getOrderId());
                dto.setOrderOn(o.getOrderOn());
                dto.setOrderTill(o.getOrderTill());
                dto.setReturnStatus(o.isReturnStatus());
                dto.setCostPerDay(o.getCostPerDay());
                dto.setOrderStatus(o.getOrderStatus());
                dto.setOrderDate(o.getOrderDate());
               //dto.setEquipment(o.getEquipment()); 
                payment.setPaymentId(o.getPayment().getPaymentId());
                payment.setPayStatus(o.getPayment().getPayStatus());
                equipment.setEquip_img1(o.getEquipment().getEquip_img1());   
                equipment.setEqupId(o.getEquipment().getEqupId());;
                equipment.setEquipmentName(o.getEquipment().getEquipmentName());
                equipment.setCity(o.getEquipment().getCity());
                equipment.setModelNo(o.getEquipment().getModelNo());
                dto.setAmount(o.getAmount());
                dto.setEquipment(equipment);
                dto.setPayment(payment);
                orderdto.add(dto);
		}
		
		return orderdto;
	}

	 @Override
		public List<OrderResponseDto> getTodaysOrderOfOrg(long org_id,Date date) {
			List<Orders> ord=orderdao.findAllByOrganisationIdAndOrderDate(org_id, date);
			List<OrderResponseDto> orderdto=new ArrayList<>();
			Equipment equipment = new Equipment();
			Payment payment = new Payment();
			for(Orders o : ord) {
				payment.setPaymentId(o.getPayment().getPaymentId());
	            payment.setPayStatus(o.getPayment().getPayStatus());
				equipment.setEquip_img1(o.getEquipment().getEquip_img1());   
		        equipment.setEqupId(o.getEquipment().getEqupId());;
		        equipment.setEquipmentName(o.getEquipment().getEquipmentName());
		        equipment.setCity(o.getEquipment().getCity());
		        equipment.setModelNo(o.getEquipment().getModelNo());
		        o.setEquipment(equipment);
		        o.setPayment(payment);
		        orderdto.add(mapper.map(o, OrderResponseDto.class));
			}
			
			return orderdto;
		}

	@Override
	public Orders getOrder(long ord_id) {
		// TODO Auto-generated method stub
		Orders ord1 =orderdao.findById(ord_id).orElseThrow(()->new ResourceNotFoundException("order not found"));
		
		return ord1;
	}



}
