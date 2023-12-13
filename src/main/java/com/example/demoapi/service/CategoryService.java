package com.example.demoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demoapi.model.book.Category;
import com.example.demoapi.respository.Categoryrepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
	private final Categoryrepository categoryrepository;

	public CategoryService(Categoryrepository categoryrepository) {
		this.categoryrepository = categoryrepository;
	}

	public List<Category> listCategories() {
		return categoryrepository.findAll();
	}

	public void createCategory(Category category) {
		categoryrepository.save(category);
	}

	public Category readCategory(String categoryName) {
		return categoryrepository.findByCategoryName(categoryName);
	}

	public Optional<Category> readCategory(Integer categoryId) {
		return categoryrepository.findById(categoryId);
	}

	public void updateCategory(Integer categoryID, Category newCategory) {
		Category category = categoryrepository.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		category.setBooks(newCategory.getBooks());
		category.setImageUrl(newCategory.getImageUrl());

		categoryrepository.save(category);
	}
}
