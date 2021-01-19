package com.labs.iw.library.config;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ApplicationConfig {
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		log.info("Application running in UTC timezone {}", new Date());
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}	
	
	@Bean
	public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
		return builder.createXmlMapper(false).serializationInclusion(Include.NON_NULL).build();
	}
}