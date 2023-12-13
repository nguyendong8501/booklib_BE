package com.example.demoapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoapi.model.user.AuthenticationToken;
import com.example.demoapi.model.user.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	AuthenticationToken findTokenByUser(User user);

	AuthenticationToken findTokenByToken(String token);
}
