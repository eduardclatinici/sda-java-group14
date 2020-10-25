package com.sda.cart.transformer;

public interface Transformer<Entity, DTO>{

    Entity toEntity(DTO dto);

    DTO toDTO(Entity entity);
}
