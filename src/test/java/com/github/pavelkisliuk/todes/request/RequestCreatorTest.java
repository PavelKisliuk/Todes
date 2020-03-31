package com.github.pavelkisliuk.todes.request;

import com.github.pavelkisliuk.todes.entity.Cv;
import org.junit.Test;

public class RequestCreatorTest {
	private static final SqlRequest SQL_REQUEST = new SqlRequest();

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
		System.out.println(requestCreator.getRequest());
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
		System.out.println(requestCreator.getRequest());
	}
}