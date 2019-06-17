package com.balceda.sboot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.balceda.sboot.model.Person;

@Repository
public class PersonRepository {

	@Autowired
	private JdbcTemplate template;

	public List<Person> getAll() {
		return template.query("select * from persons", new PersonMapper());
	}

	public void delete(Person person) {
		template.update("delete from persons where name=?", person.getName());
	}

	public void insert(Person person) {
		template.update("insert into persons (name, last_name, age) values (?,?,?)", person.getName(),
				person.getLastName(), person.getAge());
	}
}
