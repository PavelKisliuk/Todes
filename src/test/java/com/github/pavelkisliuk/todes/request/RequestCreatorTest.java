package com.github.pavelkisliuk.todes.request;

import com.github.pavelkisliuk.todes.entity.*;
import com.github.pavelkisliuk.todes.repository.CvFactory;
import com.github.pavelkisliuk.todes.repository.Factory;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class RequestCreatorTest {
	private static final SqlRequest SQL_REQUEST = new SqlRequest();
	private static final Factory CV_FACTORY = new CvFactory();

	@Test
	public void firstTest() {
		RequestCreator requestCreator = new RequestCreator
				.Request(SQL_REQUEST)
				.select()
				.entity(Cv.class)
				.equal("surname", "Морская")
				.and()
				.equal("name", "Мария")
				.and()
				.equal("patronymic", "Васильевна")
				.toRequest();
		List<Todes> list = requestCreator.getEntities(CV_FACTORY);
		org.junit.Assert.assertEquals(list, getDataFirstTest());
	}

	@Test
	public void secondTest() {
		RequestCreator requestCreator = new RequestCreator
				.Request(SQL_REQUEST)
				.select()
				.entity(Cv.class)
				.like("surname", "%ов")
				.or()
				.equal("male", "false")
				.toRequest();
		List list = requestCreator.getEntities(CV_FACTORY);
		org.junit.Assert.assertEquals(list, getDataSecondTest());
	}

	private List<Todes> getDataFirstTest() {
		Person person = new Person();
		person.setId(3L);
		person.setSurname("Морская");
		person.setName("Мария");
		person.setPatronymic("Васильевна");
		person.setBirthday(Date.valueOf("1999-11-7"));
		person.setMale(false);

		Contacts contacts = new Contacts();
		contacts.setId(3L);
		contacts.setPersonId(3L);
		contacts.setPhone("+375(29)999-99-99");
		contacts.setLinkedin("https://www.linkedin.com/in/mariya/");

		Technologies technologies = new Technologies();
		technologies.setId(3L);
		technologies.setPersonId(3L);
		technologies.setSpringBoot(false);
		technologies.setSpring(true);
		technologies.setJavaCore(false);
		technologies.setJavaEE(false);
		technologies.setGit(false);
		technologies.setRest(true);
		technologies.setHtml(false);
		technologies.setMaven(true);

		Cv cv = new Cv();
		cv.setPerson(person);
		cv.setContacts(contacts);
		cv.setTechnologies(technologies);

		return List.of(cv);
	}

	private List<Todes> getDataSecondTest() {
		Person person = new Person();
		person.setId(1L);
		person.setSurname("Петров");
		person.setName("Петр");
		person.setPatronymic("Петрович");
		person.setBirthday(Date.valueOf("1986-12-12"));
		person.setMale(true);

		Contacts contacts = new Contacts();
		contacts.setId(1L);
		contacts.setPersonId(1L);
		contacts.setPhone("+375(29)123-45-67");
		contacts.setEmail("petrovich@gmail.com");
		contacts.setGithub("http://github.com/petya");

		Technologies technologies = new Technologies();
		technologies.setId(1L);
		technologies.setPersonId(1L);
		technologies.setSpringBoot(true);
		technologies.setSpring(false);
		technologies.setJavaCore(false);
		technologies.setJavaEE(false);
		technologies.setGit(true);
		technologies.setRest(false);
		technologies.setHtml(true);
		technologies.setMaven(false);

		Cv cv1 = new Cv();
		cv1.setPerson(person);
		cv1.setContacts(contacts);
		cv1.setTechnologies(technologies);

		person = new Person();
		person.setId(2L);
		person.setSurname("Иванов");
		person.setName("Иван");
		person.setPatronymic("Иванович");
		person.setBirthday(Date.valueOf("1997-4-4"));
		person.setMale(true);

		contacts = new Contacts();
		contacts.setId(2L);
		contacts.setPersonId(2L);
		contacts.setPhone("+375(29)87-65-43");
		contacts.setGithub("http://github.com/vanya");
		contacts.setSkype("skype:ivanko");

		technologies = new Technologies();
		technologies.setId(2L);
		technologies.setPersonId(2L);
		technologies.setSpringBoot(false);
		technologies.setSpring(false);
		technologies.setJavaCore(true);
		technologies.setJavaEE(true);
		technologies.setGit(true);
		technologies.setRest(false);
		technologies.setHtml(false);
		technologies.setMaven(false);

		Cv cv2 = new Cv();
		cv2.setPerson(person);
		cv2.setContacts(contacts);
		cv2.setTechnologies(technologies);

		person = new Person();
		person.setId(3L);
		person.setSurname("Морская");
		person.setName("Мария");
		person.setPatronymic("Васильевна");
		person.setBirthday(Date.valueOf("1999-11-7"));
		person.setMale(false);

		contacts = new Contacts();
		contacts.setId(3L);
		contacts.setPersonId(3L);
		contacts.setPhone("+375(29)999-99-99");
		contacts.setLinkedin("https://www.linkedin.com/in/mariya/");

		technologies = new Technologies();
		technologies.setId(3L);
		technologies.setPersonId(3L);
		technologies.setSpringBoot(false);
		technologies.setSpring(true);
		technologies.setJavaCore(false);
		technologies.setJavaEE(false);
		technologies.setGit(false);
		technologies.setRest(true);
		technologies.setHtml(false);
		technologies.setMaven(true);

		Cv cv3 = new Cv();
		cv3.setPerson(person);
		cv3.setContacts(contacts);
		cv3.setTechnologies(technologies);

		return List.of(cv1, cv2, cv3);
	}
}