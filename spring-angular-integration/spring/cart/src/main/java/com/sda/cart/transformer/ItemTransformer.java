package com.sda.cart.transformer;

import com.sda.cart.domain.Item;
import com.sda.cart.dto.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemTransformer implements Transformer<Item, ItemDTO>{
    @Override
    public Item toEntity(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public ItemDTO toDTO(Item item) {
        return ItemDTO.builder()
                .productId(item.getProductId())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }
}
