package com.example.demoapi.dto.cart;

import javax.validation.constraints.NotNull;

import com.example.demoapi.model.book.Book;
import com.example.demoapi.model.book.Cart;

public class CartItemDto {
	private Integer id;
	private @NotNull Integer quantity;
	private @NotNull Book book;

	
	 @Override
	    public String toString() {
	        return "CartDto{" +
	                "id=" + id +
	                ", quantity=" + quantity +
	                ", bookName=" + book.getName() +
	                '}';
	    }
	public CartItemDto(Cart cart) {
		this.setId(cart.getId());
		this.setQuantity(cart.getQuantity());
		this.setBook(cart.getBook());
	}

	public CartItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
