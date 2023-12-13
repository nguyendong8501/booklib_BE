package com.example.demoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoapi.config.MessageStrings;
import com.example.demoapi.exceptions.AuthenticationFailException;
import com.example.demoapi.model.user.AuthenticationToken;
import com.example.demoapi.model.user.User;
import com.example.demoapi.respository.TokenRepository;
import com.example.demoapi.utils.Helper;

@Service
public class AuthenticationService {
	@Autowired
	TokenRepository repository;

	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		repository.save(authenticationToken);
	}

	public AuthenticationToken getToken(User user) {
		return repository.findTokenByUser(user);
	}

	public User getUser(String token) {
		AuthenticationToken authenticationToken = repository.findTokenByToken(token);
		if (Helper.notNull(authenticationToken)) {
			if (Helper.notNull(authenticationToken.getUser())) {
				return authenticationToken.getUser();
			}
		}
		return null;
	}

	public void authenticate(String token) throws AuthenticationFailException {
		if (!Helper.notNull(token)) {
			throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_PRESENT);
		}
		if (!Helper.notNull(getUser(token))) {
			throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_VALID);
		}
	}
}
