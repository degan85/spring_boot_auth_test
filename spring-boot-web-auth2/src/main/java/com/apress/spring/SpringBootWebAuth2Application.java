package com.apress.spring;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableOAuth2Sso
@EnableOAuth2Client
@RestController
public class SpringBootWebAuth2Application extends WebSecurityConfigurerAdapter{

	
	@RequestMapping("/user")
	public Principal user(Principal principal) {
	  return principal;
	}
	
	public static void main(String[] args) {
	  SpringApplication.run(SpringBootWebAuth2Application.class, args);
	}
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .antMatcher("/**")
	.authorizeRequests()
	  .antMatchers("/", "/login**", "/webjars/**")
	  .permitAll()
	.anyRequest()
	  .authenticated()
	.and().logout().logoutSuccessUrl("/").permitAll()
	    .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
}

}
