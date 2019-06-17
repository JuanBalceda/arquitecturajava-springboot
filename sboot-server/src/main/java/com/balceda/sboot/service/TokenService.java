package com.balceda.sboot.service;

import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenService {

	public String createToken(String user, String secret, Date expirationDate) {

		String jwt = Jwts.builder()
				.setSubject(user)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secret.getBytes()))
				.compact();
		return jwt;
	}
	
	public String readToken(String token, String secret) {

		String user = Jwts.parser()
				.setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
		return user;
	}
}
