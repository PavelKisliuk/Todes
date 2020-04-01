package com.github.pavelkisliuk.todes.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * The {@code Technologies} class is {@code Todes} realization as entity of table
 * Technologies in database.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Todes
 * @see Cv
 * @see Person
 * @see Contacts
 * @since 13.0
 */

@Entity
public class Technologies implements Todes {
	/**
	 * Name of table for this entity in database.
	 */
	public static final String TABLE_NAME = "Technologies";

	/**
	 * Name of id of the table for this entity in database.
	 */
	public static final String ID_NAME = "technology_id";

	private Long id;
	private Long personId;
	private boolean springBoot;
	private boolean spring;
	private boolean javaCore;
	private boolean javaEE;
	private boolean git;
	private boolean rest;
	private boolean html;
	private boolean maven;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public boolean isSpringBoot() {
		return springBoot;
	}

	public void setSpringBoot(boolean springBoot) {
		this.springBoot = springBoot;
	}

	public boolean isSpring() {
		return spring;
	}

	public void setSpring(boolean spring) {
		this.spring = spring;
	}

	public boolean isJavaCore() {
		return javaCore;
	}

	public void setJavaCore(boolean javaCore) {
		this.javaCore = javaCore;
	}

	public boolean isJavaEE() {
		return javaEE;
	}

	public void setJavaEE(boolean javaEE) {
		this.javaEE = javaEE;
	}

	public boolean isGit() {
		return git;
	}

	public void setGit(boolean git) {
		this.git = git;
	}

	public boolean isRest() {
		return rest;
	}

	public void setRest(boolean rest) {
		this.rest = rest;
	}

	public boolean isHtml() {
		return html;
	}

	public void setHtml(boolean html) {
		this.html = html;
	}

	public boolean isMaven() {
		return maven;
	}

	public void setMaven(boolean maven) {
		this.maven = maven;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Technologies that = (Technologies) o;

		if (springBoot != that.springBoot) return false;
		if (spring != that.spring) return false;
		if (javaCore != that.javaCore) return false;
		if (javaEE != that.javaEE) return false;
		if (git != that.git) return false;
		if (rest != that.rest) return false;
		if (html != that.html) return false;
		if (maven != that.maven) return false;
		if (!Objects.equals(id, that.id)) return false;
		return Objects.equals(personId, that.personId);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (personId != null ? personId.hashCode() : 0);
		result = 31 * result + (springBoot ? 1 : 0);
		result = 31 * result + (spring ? 1 : 0);
		result = 31 * result + (javaCore ? 1 : 0);
		result = 31 * result + (javaEE ? 1 : 0);
		result = 31 * result + (git ? 1 : 0);
		result = 31 * result + (rest ? 1 : 0);
		result = 31 * result + (html ? 1 : 0);
		result = 31 * result + (maven ? 1 : 0);
		return result;
	}
}