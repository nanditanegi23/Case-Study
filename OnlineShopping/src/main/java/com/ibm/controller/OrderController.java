package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.domain.Order;
import com.ibm.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/order")
	public ResponseEntity<List<Order>> OrderList() {
		List<Order> orderList;
		//Get user details from  user table & token from security MS 
//			orderList = orderService.findByBuyerEmail(//user email id);
			orderList = orderService.findAll();
		return ResponseEntity.ok().body(orderList);
	}

	@GetMapping("/order/cancel/{id}")
	public void cancel(@PathVariable("id") Long orderId) throws Exception {
		Order orderMain = orderService.findOne(orderId);
		//Verify Accound by emil Id from user table and role to cancel order
		
		orderService.cancel(orderId);
	}
	
	
	@GetMapping("/order/show/{id}")
    public ResponseEntity<Order> show(@PathVariable("id") Long orderId) throws Exception{
		//Verify emil and role to view
        Order order = orderService.findOne(orderId);

        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

}
