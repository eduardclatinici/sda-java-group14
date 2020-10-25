package com.sda.cart.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ItemDTO {

    Long productId;

    BigDecimal price;

    Integer quantity;
}
