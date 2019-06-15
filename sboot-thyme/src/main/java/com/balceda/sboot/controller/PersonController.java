package com.balceda.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balceda.sboot.model.Person;
import com.balceda.sboot.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping("/list")
	public String getPersons(Model model) {
		model.addAttribute("persons", personService.getAll());
		return "persons/list";
	}

	@RequestMapping("/formInsert")
	public String formInsert() {
		return "persons/formInsert";
	}
	
	@RequestMapping("/insert")
	public String insert(Person person, Model model) {
		
		personService.insert(person);
		model.addAttribute("persons", personService.getAll());
		
		return "persons/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("name") String name, Model model) {
		
		personService.delete(new Person(name));
		model.addAttribute("persons", personService.getAll());
		
		return "persons/list";
	}
}
