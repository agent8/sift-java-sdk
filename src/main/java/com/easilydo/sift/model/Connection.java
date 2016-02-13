package com.easilydo.sift.model;

import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang.builder.ToStringBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Connection {
	private static Logger logger = LoggerFactory.getLogger(Connection.class);

    	@JsonProperty("id")
	private long connId;
    	@JsonProperty("email")
	private String email;
    	@JsonProperty("email_type")
	private EmailType emailType;
    	@JsonProperty("state")
	private ConnState state;

	public long getConnId() {
		return connId;
	}

	public void setConnId(long connId) {
		this.connId = connId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	public ConnState getConnState() {
		return state;
	}

	public void setConnState(ConnState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static Connection unmarshallConnection(JsonNode result) {
		try {
			Connection conn = (Connection) Sift.objectMapper.treeToValue(result, Connection.class);

			return conn;
		} catch(JsonProcessingException jpex) {
			logger.error("Failed to parse sift json", jpex);
			throw new RuntimeException(jpex);
		}
	}

	public static enum EmailType {
		GOOGLE("google"),
		YAHOO("yahoo"),
		LIVE("live"),
		IMAP("imap"),
		EXCHANGE("exchange");

		private final String name;
		private static Map<String, EmailType> constants = new HashMap<String, EmailType>();

		static {
			for (EmailType s: values()) {
				constants.put(s.name, s);
			}
		}

		EmailType(String name) {
			this.name = name;
		}

		@JsonValue
		@Override
		public String toString() {
			return this.name;
		}

    		@JsonCreator
		public static EmailType getEmailType(String type) {
			return constants.get(type);
		}
	}

	public static enum ConnState {
		VALID("valid"),
		INVALID("invalid");

		private final String name;
		private static Map<String, ConnState> constants = new HashMap<String, ConnState>();

		static {
			for (ConnState s: values()) {
				constants.put(s.name, s);
			}
		}

		ConnState(String name) {
			this.name = name;
		}

		@JsonValue
		@Override
		public String toString() {
			return this.name;
		}

    		@JsonCreator
		public static ConnState getConnState(String type) {
			return constants.get(type);
		}
	}
}
