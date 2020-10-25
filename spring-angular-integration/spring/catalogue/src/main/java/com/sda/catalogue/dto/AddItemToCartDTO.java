package com.sda.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class AddItemToCartDTO {

    Long productId;
    Integer quantity;
    BigDecimal price;
    String buyerUsername;
}
