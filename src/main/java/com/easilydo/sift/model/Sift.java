package com.easilydo.sift.model;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Sift {
	private static Logger logger = LoggerFactory.getLogger(Sift.class);

	@JsonIgnore
	private Domain domain;
	@JsonProperty("sift_id")
	private long siftId;
	@JsonProperty("mime_id")
	private String mimeId;
	@JsonProperty("mid")
	private String mid;
	@JsonProperty("fid")
	private String fid;
	@JsonProperty("gmid")
	private String gmid;
	@JsonIgnore
	private Date emailTime;
	@JsonProperty("username")
	private String username;
	@JsonIgnore
	private String emailId;		//this is accountId, renamed, so it will not clash with prop in Invoice
	@JsonProperty("source_id")
	private long sourceId;
	@JsonProperty("host")
	private String host;
	@JsonProperty("mime")
	private String mime;

	protected static final ObjectMapper objectMapper = new ObjectMapper();

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@JsonProperty("sift_id")
	public long getSiftId() {
		return siftId;
	}

	@JsonProperty("sift_id")
	public void setSiftId(long siftId) {
		this.siftId = siftId;
	}

	@JsonProperty("mime_id")
	public String getMimeId() {
		return mimeId;
	}

	@JsonProperty("mime_id")
	public void setMimeId(String mimeId) {
		this.mimeId = mimeId;
	}

	@JsonProperty("mid")
	public String getMid() {
		return mid;
	}

	@JsonProperty("mid")
	public void setMid(String mid) {
		this.mid = mid;
	}

	@JsonProperty("fid")
	public String getFid() {
		return fid;
	}

	@JsonProperty("fid")
	public void setFid(String fid) {
		this.fid = fid;
	}

	@JsonProperty("gmid")
	public String getGmid() {
		return gmid;
	}

	@JsonProperty("gmid")
	public void setGmid(String gmid) {
		this.gmid = gmid;
	}

	public Date getEmailTime() {
		return emailTime;
	}

	public void setEmailTime(Date emailTime) {
		this.emailTime = emailTime;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@JsonProperty("source_id")
	public long getSourceId() {
		return sourceId;
	}

	@JsonProperty("source_id")
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	@JsonProperty("host")
	public String getHost() {
		return host;
	}

	@JsonProperty("host")
	public void setHost(String host) {
		this.host = host;
	}

	@JsonProperty("mime")
	public String getMime() {
		return mime;
	}

	@JsonProperty("mime")
	public void setMime(String mime) {
		this.mime = mime;
	}

	public static Sift unmarshallSift(JsonNode result) {
		//logger.info(result.toString());
		JsonNode payload = result.has("@type") ? result : result.get("payload");
		String type = payload.get("@type").textValue();

		if(type.startsWith("x-")) {
			type = type.substring(2);
		}

		Domain domain = Domain.getDomain(result.get("domain").asText());
		ObjectNode root = (ObjectNode) result.deepCopy();

		//move payload to top level
		Iterator<Map.Entry<String,JsonNode>> fieldIter = payload.fields();

		while(fieldIter.hasNext()) {
			Map.Entry<String,JsonNode> pair = fieldIter.next();
			String name = pair.getKey();

			if(name.startsWith("@")) {
				continue;
			}

			root.put(name, pair.getValue());
		}

		root.remove("payload");
		root.remove("@type");

		Sift sift; 
		try {
			sift = (Sift) objectMapper.treeToValue(root, domain.clazz);
		} catch(JsonProcessingException jpex) {
			logger.error("Failed to parse sift json", jpex);
			throw new RuntimeException(jpex);
		}

		sift.setDomain(domain);

		if(result.has("email_time")) {
			sift.setEmailTime(new Date(result.get("email_time").asLong() * 1000));
		}

		if(result.has("account_id")) {
			sift.setEmailId(result.get("account_id").asText());
		}

		return sift;
	}
}
