package com.github.pavelkisliuk.todes.request;

/**
 * The {@code Requestable} interface is unifier for special group of classes used as
 * request creators to database.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see SqlRequest
 * @since 13.0
 */

public interface Requestable {
	/**
	 * WHERE statement.
	 */
	String WHERE_STATEMENT = "WHERE";

	/**
	 * Create SELECT request parameter with all columns in table.
	 * <p>
	 *
	 * @return SELECT parameter as {@code String}.
	 */
	String select();

	/**
	 * Create SELECT request parameter with special columns in table.
	 * <p>
	 *
	 * @param columns is required columns in table.
	 * @return SELECT parameter as {@code String}.
	 */
	String select(String columns);

	/**
	 * Create = request parameter with special columns in table.
	 * <p>
	 *
	 * @param name  is name of table.
	 * @param value is value for equality in this table.
	 * @return = parameter as {@code String}.
	 */
	String equal(String name, String value);

	/**
	 * Create AND request parameter.
	 * <p>
	 *
	 * @return AND parameter as {@code String}.
	 */
	String and();

	/**
	 * Create OR request parameter.
	 * <p>
	 *
	 * @return OR parameter as {@code String}.
	 */
	String or();

	/**
	 * Create LIKE request parameter.
	 * <p>
	 *
	 * @param column  is column in database for applying LIKE.
	 * @param pattern is pattern for LIKE.
	 * @return LIKE parameter as {@code String}.
	 */
	String like(String column, String pattern);

	/**
	 * Create INNER JOIN request parameter.
	 * <p>
	 *
	 * @param mainTable is table for joining.
	 * @param joinTable is joined table.
	 * @param onColumn  is column on which will join.
	 * @return INNER JOIN parameter as {@code String}.
	 */
	String innerJoin(String mainTable, String joinTable, String onColumn);
}