package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code Factory} interface is unifier for special group of classes used as
 * factories for creation {@code Todes} realizations.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see CvFactory
 * @see PersonFactory
 * @see ContactsFactory
 * @see TechnologiesFactory
 * @see Todes
 * @since 13.0
 */

public interface Factory<T extends Todes> {
	/**
	 * Create {@code Todes} realizations classes.
	 * <p>
	 *
	 * @param resultSet is {@code ResultSet} with data for class creation.
	 * @return instance of {@code Todes} realization class.
	 * @throws SQLException if {@code SQLException} occurred.
	 */
	T create(ResultSet resultSet) throws SQLException;
}