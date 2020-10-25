package com.sda.cart.controller;

import com.sda.cart.dto.CartDTO;
import com.sda.cart.dto.AddItemToCartDTO;
import com.sda.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public List<CartDTO> getCarts(){
        return cartService.getCarts();
    }

    @PostMapping
    public CartDTO addItemToCart(@RequestBody AddItemToCartDTO addItemToCartDTO){
        return cartService.addItemToCart(addItemToCartDTO);
    }

    @GetMapping(value = "/{buyer_username}")
    public CartDTO getCartByUsername(@PathVariable(name = "buyer_username") String buyerUsername){
        return cartService.getCartByBuyerUsername(buyerUsername);
    }
}
