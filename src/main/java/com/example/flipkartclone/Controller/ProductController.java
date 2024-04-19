package com.example.flipkartclone.Controller;

import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Model.Product;
import com.example.flipkartclone.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    public ProductService productService;
    public ProductController(@Qualifier("fakeStoreProduct") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductDto request){
        return productService.createProduct(request);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }


}
