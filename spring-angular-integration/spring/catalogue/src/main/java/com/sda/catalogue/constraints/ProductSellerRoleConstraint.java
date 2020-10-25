package com.sda.catalogue.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductSellerRoleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductSellerRoleConstraint {

    String message() default "{validation.user_role.invalid}";

    String fieldName() default "seller";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
