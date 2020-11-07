package com.sda.catalogue.controller;

import com.sda.catalogue.dto.AddItemToCartDTO;
import com.sda.catalogue.dto.CartDTO;
import com.sda.catalogue.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@Slf4j
public class CartController {

    private final CartService cartService;

    //@RequestMapping(value = "/users")
    @PostMapping("/{buyer_username}/add-to-cart")
//    @RequestMapping(value = "/users/{buyer_username}/add-to-cart", method = RequestMethod.POST)
    //http://localhost:8080/users/{buyer_username}/add-to-cart
    //http://localhost:8080/users/asdfag/add-to-cart
    //http://localhost:8080/users/edi/add-to-cart
    public ResponseEntity<Void> addProductToBuyersCart(@PathVariable("buyer_username") String buyerUsername, @RequestBody AddItemToCartDTO addItemToCartDTO) {
        Integer availableQuantity = cartService.getQuantityForProductId(addItemToCartDTO.getProductId());
        if (addItemToCartDTO.getQuantity() > availableQuantity)
        {
            log.error("Insufficient quanity. Requested {} but only {} available", addItemToCartDTO.getQuantity(), availableQuantity);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient quantity");
        }
        ResponseEntity<Void> response = cartService.addToCart(buyerUsername, addItemToCartDTO);
        return ResponseEntity.status(response.getStatusCode()).build();
    }

    //@RequestMapping(value = "/users")
    @GetMapping("/{buyer_username}/cart")
    //http://localhost:8080/users/{buyer_username}/cart
    public ResponseEntity<CartDTO> getCartByUsername(@PathVariable(name = "buyer_username") String buyerUsername) {
        return cartService.getCartByUsername(buyerUsername);
    }
}
