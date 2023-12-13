package com.example.demoapi.dto.cart;

import javax.validation.constraints.NotNull;

public class AddToCartDto {
	private Integer id;
	private @NotNull Integer productId;
	private @NotNull Integer quantity;

	public AddToCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AddToCartDto [id=" + id + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
