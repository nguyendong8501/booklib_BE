package com.example.demoapi.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoapi.model.book.Cart;
import com.example.demoapi.model.user.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

	List<Cart> deleteByUser(User user);
}
