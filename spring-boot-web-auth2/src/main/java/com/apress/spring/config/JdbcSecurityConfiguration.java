package com.apress.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Profile("db")
@Configuration
@EnableGlobalAuthentication
public class JdbcSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter{
	
//	@Bean
//	public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
//		RowMapper<User> userRowMapper = (ResultSet rs, int i) ->
//			new User(
//					rs.getString("ACCOUNT_NAME"),
//					rs.getString("PASSWORD"),
//					rs.getBoolean("ENABLED"),
//					rs.getBoolean("ENABLED"),
//					rs.getBoolean("ENABLED"),
//					rs.getBoolean("ENABLED"),
//					AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_AMDIN")
//					);
//			return username ->
//			jdbcTemplate.queryForObject("SELECT * from ACCOUNT where ACCOUNT_NAME = ?",
//					userRowMapper, username);
//	}
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService);
	}
	
}