package com.sda.catalogue.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductDTOSellerRoleValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductDTOSellerRoleConstraint {
    String message() default "{validation.user_role.invalid}";

    String fieldName() default "sellerUsername";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
