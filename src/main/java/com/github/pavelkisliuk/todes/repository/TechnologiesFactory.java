package com.github.pavelkisliuk.todes.repository;

import com.github.pavelkisliuk.todes.entity.Technologies;
import com.github.pavelkisliuk.todes.entity.Todes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TechnologiesFactory implements Factory<Technologies> {
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