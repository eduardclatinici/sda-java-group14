package com.sda.catalogue.repository;

import com.sda.catalogue.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
