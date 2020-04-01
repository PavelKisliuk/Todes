package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Repository} class is repository for database.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Todes
 * @see Factory
 * @since 13.0
 */

public class Repository {
	/**
	 * URL to database.
	 */
	private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";

	/**
	 * Username to database.
	 */
	private static final String USER = "";

	/**
	 * Password to database.
	 */
	private static final String PASS = "";

	/**
	 * Make request to database and return received data as {@code} List.
	 * <p>
	 *
	 * @param request is SQL request to database.
	 * @param factory is factory for creation expected data.
	 * @return {@code} List of {@code Todes} elements.
	 */
	public List<Todes> query(String request, Factory<Todes> factory) {
		List<Todes> list = new ArrayList<>();
		Connection connection;
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			throw new AssertionError();
		}

		try (PreparedStatement statement = connection.prepareStatement(request);
			 ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				list.add(factory.create(resultSet));
			}
		} catch (SQLException e) {
			throw new AssertionError();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new AssertionError();
			}
		}
		return list;
	}
}