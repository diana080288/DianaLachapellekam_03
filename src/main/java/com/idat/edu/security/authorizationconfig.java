package com.idat.edu.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class authorizationconfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtTokenStore store;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		
		clients.inMemory()
		.withClient("examen3")
		.secret(new BCryptPasswordEncoder().encode("examen3"))
		.authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
		.scopes("read","write","trust")
		.accessTokenValiditySeconds(1*60*60)
		.refreshTokenValiditySeconds(5*60*60);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		TokenEnhancerChain tokenchain = new TokenEnhancerChain();
		tokenchain.setTokenEnhancers(Arrays.asList(new TokenEnhancer(){

			@Override
			public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
				// TODO Auto-generated method stub
				Map<String, Object> informacionAdicional = new HashMap<>();
				informacionAdicional.put("llave", "reserva");
				informacionAdicional.put("seguridad", "password");
				
				DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
				token.setAdditionalInformation(informacionAdicional);
				return token;
			}
			
			
		},accessTokenConverter));
		endpoints.tokenStore(store)
		.authenticationManager(manager)
		.accessTokenConverter(accessTokenConverter)
		.tokenEnhancer(tokenchain);
		
		
	}
	
	
}
