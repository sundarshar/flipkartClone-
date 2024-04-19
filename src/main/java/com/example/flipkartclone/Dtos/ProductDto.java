package com.example.flipkartclone.Dtos;

import com.example.flipkartclone.Model.Category;
import com.example.flipkartclone.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImage(image);

        Category category1 = new Category();
        category1.setName(category);
        product.setCategory(category1);
        return product;
    }
}
