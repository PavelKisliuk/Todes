package com.github.pavelkisliuk.todes.entity;

public class Technologies implements Todes{
	public static final String TABLE_NAME = "Technologies";
	public static final String ID_NAME = "technology_id";

	private Long id;
	private Long personId;
	private boolean springBoot;
	private boolean spring;
	private boolean javaCore;
	private boolean javaEE;
	private boolean git;
	private boolean rest;
	private boolean html;
	private boolean maven;
}