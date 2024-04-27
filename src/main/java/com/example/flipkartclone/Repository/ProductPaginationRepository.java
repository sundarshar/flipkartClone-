package com.example.flipkartclone.Repository;

import com.example.flipkartclone.Model.ProductPagination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPaginationRepository extends JpaRepository<ProductPagination, Long> {
}
