package com.example.demoapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demoapi.model.book.WishList;
import com.example.demoapi.respository.WishListRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class WishListService {
	private final WishListRepository wishListRepository;

	public WishListService(WishListRepository wishListRepository) {
		this.wishListRepository = wishListRepository;
	}

	public void createWishlist(WishList wishList) {
		wishListRepository.save(wishList);
	}

	public List<WishList> readWishList(Integer userId) {
		return wishListRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
	}
}
