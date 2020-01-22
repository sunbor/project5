package com.revature.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

// won't use. purely for testing

//@Configuration
//@EnableResourceServer
//@SuppressWarnings("deprecation")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//	private static final String RESOURCE_ID = "my_rest_api"; //insert actual api here
//	
//	public void configure(ResourceServerSecurityConfigurer resources) {
//		resources.resourceId(RESOURCE_ID).stateless(false);
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.anonymous().disable().requestMatchers().antMatchers("/user/**").and().authorizeRequests()
//		.antMatchers("/user/**").access("role('ADMIN')").and().exceptionHandling()
//		.accessDeniedHandler(new OAuth2AccessDeniedHandler());
//	}
}
