package com.example.flipkartclone.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "Paginated_Product")
public class ProductPagination {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;

    public ProductPagination(String name, int price){
        this.name = name;
        this.price = price;
    }
}
