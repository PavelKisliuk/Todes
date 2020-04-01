package com.github.pavelkisliuk.todes.request;

/**
 * The {@code SqlRequest} class is {@code Requestable} realization for
 * SQL request creation.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Requestable
 * @since 13.0
 */

public class SqlRequest implements Requestable {
	/**
	 * Create SQL SELECT request parameter with all columns in table.
	 * <p>
	 *
	 * @return SELECT SQL parameter as {@code String}.
	 */
	@Override
	public String select() {
		return "SELECT * FROM";
	}

	/**
	 * Create SQL SELECT request parameter with special columns in table.
	 * <p>
	 *
	 * @param columns is required columns in table.
	 * @return SELECT SQL parameter as {@code String}.
	 */
	@Override
	public String select(String columns) {
		return "SELECT " + columns + " FROM";
	}

	/**
	 * Create SQL = request parameter with special columns in table.
	 * <p>
	 *
	 * @param name  is name of table.
	 * @param value is value for equality in this table.
	 * @return = SQL parameter as {@code String}.
	 */
	@Override
	public String equal(String name, String value) {
		return name + " = " + "'" + value + "'";
	}

	/**
	 * Create SQL AND request parameter.
	 * <p>
	 *
	 * @return AND SQL parameter as {@code String}.
	 */
	@Override
	public String and() {
		return "AND";
	}

	/**
	 * Create SQL OR request parameter.
	 * <p>
	 *
	 * @return OR SQL parameter as {@code String}.
	 */
	@Override
	public String or() {
		return "OR";
	}

	/**
	 * Create SQL LIKE request parameter.
	 * <p>
	 *
	 * @param column  is column in database for applying LIKE.
	 * @param pattern is pattern for LIKE.
	 * @return LIKE SQL parameter as {@code String}.
	 */
	@Override
	public String like(String column, String pattern) {
		return column + " LIKE " + "'" + pattern + "'";
	}

	/**
	 * Create SQL INNER JOIN request parameter.
	 * <p>
	 *
	 * @param mainTable is table for joining.
	 * @param joinTable is joined table.
	 * @param onColumn  is column on which will join.
	 * @return INNER JOIN SQL parameter as {@code String}.
	 */
	@Override
	public String innerJoin(String mainTable, String joinTable, String onColumn) {
		return "INNER JOIN " + joinTable + " ON " +
				mainTable + "." + onColumn + " = " +
				joinTable + "." + onColumn;
	}
}