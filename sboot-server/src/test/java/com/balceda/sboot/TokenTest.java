package com.balceda.sboot;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.balceda.sboot.service.TokenService;

public class TokenTest {

	@Test
	public void createToken() throws ParseException {
		TokenService service = new TokenService();

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String token = service.createToken("jesus", "1234", formatter.parse("01/07/2019"));
		System.out.println(token);
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZXN1cyIsImV4cCI6MTU2MTkzMjAwMH0.NlCwpsL673ARhoLBg6wY1Hzml-r4RontSe7Q8jf5i2w",
				token);
	}

	@Test
	public void readToken() throws ParseException {
		TokenService service = new TokenService();

		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZXN1cyIsImV4cCI6MTU2MTkzMjAwMH0.NlCwpsL673ARhoLBg6wY1Hzml-r4RontSe7Q8jf5i2w";

		String user = service.readToken(token, "1234");
		System.out.println(user);
		assertEquals("jesus", user);
	}
}
