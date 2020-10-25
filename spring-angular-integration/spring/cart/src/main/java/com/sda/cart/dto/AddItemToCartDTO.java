package com.sda.cart.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class AddItemToCartDTO {
    Long productId;
    Integer quantity;
    BigDecimal price;
    String buyerUsername;
}
