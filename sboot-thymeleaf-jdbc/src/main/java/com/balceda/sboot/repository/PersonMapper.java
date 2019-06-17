package com.balceda.sboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.balceda.sboot.model.Person;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Person(rs.getString("name"), rs.getString("last_name"), rs.getInt("age"));
	}

}
