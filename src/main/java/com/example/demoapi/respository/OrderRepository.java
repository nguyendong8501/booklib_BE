package com.example.demoapi.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoapi.model.order.Order;
import com.example.demoapi.model.user.User;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findAllByUserOrderByCreatedDateDesc(User user);
}
