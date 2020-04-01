package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Cv;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code CvFactory} class is {@code Factory} realization for {@code Cv} class
 * creation.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Factory
 * @see PersonFactory
 * @see ContactsFactory
 * @see TechnologiesFactory
 * @see Cv
 * @since 13.0
 */

public class CvFactory implements Factory<Cv> {
	/**
	 * Factory of {@code Person} class.
	 */
	private PersonFactory personFactory = new PersonFactory();

	/**
	 * Factory of {@code Contacts} class.
	 */
	private ContactsFactory contactsFactory = new ContactsFactory();

	/**
	 * Factory of {@code Technologies} class.
	 */
	private TechnologiesFactory technologiesFactory = new TechnologiesFactory();

	/**
	 * Create instance of {@code Cv} class used factories another classes.
	 * <p>
	 *
	 * @param resultSet is {@code ResultSet} with data for class creation.
	 * @return instance of {@code Cv} class.
	 * @throws SQLException if {@code SQLException} occurred.
	 */
	@Override
	public Cv create(ResultSet resultSet) throws SQLException {
		Cv cv = new Cv();
		cv.setPerson(personFactory.create(resultSet));
		cv.setContacts(contactsFactory.create(resultSet));
		cv.setTechnologies(technologiesFactory.create(resultSet));
		return cv;
	}
}