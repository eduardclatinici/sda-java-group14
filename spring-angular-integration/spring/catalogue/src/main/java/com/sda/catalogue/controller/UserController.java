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

    //@RequestMapping(value = "/users")
    @PostMapping("/{buyer_username}/add-to-cart")
//    @RequestMapping(value = "/users/{buyer_username}/add-to-cart", method = RequestMethod.POST)
    //http://localhost:8080/users/{buyer_username}/add-to-cart
    //http://localhost:8080/users/asdfag/add-to-cart
    //http://localhost:8080/users/edi/add-to-cart
    public ResponseEntity<Void> addProductToBuyersCart(@PathVariable("buyer_username") String buyerUsername, @RequestBody AddItemToCartDTO addItemToCartDTO){
       ResponseEntity<Void> response = cartService.addToCart(buyerUsername, addItemToCartDTO);
       return ResponseEntity.status(response.getStatusCode()).build();
    }

    //@RequestMapping(value = "/users")
    @GetMapping("/{buyer_username}/cart")
    //http://localhost:8080/users/{buyer_username}/cart
    public ResponseEntity<CartDTO> getCartByUsername(@PathVariable(name = "buyer_username") String buyerUsername){
        return cartService.getCartByUsername(buyerUsername);
    }
}
