package com.github.pavelkisliuk.todes.entity;

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
}