package com.example.demoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapi.common.ApiResponse;
import com.example.demoapi.dto.book.BookDto;
import com.example.demoapi.model.book.Book;
import com.example.demoapi.model.book.WishList;
import com.example.demoapi.model.user.User;
import com.example.demoapi.service.AuthenticationService;
import com.example.demoapi.service.BookService;
import com.example.demoapi.service.WishListService;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
	@Autowired
	private WishListService wishListService;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/{token}")
	public ResponseEntity<List<BookDto>> getWishList(@PathVariable("token") String token) {
		int user_id = authenticationService.getUser(token).getId();
		List<WishList> body = wishListService.readWishList(user_id);
		List<BookDto> books = new ArrayList<BookDto>();
		for (WishList wishList : body) {
			books.add(BookService.getDtoFromBook(wishList.getBook()));
		}

		return new ResponseEntity<List<BookDto>>(books, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addWishList(@RequestBody Book book, @RequestParam("token") String token) {
		authenticationService.authenticate(token);
		User user = authenticationService.getUser(token);
		WishList wishList = new WishList(user, book);
		wishListService.createWishlist(wishList);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"), HttpStatus.CREATED);

	}
}
