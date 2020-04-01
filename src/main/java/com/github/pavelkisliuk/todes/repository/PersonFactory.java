package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code PersonFactory} class is {@code Factory} realization for {@code Person} class
 * creation.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Factory
 * @see CvFactory
 * @see ContactsFactory
 * @see TechnologiesFactory
 * @see Person
 * @since 13.0
 */

public class PersonFactory implements Factory<Person> {

	/**
	 * Create instance of {@code Person} class used {@code ResultSet}.
	 * <p>
	 *
	 * @param resultSet is {@code ResultSet} with data for class creation.
	 * @return instance of {@code Person} class.
	 * @throws SQLException if {@code SQLException} occurred.
	 */
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