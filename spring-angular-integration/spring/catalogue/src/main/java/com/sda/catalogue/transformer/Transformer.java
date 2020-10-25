package com.sda.catalogue.transformer;

public interface Transformer <Entity, DTO>{

    Entity toEntity(DTO dto);

    DTO toDTO(Entity entity);
}
