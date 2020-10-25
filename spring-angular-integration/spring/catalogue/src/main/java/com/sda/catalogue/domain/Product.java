package com.sda.catalogue.domain;

import com.sda.catalogue.constraints.ProductSellerRoleConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(max = 50)
    private String name;

    @Length(max = 255)
    private String description;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer quantity;

    @Min(0)
    @Max(5)
    private BigDecimal rating;

    @ElementCollection
    private List<@Range(min = 1, max = 5) Integer> reviews;

    @ProductSellerRoleConstraint
    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

}
