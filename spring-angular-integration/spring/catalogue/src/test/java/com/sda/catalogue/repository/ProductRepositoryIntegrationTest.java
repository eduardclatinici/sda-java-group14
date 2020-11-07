package com.sda.catalogue.repository;

import com.sda.catalogue.domain.Product;
import com.sda.catalogue.domain.Role;
import com.sda.catalogue.domain.User;
import com.sda.catalogue.domain.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldSaveDataInDb() {
        User user = userRepository.save(getSeller());
        Product product = productRepository.save(getProduct(user));
        assertEquals("name123", product.getName());
        assertEquals(new BigDecimal("123.53412"), product.getPrice());
        assertEquals(78, product.getQuantity());
        assertEquals("07821649673", product.getSeller().getPhoneNumber());
    }

    @Test
    public void shouldReturnCorrectProductQuantity(){
        User user = userRepository.save(getSeller());
        Product product = productRepository.save(getProduct(user));
        Integer quantity = productRepository.findProductQuantityByProductId(product.getId()).getQuantity();
        assertEquals(78, quantity);
    }

    public Product getProduct(User user){
        Product product = new Product();
        product.setName("name123");
        product.setPrice(new BigDecimal("123.53412"));
        product.setQuantity(78);
        product.setSeller(user);
        return product;
    }

    public User getSeller(){
        User user = new User();
        user.setName("nume");
        user.setAddress("adresa");
        user.setPhoneNumber("07821649673");
        user.setUserDetails(getSellerDetails());
        return user;
    }

    public UserDetails getSellerDetails(){
        UserDetails userDetails = new UserDetails();
        userDetails.setRole(Role.SELLER);
        userDetails.setPassword("asd");
        userDetails.setUsername("ads");
        return userDetails;
    }
}
