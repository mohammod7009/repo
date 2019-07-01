package com.my.restapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.my.restapi.service.UserService;

@Configuration
public class AppConfig {

	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	
}
