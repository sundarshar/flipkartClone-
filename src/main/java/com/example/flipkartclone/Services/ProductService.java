package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product getSingleProduct(Long id);

    Product createProduct(ProductDto request);

    List<Product> getAllProducts();
}
