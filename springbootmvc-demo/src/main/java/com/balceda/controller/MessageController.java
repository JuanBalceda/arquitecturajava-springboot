package com.balceda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

	@RequestMapping("/hello")
	public String hello() {
		
		return "message";
	}
}
