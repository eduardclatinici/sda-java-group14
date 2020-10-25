package com.sda.cart.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "buyer_username", unique = true)
    private String buyerUsername;

    @Column(name = "total_price")
    private BigDecimal totalPrice = new BigDecimal("0");

    @OneToMany(mappedBy = "cart")
    private List<Item> items;
}
