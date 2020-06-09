package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.domain.Order;
import com.ibm.domain.ProductInfo;
import com.ibm.repository.OrderRepo;
import com.ibm.repository.ProductRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	ProductRepo productRepo;

	public List<Order> findAll() {
		return orderRepo.findAllByOrderByOrderStatusAscCreateTimeAsc();
	}

	public Order findOne(Long orderId) throws Exception {
		Order order = orderRepo.findByOrderId(orderId);
		if (order == null) {
			throw new Exception("No Order Found");
		}
		return order;
	}

	public void cancel(Long orderId) throws Exception {
		Order order = findOne(orderId);

		order.setOrderStatus("Cancelled");
		orderRepo.save(order);

		 increaseStock(order.getProducts(), order.getOrderAmount());
	}

	public void increaseStock(List<ProductInfo> productinfo, Double amount) {
		for (int i = 0; i < productinfo.size(); i++) {
			ProductInfo productInfo = productRepo.findFirstByProductId(productinfo.get(i).getProductId());

			int update = (int) (productInfo.getProductStock() + amount);
			productInfo.setProductStock(update);
			productRepo.save(productInfo);
		}
	}
}
