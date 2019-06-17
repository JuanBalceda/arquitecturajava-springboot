package com.balceda.sboot.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.balceda.sboot.mapping.AuthenticatedUser;

public class HttpParserService {

	private long expiration = 36000000;
	private String secret = "1234";
	private String tokenPrefix = "Bearer";
	private String httpHeader = "Authorization";

	public void createToken(HttpServletResponse response, String user) {

		String jwt = new TokenService().createToken(user, secret, new Date(System.currentTimeMillis() + expiration));
		response.addHeader(httpHeader, tokenPrefix + " " + jwt);
	}

	public Authentication readToken(HttpServletRequest request) {

		String token = request.getHeader(httpHeader);
		if (token != null) {

			String realToken = token.substring(token.indexOf(" ") + 1);
			if (realToken != null) {

				String user = new TokenService().readToken(realToken, secret);
				if (user != null) {

					return new AuthenticatedUser(user);
				}
			}
		}
		return null;
	}
}
