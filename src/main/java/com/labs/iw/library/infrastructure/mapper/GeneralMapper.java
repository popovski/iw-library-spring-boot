package com.labs.iw.library.infrastructure.mapper;

import java.util.List;

public interface GeneralMapper<Dto, Entity> {
	
	public Dto entityToDto (Entity entity);
	
	public Entity dtoToEntity(Dto dto);
	
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass);
}
