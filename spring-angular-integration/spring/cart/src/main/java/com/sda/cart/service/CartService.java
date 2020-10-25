package com.sda.cart.service;

import com.sda.cart.domain.Cart;
import com.sda.cart.domain.Item;
import com.sda.cart.dto.AddItemToCartDTO;
import com.sda.cart.dto.CartDTO;
import com.sda.cart.repository.CartRepository;
import com.sda.cart.repository.ItemRepository;
import com.sda.cart.transformer.CartTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    private final CartTransformer cartTransformer;

    public List<CartDTO> getCarts() {
        return cartRepository.findAll().stream()
                .map(cartTransformer::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public CartDTO addItemToCart(AddItemToCartDTO addItemToCartDTO) {
        Cart cart = cartRepository.findByBuyerUsername(addItemToCartDTO.getBuyerUsername());
        if(cart == null) {
           cart = cartRepository.save(buildCart(addItemToCartDTO.getBuyerUsername()));
        }
        itemRepository.save(buildItem(cart, addItemToCartDTO));
        cart.setTotalPrice(cart.getTotalPrice().add(
                addItemToCartDTO.getPrice().multiply(new BigDecimal(addItemToCartDTO.getQuantity()))
        ));
        cartRepository.save(cart);
        return cartTransformer.toDTO(cartRepository.findByBuyerUsername(addItemToCartDTO.getBuyerUsername()));
    }

    private Cart buildCart(String buyerUsername) {
        Cart cart = new Cart();
        cart.setBuyerUsername(buyerUsername);
        cart.setTotalPrice(new BigDecimal(0));
        return cart;
    }

    private Item buildItem(Cart cart, AddItemToCartDTO addItemToCartDTO) {
        Item item = new Item();
        item.setCart(cart);
        item.setPrice(addItemToCartDTO.getPrice());
        item.setProductId(addItemToCartDTO.getProductId());
        item.setQuantity(addItemToCartDTO.getQuantity());
        return item;
    }

    public CartDTO getCartByBuyerUsername(String buyerUsername) {
        return cartTransformer.toDTO(cartRepository.findByBuyerUsername(buyerUsername));
    }
}
