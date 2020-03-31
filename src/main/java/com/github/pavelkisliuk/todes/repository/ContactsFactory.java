package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Contacts;
import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsFactory implements Factory<Contacts> {
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
