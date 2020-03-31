package com.github.pavelkisliuk.todes.entity;

import java.util.Objects;

public class Cv implements Todes{
	private Person person;
	private Contacts contacts;
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