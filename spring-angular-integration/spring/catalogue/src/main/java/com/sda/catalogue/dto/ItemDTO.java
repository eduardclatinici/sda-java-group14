package com.sda.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ItemDTO {

    Long productId;

    BigDecimal price;

    Integer quantity;
}
