package com.balceda.sboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balceda.sboot.model.Person;
import com.balceda.sboot.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public Iterable<Person> getAll() {
		return personRepository.findAll();
	}

	public void delete(Person person) {
		personRepository.delete(person);
	}

	public void insert(Person person) {
		personRepository.save(person);
	}
}
