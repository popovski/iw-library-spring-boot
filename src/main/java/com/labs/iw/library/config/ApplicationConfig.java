package com.labs.iw.library.config;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}