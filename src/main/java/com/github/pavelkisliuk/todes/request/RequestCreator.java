package com.github.pavelkisliuk.todes.request;

import com.github.pavelkisliuk.todes.entity.*;

public class RequestCreator {
	private StringBuilder request;

	public static class Request {
		private Requestable requestable;
		private StringBuilder request;

		public Request(Requestable requestable) {
			this.requestable = requestable;
			request = new StringBuilder();
		}

		public Request select() {
			request.append(requestable.select()).append(" ");
			return this;
		}

		public Request select(String columns) {
			request.append(requestable.select(columns)).append(" ");
			return this;
		}

		public Request entity(Class todes) {
			if(todes == Cv.class) {
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

		public Request equal(String name, String value) {
			request.append(requestable.equal(name, value)).append(" ");
			return this;
		}

		public Request and() {
			request.append(requestable.and()).append(" ");
			return this;
		}

		public Request or() {
			request.append(requestable.or()).append(" ");
			return this;
		}

		public Request like(String column, String pattern) {
			request.append(requestable.like(column, pattern)).append(" ");
			return this;
		}

		public RequestCreator toRequest() {
			return new RequestCreator(this);
		}
	}

	private RequestCreator(Request request) {
		this.request = request.request;
	}

	public String getRequest() {
		return request.toString();
	}

//	public Todes getEntity() {
//		return entity;
//	}
}