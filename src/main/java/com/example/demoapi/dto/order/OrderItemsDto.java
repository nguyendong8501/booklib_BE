package com.example.demoapi.dto.order;

import javax.validation.constraints.NotNull;

public class OrderItemsDto {
	private @NotNull double price;
	private @NotNull int quantity;
	private @NotNull int orderId;
	private @NotNull int bookId;

	public OrderItemsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemsDto(@NotNull double price, @NotNull int quantity, @NotNull int orderId, @NotNull int bookId) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.orderId = orderId;
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
