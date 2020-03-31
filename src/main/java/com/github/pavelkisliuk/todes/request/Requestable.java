package com.github.pavelkisliuk.todes.request;

public interface Requestable {
	String WHERE_STATEMENT = "WHERE";

	String select();
	String select(String columns);
	String equal(String name, String value);
	String and();
	String or();
	String like(String column, String pattern);
	String innerJoin(String mainTable, String joinTable, String onColumn);
}