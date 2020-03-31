package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CvFactory implements Factory<Cv> {
	private PersonFactory personFactory = new PersonFactory();
	private ContactsFactory contactsFactory = new ContactsFactory();
	private TechnologiesFactory technologiesFactory = new TechnologiesFactory();

	@Override
	public Cv create(ResultSet resultSet) throws SQLException {
		Cv cv = new Cv();
		cv.setPerson(personFactory.create(resultSet));
		cv.setContacts(contactsFactory.create(resultSet));
		cv.setTechnologies(technologiesFactory.create(resultSet));
		return cv;
	}
}