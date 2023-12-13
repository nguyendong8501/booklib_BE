package com.example.demoapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoapi.model.order.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {

}
