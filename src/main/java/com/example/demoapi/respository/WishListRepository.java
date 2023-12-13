package com.example.demoapi.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoapi.model.book.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
	List<WishList> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
}
