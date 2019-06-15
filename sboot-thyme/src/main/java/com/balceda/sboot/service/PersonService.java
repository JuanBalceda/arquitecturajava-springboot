package com.balceda.sboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balceda.sboot.model.Person;
import com.balceda.sboot.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAll() {
		return personRepository.getAll();
	}

	public void delete(Person person) {
		personRepository.delete(person);
	}

	public void insert(Person person) {
		personRepository.insert(person);
	}
}
