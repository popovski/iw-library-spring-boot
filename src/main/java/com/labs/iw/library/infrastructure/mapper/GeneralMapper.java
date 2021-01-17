package com.labs.iw.library.infrastructure.mapper;

public interface GeneralMapper<Dto, Entity> {
	
	public Dto entityToDto (Entity entity);
	
	public Entity dtoToEntity(Dto dto);
	
}
