package com.miclaus.socialwebapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.miclaus.socialwebapp.service.SiteUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SiteUserService siteUserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:on
		http
			.authorizeRequests()
				.antMatchers("/","js/**", "css/**", "/about")
					.permitAll()
			.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/viewstatus")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		//@formatter:off
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(siteUserService);
	}
	
}
