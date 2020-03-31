package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
	private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASS = "2101942882";

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