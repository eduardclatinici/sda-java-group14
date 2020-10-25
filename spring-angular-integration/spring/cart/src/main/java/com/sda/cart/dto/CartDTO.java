package com.sda.cart.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class CartDTO {
    String buyerUsername;
    BigDecimal totalPrice;
    List<ItemDTO> items;
}
