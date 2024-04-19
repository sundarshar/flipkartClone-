package com.example.flipkartclone.Repository;

import com.example.flipkartclone.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save (Product p);
    Product findByIdIs(long productId);
    void deleteById(long productId);
    List<Product> findAll();
    List<Product> findAllByCategoryTitleIs(String Category);

    //HQL Query
    @Query()

}
