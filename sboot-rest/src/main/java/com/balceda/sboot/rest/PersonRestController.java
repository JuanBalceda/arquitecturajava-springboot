package com.balceda.sboot.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balceda.sboot.model.Person;
import com.balceda.sboot.repository.PersonRepository;

@RestController
@RequestMapping("webapi")
public class PersonRestController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping("/persons")
	public Iterable<Person> getAll() {
		return personRepository.findAll();
	}
	
	@PostMapping(path="/persons", consumes="application/json")
	public void insert(@RequestBody Person person) {
		personRepository.save(person);
	}
	
	@DeleteMapping(path="/persons/{name}", consumes="application/json")
	public void insert(@PathVariable String name) {
		Optional<Person> person = personRepository.findById(name);
		if (person.isPresent()) {
			personRepository.delete(person.get());	
		}
	}
}
