package com.sda.catalogue.controller;

import com.sda.catalogue.domain.User;
import com.sda.catalogue.dto.ProductDTO;
import com.sda.catalogue.service.ProductService;
import com.sda.catalogue.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody @Validated ProductDTO productDTO) {
       User seller = userService.findByUsername(productDTO.getSellerUsername());
        if(seller == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found");
        }
        return productService.saveProduct(productDTO, seller);
    }

}
