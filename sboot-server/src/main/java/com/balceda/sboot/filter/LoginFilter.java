package com.balceda.sboot.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.balceda.sboot.mapping.User;
import com.balceda.sboot.service.HttpParserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	private HttpParserService httpParserService;

	public LoginFilter(String url, AuthenticationManager authenticationManager) {
		super(url);

		httpParserService = new HttpParserService();
		setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		// Reading user and password from post request (JSON)
		User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
		UsernamePasswordAuthenticationToken springToken = 
				new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());

		return getAuthenticationManager().authenticate(springToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String username = authResult.getName();
		httpParserService.createToken(response, username);
	}

}
