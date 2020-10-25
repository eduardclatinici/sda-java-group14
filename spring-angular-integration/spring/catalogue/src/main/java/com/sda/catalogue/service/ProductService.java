package com.sda.catalogue.service;

import com.sda.catalogue.domain.User;
import com.sda.catalogue.dto.ProductDTO;
import com.sda.catalogue.repository.ProductRepository;
import com.sda.catalogue.transformer.ProductTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTransformer productTransformer;

    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(productTransformer::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO saveProduct(ProductDTO dto, User seller) {
        return productTransformer.toDTO(productRepository.save(productTransformer.toEntity(dto, seller)));
    }
}
