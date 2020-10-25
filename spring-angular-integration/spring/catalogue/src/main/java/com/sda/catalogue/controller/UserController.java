package com.sda.catalogue.controller;

import com.sda.catalogue.dto.AddItemToCartDTO;
import com.sda.catalogue.dto.CartDTO;
import com.sda.catalogue.dto.UserDTO;
import com.sda.catalogue.service.CartService;
import com.sda.catalogue.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final CartService cartService;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO sellerDTO) {
        return this.userService.saveUser(sellerDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/{buyer_username}/add-to-cart")
    public ResponseEntity<Void> addProductToBuyersCart(@PathVariable("buyer_username") String buyerUsername, @RequestBody AddItemToCartDTO addItemToCartDTO){
       ResponseEntity<Void> response = cartService.addToCart(buyerUsername, addItemToCartDTO);
       return ResponseEntity.status(response.getStatusCode()).build();
    }

    @GetMapping("/{buyer_username}/cart")
    public ResponseEntity<CartDTO> getCartByUsername(@PathVariable(name = "buyer_username") String buyerUsername){
        return cartService.getCartByUsername(buyerUsername);
    }
}
