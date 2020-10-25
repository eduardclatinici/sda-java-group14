package com.sda.catalogue.service;

import com.sda.catalogue.dto.AddItemToCartDTO;
import com.sda.catalogue.dto.CartDTO;
import com.sda.catalogue.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String CART_URL = "http://localhost:8081/carts";

    //TODO: addItemToCartDTO quantity < available quantity in Product
    // (get Product with product Repo with productID from AddItemTocartDTO) logic
    public ResponseEntity<Void> addToCart(String buyerUsername, AddItemToCartDTO addItemToCartDTO) {
        addItemToCartDTO.setBuyerUsername(buyerUsername);
        return restTemplate.postForEntity(CART_URL, addItemToCartDTO, Void.class);
    }

    public ResponseEntity<CartDTO> getCartByUsername(String buyerUsername) {
        return restTemplate.getForEntity(CART_URL+"/"+buyerUsername, CartDTO.class);
    }
}
