package com.example.demoapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapi.common.ApiResponse;
import com.example.demoapi.dto.book.BookDto;
import com.example.demoapi.model.book.Category;
import com.example.demoapi.service.BookService;
import com.example.demoapi.service.CategoryService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public ResponseEntity<List<BookDto>> getProducts() {
		List<BookDto> body = bookService.listProducts();
		return new ResponseEntity<List<BookDto>>(body, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody BookDto bookDto) {
		Optional<Category> optionalCategory = categoryService.readCategory(bookDto.getCategoryId());
		if (!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
		}
		Category category = optionalCategory.get();
		bookService.addBook(bookDto, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Book has been added"), HttpStatus.CREATED);
	}

	@PostMapping("/update/{bookID}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable("bookID") Integer bookID,
			@RequestBody @Valid BookDto bookDto) {
		Optional<Category> optionalCategory = categoryService.readCategory(bookDto.getCategoryId());
		if (!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
		}
		Category category = optionalCategory.get();
		bookService.updateProduct(bookID, bookDto, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
	}
}
