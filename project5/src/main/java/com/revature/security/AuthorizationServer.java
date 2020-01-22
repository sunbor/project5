package com.revature.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

// purely testing. wont use yet


//@Configuration
//@EnableAuthorizationServer
//@SuppressWarnings("deprecation")
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
//	
//	private static String SAFARI ="MY_OAUTH_SAFARI"; //replace here as well
//	
//	@Autowired
//	private TokenStore tokenStore;
//	
//	@Autowired
//	private UserApprovalHandler userApprovalHandler;
//	
//	@Autowired
//	@Qualifier("authenticationManagerBean")
//	private AuthenticationManager authenticationManager;
//	
//	@Override
//	public void configure(ClientDetailsServiceConfigurer users) throws Exception {
//		users.inMemory().withClient("userId")//example used "my-trusted-client"...which should be more like: "my-trusted-user".. if i'm correct
//		.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit") .authorities("DIGI_TRAINER", "ADMIN")
//		.scopes("read", "write", "trust").secret("password").accessTokenValiditySeconds(180)//this means that the access token will only give them 3 minutes
//		.refreshTokenValiditySeconds(300);//after refreshing they will have 5 minutes before losing their token
//	}
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler).authenticationManager(authenticationManager);
//	}
//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer oAuthServer) throws Exception {
//		oAuthServer.realm(SAFARI+"/digi-trainer");
//	}

}
