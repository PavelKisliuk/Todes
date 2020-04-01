package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Contacts;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code ContactsFactory} class is {@code Factory} realization for {@code Contacts} class
 * creation.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Factory
 * @see CvFactory
 * @see PersonFactory
 * @see TechnologiesFactory
 * @see Contacts
 * @since 13.0
 */

public class ContactsFactory implements Factory<Contacts> {
	/**
	 * Create instance of {@code Contacts} class used {@code ResultSet}.
	 * <p>
	 *
	 * @param resultSet is {@code ResultSet} with data for class creation.
	 * @return instance of {@code Contacts} class.
	 * @throws SQLException if {@code SQLException} occurred.
	 */
	@Override
	public Contacts create(ResultSet resultSet) throws SQLException {
		Contacts contacts = new Contacts();
		contacts.setId(resultSet.getLong("contact_id"));
		contacts.setPersonId(resultSet.getLong("person_id"));
		contacts.setPhone(resultSet.getString("phone"));
		contacts.setEmail(resultSet.getString("email"));
		contacts.setGithub(resultSet.getString("github"));
		contacts.setSkype(resultSet.getString("skype"));
		contacts.setLinkedin(resultSet.getString("linkedin"));
		return contacts;
	}
}