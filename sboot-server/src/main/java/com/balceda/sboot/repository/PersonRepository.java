package com.balceda.sboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.balceda.sboot.model.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

}
