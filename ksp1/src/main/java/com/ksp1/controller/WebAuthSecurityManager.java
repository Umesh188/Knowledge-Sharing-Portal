
package com.ksp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
@Configuration
public class WebAuthSecurityManager extends WebSecurityConfigurerAdapter {

	@Autowired
	DBAuthenticationProvider dbAuthenticationProvider;


	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(dbAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").hasAnyAuthority("student","student1")
		.antMatchers("/login").permitAll()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/home").failureUrl("/");
		http.csrf().disable();
	}

}
