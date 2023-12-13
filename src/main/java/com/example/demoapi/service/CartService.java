package com.example.demoapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoapi.dto.cart.AddToCartDto;
import com.example.demoapi.dto.cart.CartDto;
import com.example.demoapi.dto.cart.CartItemDto;
import com.example.demoapi.exceptions.CartItemNotExistException;
import com.example.demoapi.model.book.Book;
import com.example.demoapi.model.book.Cart;
import com.example.demoapi.model.user.User;
import com.example.demoapi.respository.CartRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	public CartService() {
	}

	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public void addToCart(AddToCartDto addToCartDto, Book book, User user) {
		Cart cart = new Cart(book, addToCartDto.getQuantity(), user);
		cartRepository.save(cart);
	}

	public CartDto listCartItems(User user) {
		List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
		List<CartItemDto> cartItems = new ArrayList<>();
		for (Cart cart : cartList) {
			CartItemDto cartItemDto = getDtoFromCart(cart);
			cartItems.add(cartItemDto);
		}
		double totalCost = 0;
		for (CartItemDto cartItemDto : cartItems) {
			totalCost += (cartItemDto.getBook().getPrice() * cartItemDto.getQuantity());
		}
		return new CartDto(cartItems, totalCost);
	}

	public static CartItemDto getDtoFromCart(Cart cart) {
		return new CartItemDto(cart);
	}

	public void updateCartItem(AddToCartDto cartDto, User user, Book book) {
		Cart cart = cartRepository.getReferenceById(cartDto.getId());
		cart.setQuantity(cartDto.getQuantity());
		cart.setCreatedDate(new Date());
		cartRepository.save(cart);
	}

	public void deleteCartItem(int id, int userId) throws CartItemNotExistException {
		if (!cartRepository.existsById(id))
			throw new CartItemNotExistException("Cart id is invalid : " + id);
		cartRepository.deleteById(id);

	}

	public void deleteCartItems(int userId) {
		cartRepository.deleteAll();
	}

	public void deleteUserCartItems(User user) {
		cartRepository.deleteByUser(user);
	}
}
