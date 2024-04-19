package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProducts")
public class OwnProductServices implements ProductService{
    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
