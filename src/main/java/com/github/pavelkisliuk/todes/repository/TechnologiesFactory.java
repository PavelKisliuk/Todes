package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Technologies;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code TechnologiesFactory} class is {@code Factory} realization for {@code Technologies} class
 * creation.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Factory
 * @see CvFactory
 * @see PersonFactory
 * @see ContactsFactory
 * @see Technologies
 * @since 13.0
 */

public class TechnologiesFactory implements Factory<Technologies> {

	/**
	 * Create instance of {@code Technologies} class used {@code ResultSet}.
	 * <p>
	 *
	 * @param resultSet is {@code ResultSet} with data for class creation.
	 * @return instance of {@code Technologies} class.
	 * @throws SQLException if {@code SQLException} occurred.
	 */
	@Override
	public Technologies create(ResultSet resultSet) throws SQLException {
		Technologies technologies = new Technologies();
		technologies.setId(resultSet.getLong("contact_id"));
		technologies.setPersonId(resultSet.getLong("person_id"));
		technologies.setSpringBoot(resultSet.getBoolean("spring_boot"));
		technologies.setSpring(resultSet.getBoolean("spring"));
		technologies.setJavaCore(resultSet.getBoolean("java_core"));
		technologies.setJavaEE(resultSet.getBoolean("java_ee"));
		technologies.setGit(resultSet.getBoolean("git"));
		technologies.setRest(resultSet.getBoolean("rest"));
		technologies.setHtml(resultSet.getBoolean("html"));
		technologies.setMaven(resultSet.getBoolean("maven"));
		return technologies;
	}
}