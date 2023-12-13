package com.example.demoapi.dto.order;

import javax.validation.constraints.NotNull;

import com.example.demoapi.model.order.Order;

public class OrderDto {
	private Integer id;
	private @NotNull Integer userId;

	public OrderDto(Order order) {
		super();
		this.setId(order.getId());
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
