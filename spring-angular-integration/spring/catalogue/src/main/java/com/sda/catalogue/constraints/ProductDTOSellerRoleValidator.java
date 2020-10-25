package com.sda.catalogue.constraints;

import com.sda.catalogue.domain.Role;
import com.sda.catalogue.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ProductDTOSellerRoleValidator implements ConstraintValidator<ProductDTOSellerRoleConstraint, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        return Role.SELLER.equals(userService.findRoleByUsername(username));
    }
}
