package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Factory<T extends Todes> {
	T create(ResultSet resultSet) throws SQLException;
}