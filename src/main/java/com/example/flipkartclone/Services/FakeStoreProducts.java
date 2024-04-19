package com.example.flipkartclone.Services;

import com.example.flipkartclone.Dtos.ProductDto;
import com.example.flipkartclone.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProduct")
public class FakeStoreProducts implements ProductService{

    RestTemplate restTemplate = new RestTemplate();
    public FakeStoreProducts(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        ProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                ProductDto.class
        );
        return productDto.toProduct();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        ProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                productDto,
                ProductDto.class
        );
        return response.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {
        ProductDto[] productDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                ProductDto[].class);

        List<Product> product = new ArrayList<>();
        for(ProductDto productDto : productDtos){
            product.add(productDto.toProduct());
        }
        return product;
    }
}
