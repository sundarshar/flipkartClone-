package com.example.flipkartclone.Repository;

import com.example.flipkartclone.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String title);
    List<Category> findAll();
}
