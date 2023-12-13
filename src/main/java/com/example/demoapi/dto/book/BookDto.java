package com.example.demoapi.dto.book;

import javax.validation.constraints.NotNull;

import com.example.demoapi.model.book.Book;

public class BookDto {
	private Integer id;
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;
	public BookDto(@NotNull String name, @NotNull String imageURL, @NotNull double price, @NotNull String description,
			@NotNull Integer categoryId) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}
    
	public BookDto(Book book) {
        this.setId(book.getId());
        this.setName(book.getName());
        this.setImageURL(book.getImageURL());
        this.setDescription(book.getDescription());
        this.setPrice(book.getPrice());
        this.setCategoryId(book.getCategory().getId());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
