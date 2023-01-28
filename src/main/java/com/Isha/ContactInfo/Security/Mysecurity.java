package com.Isha.ContactInfo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Mysecurity {
	
	@Bean
	public UserDetailsService userDetailsService()
	{
//		UserDetails admin=User.withUsername("Isha").password(encoder.encode("myclass")).roles("admin").build();
//		UserDetails simpleUser=User.withUsername("simple").password(encoder.encode("myclass")).roles("simpleuser").build();
//		
		return new UserInfoDetailsServices();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable().authorizeHttpRequests().antMatchers("/index").permitAll()
				.and().authorizeHttpRequests().antMatchers("/ContactPage").authenticated().and().formLogin().and().build();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider =new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	

}
