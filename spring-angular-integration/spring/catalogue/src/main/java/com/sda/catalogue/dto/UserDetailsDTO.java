package com.sda.catalogue.dto;

import com.sda.catalogue.domain.Role;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class UserDetailsDTO {

    @NotNull
    String username;

    String password;

    @NotNull
    Role role;
}
