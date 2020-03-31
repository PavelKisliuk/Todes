package com.github.pavelkisliuk.todes.request;

public class SqlRequest implements Requestable {

	@Override
	public String select() {
		return "SELECT * FROM";
	}

	@Override
	public String select(String columns) {
		return "SELECT " + columns + " FROM";
	}

	@Override
	public String equal(String name, String value) {
		return name + " = " + "'" + value + "'";
	}

	@Override
	public String and() {
		return "AND";
	}

	@Override
	public String or() {
		return "OR";
	}

	@Override
	public String like(String column, String pattern) {
		return column + " LIKE " + "'" + pattern + "'";
	}

	@Override
	public String innerJoin(String mainTable, String joinTable, String onColumn) {
		return "INNER JOIN " + joinTable + " ON " +
				mainTable + "." + onColumn + " = " +
				joinTable + "." + onColumn;
	}
}