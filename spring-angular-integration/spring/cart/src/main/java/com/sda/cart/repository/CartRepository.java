package com.sda.cart.repository;

import com.sda.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByBuyerUsername(String username);
}
