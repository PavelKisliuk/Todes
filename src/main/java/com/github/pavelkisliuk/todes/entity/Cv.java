package com.github.pavelkisliuk.todes.entity;

import java.util.Objects;

/**
 * The {@code Cv} class is {@code Todes} realization as entity for storing
 * another special entities which are entities in database.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Todes
 * @see Person
 * @see Contacts
 * @see Technologies
 * @since 13.0
 */

public class Cv implements Todes {
	/**
	 * Entity Person in database.
	 */
	private Person person;

	/**
	 * Entity Contacts in database.
	 */
	private Contacts contacts;

	/**
	 * Entity Technologies in database.
	 */
	private Technologies technologies;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Technologies getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Technologies technologies) {
		this.technologies = technologies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cv cv = (Cv) o;

		if (!Objects.equals(person, cv.person)) return false;
		if (!Objects.equals(contacts, cv.contacts)) return false;
		return Objects.equals(technologies, cv.technologies);
	}

	@Override
	public int hashCode() {
		int result = person != null ? person.hashCode() : 0;
		result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
		result = 31 * result + (technologies != null ? technologies.hashCode() : 0);
		return result;
	}
}