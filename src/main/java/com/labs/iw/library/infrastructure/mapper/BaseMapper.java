package com.labs.iw.library.infrastructure.mapper;

import java.util.List;

public interface BaseMapper<Dto, Entity> {
    Dto toDtoToEntity(Entity input);
    Entity toEntityToDto(Dto input);
    List<Dto> fromEntityToDtoList(List<Entity> input);
    List<Entity> fromDtoToEntityList(List<Dto> input);
}
