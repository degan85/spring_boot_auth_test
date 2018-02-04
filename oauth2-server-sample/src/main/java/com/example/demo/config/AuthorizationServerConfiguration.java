package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration {

	@Bean
	public TokenStore JdbcTokenStore(DataSource dataSource) {
		return new JdbcTokenStore(dataSource);
	}
}
