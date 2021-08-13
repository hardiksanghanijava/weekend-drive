package com.weekend.drive.interview.auth;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SptingSecurityBasicAuth extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.anyRequest().authenticated()
		.and()
		//http.formLogin();
		.httpBasic();
	}

}
