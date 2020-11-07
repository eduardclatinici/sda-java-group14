package com.sda.catalogue.service;

import com.sda.catalogue.domain.Product;
import com.sda.catalogue.repository.ProductRepository;
import com.sda.catalogue.transformer.ProductTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ProductServiceUnitTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    ProductTransformer productTransformer;

    ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService(productRepository, productTransformer);
    }

    @Test
    public void smth() {
        Product product = new Product();
        List<Product> products = Arrays.asList(product);
        when(productRepository.findAll()).thenReturn(products);
        productService.getProducts();
        verify(productRepository).findAll();
        verify(productTransformer).toDTO(product);
        verifyNoMoreInteractions(productRepository, productTransformer);
    }
}
