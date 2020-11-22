package com.miclaus.socialwebapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.miclaus.socialwebapp.service.SiteUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SiteUserService siteUserService;
	
	@Autowired
	private PasswordEncoder paswordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:on
		http
			.authorizeRequests()
				.antMatchers("/","js/**", "css/**", "/about", "/register","/logout")
					.permitAll()
			.antMatchers("/addstatus", "/editstatus", "/deletestatus")
				.hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/viewstatus")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll();
		//@formatter:off
	}

//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(siteUserService);
//		authenticationProvider.setPasswordEncoder(paswordEncoder);
//		return authenticationProvider;
//	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(siteUserService).passwordEncoder(paswordEncoder);
	}
}
