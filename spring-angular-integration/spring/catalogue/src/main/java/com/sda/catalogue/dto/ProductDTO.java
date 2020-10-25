package com.sda.catalogue.dto;

import com.sda.catalogue.constraints.ProductDTOSellerRoleConstraint;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class ProductDTO {

    Long id;

    @NotNull
    @Length(max = 50)
    String name;

    @Length(max = 255)
    String description;

    @NotNull
    @Min(0)
    BigDecimal price;

    @NotNull
    @Min(0)
    Integer quantity;

    @Min(0)
    @Max(5)
    BigDecimal rating;

    List<@Range(min = 1, max = 5) Integer> reviews;

    @NotNull
    @ProductDTOSellerRoleConstraint
    String sellerUsername;

    String sellerName;

}
