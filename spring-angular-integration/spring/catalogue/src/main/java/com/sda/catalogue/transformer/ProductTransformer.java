package com.sda.catalogue.transformer;

import com.sda.catalogue.domain.Product;
import com.sda.catalogue.domain.User;
import com.sda.catalogue.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer{

    public Product toEntity(ProductDTO productDTO, User seller) {
       Product product = new Product();
       product.setName(productDTO.getName());
       product.setDescription(productDTO.getDescription());
       product.setPrice(productDTO.getPrice());
       product.setQuantity(productDTO.getQuantity());
       product.setRating(productDTO.getRating());
       product.setReviews(productDTO.getReviews());
       product.setSeller(seller);
       return product;
    }

    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .rating(product.getRating())
                .reviews(product.getReviews())
                .sellerName(product.getSeller().getName())
                .sellerUsername(product.getSeller().getUserDetails().getUsername())
                .build();
    }
}
