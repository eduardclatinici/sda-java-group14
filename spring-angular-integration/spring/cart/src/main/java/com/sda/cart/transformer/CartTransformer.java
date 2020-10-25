package com.sda.cart.transformer;

import com.sda.cart.domain.Cart;
import com.sda.cart.dto.CartDTO;
import com.sda.cart.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartTransformer implements Transformer<Cart, CartDTO>{

    private final ItemTransformer itemTransformer;

    @Override
    public Cart toEntity(CartDTO cartDTO) {
        return null;
    }

    @Override
    public CartDTO toDTO(Cart cart) {
        List<ItemDTO> transformedItems =
                cart.getItems() == null ? Collections.emptyList() :
                cart.getItems().stream()
                .map(itemTransformer::toDTO).collect(Collectors.toList());
        return CartDTO.builder()
                .buyerUsername(cart.getBuyerUsername())
                .totalPrice(cart.getTotalPrice())
                .items(transformedItems)
                .build();
    }
}
