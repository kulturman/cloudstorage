package com.udacity.jwdnd.course1.cloudstorage.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.udacity.jwdnd.course1.cloudstorage.services.AuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthService authenticationService;

	public SecurityConfig(AuthService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		System.out.println("CONFIGURE CALLED");
		auth.authenticationProvider(this.authenticationService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2/**", "/signup", "/css/**", "/js/**", "/login/**", "/home").permitAll()
				.anyRequest().authenticated();
		// http.csrf().disable();
		http.formLogin().loginPage("/login").permitAll();
		http.formLogin().defaultSuccessUrl("/home", true);
	}
}
