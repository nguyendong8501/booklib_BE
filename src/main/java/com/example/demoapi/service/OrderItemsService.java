package com.example.demoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoapi.model.order.OrderItem;
import com.example.demoapi.respository.OrderItemsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemsService {
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	public void addOrderedProducts(OrderItem orderItem) {
		orderItemsRepository.save(orderItem);
	}
}
