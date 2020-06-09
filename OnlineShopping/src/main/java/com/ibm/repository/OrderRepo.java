package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.domain.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

	   Order findByOrderId(Long orderId);

	   List<Order> findAllByOrderByOrderStatusAscCreateTimeAsc();

}