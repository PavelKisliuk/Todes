package com.github.pavelkisliuk.todes.entity;

import java.sql.Date;

public class Person implements Todes{
	public static final String TABLE_NAME = "Person";
	public static final String ID_NAME = "person_id";

	private Long id;
	private String surname;
	private String name;
	private String patronymic;
	private Date birthday;
	private boolean male;

}