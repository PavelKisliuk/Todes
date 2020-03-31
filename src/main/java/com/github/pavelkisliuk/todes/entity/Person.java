package com.github.pavelkisliuk.todes.entity;

import java.sql.Date;
import java.util.Objects;

public class Person implements Todes{
	public static final String TABLE_NAME = "Person";
	public static final String ID_NAME = "person_id";

	private Long id;
	private String surname;
	private String name;
	private String patronymic;
	private Date birthday;
	private boolean male;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (male != person.male) return false;
		if (!Objects.equals(id, person.id)) return false;
		if (!Objects.equals(surname, person.surname)) return false;
		if (!Objects.equals(name, person.name)) return false;
		if (!Objects.equals(patronymic, person.patronymic)) return false;
		return Objects.equals(birthday, person.birthday);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		result = 31 * result + (male ? 1 : 0);
		return result;
	}
}