package com.balceda.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@RequestMapping("/list")
	public String getPersons(Model model) {
		return "persons/list";
	}
}
