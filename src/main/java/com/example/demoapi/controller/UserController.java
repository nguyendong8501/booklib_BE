package com.example.demoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapi.dto.ResponseDto;
import com.example.demoapi.dto.user.SignInDto;
import com.example.demoapi.dto.user.SignInResponseDto;
import com.example.demoapi.dto.user.SignupDto;
import com.example.demoapi.exceptions.AuthenticationFailException;
import com.example.demoapi.exceptions.CustomException;
import com.example.demoapi.model.user.User;
import com.example.demoapi.respository.UserRepository;
import com.example.demoapi.service.AuthenticationService;
import com.example.demoapi.service.UserService;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
		authenticationService.authenticate(token);
		return userRepository.findAll();
	}

	@PostMapping("/signup")
	public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
		return userService.signUp(signupDto);
	}

	// TODO token should be updated
	@PostMapping("/signIn")
	public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
		return userService.signIn(signInDto);
	}
	
//	@PostMapping("/updateUser")
//  public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//      authenticationService.authenticate(token);
//      return userService.updateUser(token, userUpdateDto);
//  }


//  @PostMapping("/createUser")
//  public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
//          throws CustomException, AuthenticationFailException {
//      authenticationService.authenticate(token);
//      return userService.createUser(token, userCreateDto);
//  }
}
