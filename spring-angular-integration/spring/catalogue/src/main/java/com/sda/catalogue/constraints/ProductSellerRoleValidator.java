package com.sda.catalogue.constraints;

import com.sda.catalogue.domain.Role;
import com.sda.catalogue.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductSellerRoleValidator implements
        ConstraintValidator<ProductSellerRoleConstraint, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        return Role.SELLER.equals(user.getUserDetails().getRole());
    }
}
