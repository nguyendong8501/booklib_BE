package com.example.demoapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoapi.model.book.Category;
@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer> {
	Category findByCategoryName(String categoryName);
}
