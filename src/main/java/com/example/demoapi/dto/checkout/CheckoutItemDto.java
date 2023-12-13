package com.example.demoapi.dto.checkout;

public class CheckoutItemDto {
	private String productName;
	private int quantity;
	private double price;
	private long bookId;
	private int userId;

	public CheckoutItemDto(String productName, int quantity, double price, long bookId, int userId) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.bookId = bookId;
		this.userId = userId;
	}

	public CheckoutItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
