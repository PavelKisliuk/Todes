package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Person;
import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonFactory implements Factory<Person> {
	@Override
	public Person create(ResultSet resultSet) throws SQLException {
		Person person = new Person();
		person.setId(resultSet.getLong("person_id"));
		person.setSurname(resultSet.getString("surname"));
		person.setName(resultSet.getString("name"));
		person.setPatronymic(resultSet.getString("patronymic"));
		person.setBirthday(resultSet.getDate("birthday"));
		person.setMale(resultSet.getBoolean("male"));
		return person;
	}
}