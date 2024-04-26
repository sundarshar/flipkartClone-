package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Exception.CategoryNotFoundException;
import com.example.flipkartclone.Exception.ProductNotFoundException;
import com.example.flipkartclone.Model.Category;
import com.example.flipkartclone.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    Product createProduct(ProductDto request);

    List<Product> getAllProducts();

    List<Category> getAllCategory();

    Product updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException;

    void deleteProduct(Long id) throws ProductNotFoundException;

    List<Product> getProductsBasedOnCategory(String category) throws CategoryNotFoundException;


}
