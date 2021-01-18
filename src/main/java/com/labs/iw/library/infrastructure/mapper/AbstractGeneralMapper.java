package com.labs.iw.library.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public abstract class AbstractGeneralMapper {

	public ModelMapper modelMapper;
	public AbstractGeneralMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
}