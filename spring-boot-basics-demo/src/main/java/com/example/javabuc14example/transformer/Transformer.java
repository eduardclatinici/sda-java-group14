package com.example.javabuc14example.transformer;

public interface Transformer<Entity, DTO> {

    Entity toEntity(DTO dto);

    DTO toDTO(Entity entity);
}
