package com.sda.catalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CartDTO {
    String buyerUsername;
    BigDecimal totalPrice;
    List<ItemDTO> items;
}
