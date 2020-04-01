package com.github.pavelkisliuk.todes.request;

import com.github.pavelkisliuk.todes.entity.*;
import com.github.pavelkisliuk.todes.repository.Factory;
import com.github.pavelkisliuk.todes.repository.Repository;

import java.util.List;

/**
 * The {@code RequestCreator} class is util class for creation requests to database and
 * receiving data from it.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see Requestable
 * @since 13.0
 */

public class RequestCreator {
	/**
	 * Repository for receiving data from database.
	 */
	private static final Repository REPOSITORY = new Repository();

	/**
	 * Request to database.
	 */
	private StringBuilder request;

	/**
	 * The {@code Request} class is builder of request to database.
	 */
	public static class Request {
		/**
		 * Class for creation request to database.
		 */
		private Requestable requestable;

		/**
		 * Request to database.
		 */
		private StringBuilder request;

		/**
		 * The {@code Request} class constructor.
		 * <p>
		 *
		 * @param requestable is special class for request creation.
		 */
		public Request(Requestable requestable) {
			this.requestable = requestable;
			request = new StringBuilder();
		}

		/**
		 * Inquire select statement from {@code Requestable} instance.
		 * <p>
		 *
		 * @return {@code this} class.
		 */
		public Request select() {
			request.append(requestable.select()).append(" ");
			return this;
		}

		/**
		 * Inquire select statement with parameters from {@code Requestable} instance.
		 * <p>
		 *
		 * @param columns is parameters with special columns in table.
		 * @return {@code this} class.
		 */
		public Request select(String columns) {
			request.append(requestable.select(columns)).append(" ");
			return this;
		}

		/**
		 * Specify correct statement for {@code Class}.
		 * <p>
		 *
		 * @param todes is class of {@code Class} for correct statement creation.
		 * @return {@code this} class.
		 */
		public Request entity(Class todes) {
			if (todes == Cv.class) {
				request.append(Person.TABLE_NAME).
						append(" ").
						append(requestable.innerJoin(
								Person.TABLE_NAME,
								Contacts.TABLE_NAME,
								Person.ID_NAME)).
						append(" ").
						append(requestable.innerJoin(
								Person.TABLE_NAME,
								Technologies.TABLE_NAME,
								Person.ID_NAME));
			} else {
				request.append(todes.getSimpleName());
			}
			request.append(" ").append(Requestable.WHERE_STATEMENT).append(" ");
			return this;
		}

		/**
		 * Inquire = statement from {@code Requestable} instance.
		 * <p>
		 *
		 * @param name  is name of table.
		 * @param value is value for equality in this table.
		 * @return {@code this} class.
		 */
		public Request equal(String name, String value) {
			request.append(requestable.equal(name, value)).append(" ");
			return this;
		}

		/**
		 * Inquire and statement from {@code Requestable} instance.
		 * <p>
		 *
		 * @return {@code this} class.
		 */
		public Request and() {
			request.append(requestable.and()).append(" ");
			return this;
		}

		/**
		 * Inquire or statement from {@code Requestable} instance.
		 * <p>
		 *
		 * @return {@code this} class.
		 */
		public Request or() {
			request.append(requestable.or()).append(" ");
			return this;
		}

		/**
		 * Inquire like statement from {@code Requestable} instance.
		 * <p>
		 *
		 * @param column  is column in database for applying LIKE.
		 * @param pattern is pattern for LIKE.
		 * @return {@code this} class.
		 */
		public Request like(String column, String pattern) {
			request.append(requestable.like(column, pattern)).append(" ");
			return this;
		}

		/**
		 * Convert {@code Request} instance to {@code RequestCreator}.
		 * <p>
		 *
		 * @return {@code RequestCreator} instance.
		 */
		public RequestCreator toRequest() {
			return new RequestCreator(this);
		}
	}

	/**
	 * The {@code RequestCreator} class constructor.
	 * <p>
	 *
	 * @param request is final request to database.
	 */
	private RequestCreator(Request request) {
		this.request = request.request;
	}

	/**
	 * Return request to database as {@code String}.
	 * <p>
	 *
	 * @return request to database as {@code String}.
	 */
	public String getRequest() {
		return request.toString();
	}

	/**
	 * Receive data from database and return it as {@code List}.
	 * <p>
	 *
	 * @param factory is special factory for {@code Todes} realizations creation.
	 * @return data from database as {@code List}.
	 */
	public List<Todes> getEntities(Factory<Todes> factory) {
		return REPOSITORY.query(getRequest(), factory);
	}
}