package com.example.demoapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoapi.dto.book.BookDto;
import com.example.demoapi.exceptions.ProductNotExistException;
import com.example.demoapi.model.book.Book;
import com.example.demoapi.model.book.Category;
import com.example.demoapi.respository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<BookDto> listProducts() {
		List<Book> books = bookRepository.findAll();
		List<BookDto> productDtos = new ArrayList<>();
		for (Book book : books) {
			BookDto productDto = getDtoFromBook(book);
			productDtos.add(productDto);
		}
		return productDtos;
	}

	public static BookDto getDtoFromBook(Book book) {
		BookDto productDto = new BookDto(book);
		return productDto;
	}

	public static Book getBookFromDto(BookDto bookDto, Category category) {
		Book book = new Book(bookDto, category);
		return book;
	}

	public void addBook(BookDto bookDto, Category category) {
		Book book = getBookFromDto(bookDto, category);
		bookRepository.save(book);
	}

	public void updateProduct(Integer bookID, BookDto bookDto, Category category) {
		Book book = getBookFromDto(bookDto, category);
		book.setId(bookID);
		bookRepository.save(book);
	}

	public Book getBookById(Integer bookId) throws ProductNotExistException {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent())
			throw new ProductNotExistException("Product id is invalid " + bookId);
		return optionalBook.get();
	}
}
