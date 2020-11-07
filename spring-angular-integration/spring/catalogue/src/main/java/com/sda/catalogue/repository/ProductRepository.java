package com.sda.catalogue.repository;

import com.sda.catalogue.domain.Product;
import com.sda.catalogue.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select quantity from product where id = :id",nativeQuery = true)
    ProductProjection findProductQuantityByProductId(Long id);
}
