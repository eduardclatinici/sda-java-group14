package com.sda.catalogue.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@Builder
public class UserDTO {

    Long id;

    @NotNull
    String name;

    @NotNull
    String address;

    @NotNull
    String phoneNumber;

    BigDecimal rating;

    @NotNull
    UserDetailsDTO userDetailsDTO;
}
