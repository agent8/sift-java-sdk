package com.easilydo.sift.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sift {
	private static Logger logger = LoggerFactory.getLogger(Sift.class);

	private long siftId;
	private String mimeId;
	private String mid;
	private String fid;
	private String accountId;

	protected static final ObjectMapper objectMapper = new ObjectMapper();

	public Domain getDomain() {
		return Domain.UNKNOWN;
	}

	public long getSiftId() {
		return siftId;
	}

	public void setSiftId(long siftId) {
		this.siftId = siftId;
	}

	public String getMimeId() {
		return mimeId;
	}

	public void setMimeId(String mimeId) {
		this.mimeId = mimeId;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public static Sift unmarshallSift(JsonNode result) {
		JsonNode payload = result.has("@type") ? result : result.get("payload");
		String type = payload.get("@type").textValue();

		if(type.startsWith("x-")) {
			type = type.substring(2);
		}

		Sift sift; 
		try {
			sift = (Sift) objectMapper.treeToValue(payload, Class.forName("com.easilydo.sift.model.gen." + type));
		} catch(ClassNotFoundException cnfex) {
			logger.error("Could not find class for type: " + type);
			sift = new Sift();
		} catch(JsonProcessingException jpex) {
			logger.error("Failed to parse sift json", jpex);
			throw new RuntimeException(jpex);
		}

		if(result.has("sift_id")) {
			sift.setSiftId(result.get("sift_id").asLong());
			sift.setMimeId(result.get("mime_id").asText());
			sift.setMid(result.get("mid").asText());
			sift.setFid(result.get("fid").asText());
			sift.setAccountId(result.get("account_id").asText());
		}

		return sift;
	}
}
