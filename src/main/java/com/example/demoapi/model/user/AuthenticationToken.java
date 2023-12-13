package com.example.demoapi.model.user;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "tokens")
public class AuthenticationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	private String token;

	@Column(name = "created_date")
	private Date createdDate;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AuthenticationToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationToken(Integer id, String token, Date createdDate, User user) {
		super();
		this.id = id;
		this.token = token;
		this.createdDate = createdDate;
		this.user = user;
	}

	public AuthenticationToken(User user) {
		this.user = user;
		this.createdDate = new Date();
		this.token = UUID.randomUUID().toString();
	}
}
