package com.github.pavelkisliuk.todes.entity;

import java.util.Objects;

public class Contacts implements Todes{
	public static final String TABLE_NAME = "Contacts";
	public static final String ID_NAME = "contact_id";

	private Long id;
	private Long personId;
	private String phone;
	private String email;
	private String github;
	private String skype;
	private String linkedin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contacts contacts = (Contacts) o;

		if (!Objects.equals(id, contacts.id)) return false;
		if (!Objects.equals(personId, contacts.personId)) return false;
		if (!Objects.equals(phone, contacts.phone)) return false;
		if (!Objects.equals(email, contacts.email)) return false;
		if (!Objects.equals(github, contacts.github)) return false;
		if (!Objects.equals(skype, contacts.skype)) return false;
		return Objects.equals(linkedin, contacts.linkedin);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (personId != null ? personId.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (github != null ? github.hashCode() : 0);
		result = 31 * result + (skype != null ? skype.hashCode() : 0);
		result = 31 * result + (linkedin != null ? linkedin.hashCode() : 0);
		return result;
	}
}