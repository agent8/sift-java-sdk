package com.easilydo.sift.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.StringWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.easilydo.sift.crypto.Signatory;
import com.easilydo.sift.model.Connection;
import static com.easilydo.sift.model.Connection.*;
import com.easilydo.sift.model.Domain;
import com.easilydo.sift.model.Sift;
import com.easilydo.sift.model.ShipmentStatus;

/**
 * Primary class in the Sift Java SDK; used for interacting with the sift server.
 * After constructing an instance of the class with their api and secret keys,
 * the sift developer can make sift api calls by invoking the corresponding method.
 * All apis in the <a href="https://developer.easilydo.com/sift/documentation">Sift API docs</a>
 * are implemented, with the exception of the Connect Tokens and Connect Emails, which are intended
 * for a front end web flow.
 * <p>
 * This class handles all the common parameter packaging as well as request signature generation.
 * Any errors that occur during the api call (timeouts, http errors, etc.) 
 * are thrown as {@link ApiException}.
 */
public class ApiManager {
	private static Logger logger = LoggerFactory.getLogger(ApiManager.class);

	public static final String API_ENDPOINT = "https://api.easilydo.com";

	private String apiKey;
	private Signatory signatory;

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	* Sole constructor
	* @param apiKey	sift developer's api key
	* @param secretKey	sift developer's secret key
	*/
	public ApiManager(String apiKey, String secretKey) {
		this.apiKey = apiKey;
		this.signatory = new Signatory(secretKey);
	}

	/**
	* Get a list of sifts for the given user
	* @param username	username of the user to fetch sifts for
	* @return 	list of sifts in descending order of last update time
	*/
	public List<Sift> listSifts(String username) {
		return listSifts(username, null, null, null);
	}

	/**
	* Get a list of sifts for the given user since a certain date
	* @param username	username of the user to fetch sifts for
	* @param lastUpdateTime	only return sifts updated since this date
	* @return 	list of sifts in descending order of last update time
	*/
	public List<Sift> listSifts(String username, Date lastUpdateTime) {
		return listSifts(username, lastUpdateTime, null, null);
	}

	/**
	* Get a list of sifts for the given user since a certain date
	* @param username	username of the user to fetch sifts for
	* @param lastUpdateTime	only return sifts updated since this date
	* @param offset	used for paging, where to start
	* @param limit	maximum number of results to return
	* @return 	list of sifts in descending order of last update time
	*/
	public List<Sift> listSifts(String username, Date lastUpdateTime, Integer offset, Integer limit) {
		List<Sift> sifts = new ArrayList<Sift>();
		String path = String.format("/v1/users/%s/sifts", username);

		Map<String,Object> params = new HashMap<String,Object>();

		if(lastUpdateTime != null) {
			params.put("last_update_time", getEpochSecs(lastUpdateTime));
		}

		if(offset != null) {
			params.put("offset", offset);
		}

		if(limit != null) {
			params.put("limit", limit);
		}

		addCommonParams("GET", path, params);

		JsonNode results = executeRequest(Unirest.get(API_ENDPOINT + path).queryString(params));

		for(JsonNode result: results) {
			sifts.add(Sift.unmarshallSift(result));
		}

		return sifts;
	}

	/**
	* Get a particular sift
	* @param username	username of the user to fetch sifts for
	* @param siftId	numeric id of the sift to be fetched
	* @return 	the sift corresponding to the provided id
	*/
	public Sift getSift(String username, long siftId) {
		String path = String.format("/v1/users/%s/sifts/%d", username, siftId);

		Map<String,Object> params = new HashMap<String,Object>();

		//TODO: add include_eml handling
		addCommonParams("GET", path, params);

		JsonNode result = executeRequest(Unirest.get(API_ENDPOINT + path).queryString(params));

		Sift sift = Sift.unmarshallSift(result);

		return sift;
	}

	/**
	* Get the status of a discovered shipment
	* @param username	username of the user
	* @param shipmentId	numeric id of the sift to be fetched
	* @return 	the status of the shipment
	*/
	public ShipmentStatus getShipmentStatus(String username, long shipmentId) {
		String path = String.format("/v1/users/%s/shipments/%d", username, shipmentId);

		Map<String,Object> params = getCommonParams("GET", path);

		JsonNode results = executeRequest(Unirest.get(API_ENDPOINT + path).queryString(params));

		ShipmentStatus shipmentStatus = null;
		if(results.size() > 0) {
			shipmentStatus = ShipmentStatus.getShipmentStatus(results.findValue("orderStatus").asText());
		}

		return shipmentStatus;
	}

	/**
	* Register a new user
	* @param username	username of the new user
	* @return 	the numeric user id of the newly created user
	*/
	public long addUser(String username) {
		String path = "/v1/users";

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("username", username);

		addCommonParams("POST", path, params);

		JsonNode result = executeRequest(Unirest.post(API_ENDPOINT + path).fields(params));

		return result.get("user_id").asLong();
	}

	/**
	* Deletes a user
	* @param username	username of the user to delete
	*/
	public void deleteUser(String username) {
		String path = String.format("/v1/users/%s", username);

		Map<String,Object> params = getCommonParams("DELETE", path);

		JsonNode result = executeRequest(Unirest.delete(API_ENDPOINT + path).fields(params));
	}

	/**
	* List a user's email connections
	* @param username	username of the new user 
	* @return 	the list of the user's connsctions
	*/
	public List<Connection> listConnections(String username) {
		return listConnections(username, null, null);
	}

	/**
	* List a user's email connections
	* @param username	username of the user whose connections are to be fetched
	* @param offset	used for paging, where to start
	* @param limit	maximum number of results to return
	* @return 	the list of the user's connsctions
	*/
	public List<Connection> listConnections(String username, Integer offset, Integer limit) {
		List<Connection> conns = new ArrayList<Connection>();
		String path = String.format("/v1/users/%s/email_connections", username);

		Map<String,Object> params = new HashMap<String,Object>();

		if(offset != null) {
			params.put("offset", offset);
		}

		if(limit != null) {
			params.put("limit", limit);
		}

		addCommonParams("GET", path, params);

		JsonNode results = executeRequest(Unirest.get(API_ENDPOINT + path).queryString(params));

		for(JsonNode result: results) {
			conns.add(Connection.unmarshallConnection(result));
		}

		return conns;
	}

	/**
	* Add a Gmail connection to the given user account
	* @param username	username of the user 
	* @param account	email address 
	* @param refreshToken	oauth refresh token of the account
	* @return 	a generated numeric id for the connection 
	*/
	public long addGmailConnection(String username, String account, String refreshToken) {
		Map<String,Object> credentials = new HashMap<String,Object>();
		credentials.put("refresh_token", refreshToken);
		return addEmailConnection(username, account, EmailType.GOOGLE, credentials);
	}

	/**
	* Add a Yahoo connection to the given user account
	* @param username	username of the user 
	* @param account	email address 
	* @param refreshToken	oauth refresh token of the account
	* @param redirectUri	redirect uri of the account
	* @return 	a generated numeric id for the connection 
	*/
	public long addYahooConnection(String username, String account, String refreshToken, String redirectUri) {
		Map<String,Object> credentials = new HashMap<String,Object>();
		credentials.put("refresh_token", refreshToken);
		credentials.put("redirect_uri", redirectUri);
		return addEmailConnection(username, account, EmailType.YAHOO, credentials);
	}

	/**
	* Add a Microsoft Live connection to the given user account
	* @param username	username of the user 
	* @param account	email address 
	* @param refreshToken	oauth refresh token of the account
	* @param redirectUri	redirect uri of the account
	* @return 	a generated numeric id for the connection 
	*/
	public long addLiveConnection(String username, String account, String refreshToken, String redirectUri) {
		Map<String,Object> credentials = new HashMap<String,Object>();
		credentials.put("refresh_token", refreshToken);
		credentials.put("redirect_uri", redirectUri);
		return addEmailConnection(username, account, EmailType.LIVE, credentials);
	}

	/**
	* Add an imap connection to the given user account
	* @param username	username of the user 
	* @param account	email address 
	* @param password	password for the email account
	* @param host	imap host to connect to
	* @return 	a generated numeric id for the connection 
	*/
	public long addImapConnection(String username, String account, String password, String host) {
		Map<String,Object> credentials = new HashMap<String,Object>();
		credentials.put("password", password);
		credentials.put("host", host);
		return addEmailConnection(username, account, EmailType.IMAP, credentials);
	}

	/**
	* Add a Microsoft Exchange connection to the given user account.
	* Sift will attempt to autodiscover the host and account name
	* @param username	username of the user 
	* @param email	email address 
	* @param password	password for the email account
	* @return 	a generated numeric id for the connection 
	*/
	public long addExchangeConnection(String username, String email, String password) {
		return addExchangeConnection(username, email, password, null, null);
	}

	/**
	* Add a Microsoft Exchange connection to the given user account.
	* The host and account name are provided explicitly in this case
	* @param username	username of the user 
	* @param email	email address 
	* @param password	password for the email account
	* @param host	exchange host to connect to
	* @param account	exchange account username
	* @return 	a generated numeric id for the connection 
	*/
	public long addExchangeConnection(String username, String email, String password, String host, String account) {
		Map<String,Object> credentials = new HashMap<String,Object>();
		credentials.put("email", email);
		credentials.put("password", password);

		if(host != null) {
			credentials.put("host", host);
		}

		return addEmailConnection(username, account, EmailType.EXCHANGE, credentials);
	}

	protected long addEmailConnection(String username, String account, EmailType type, Map<String,Object> credentials) {
		String path = String.format("/v1/users/%s/email_connections", username);

		Map<String,Object> params = new HashMap<String,Object>(credentials);
		params.put("account_type", type.toString());
		//params.put("account", account);

		addCommonParams("POST", path, params);

		JsonNode result = executeRequest(Unirest.post(API_ENDPOINT + path).fields(params));

		return result.get("id").asLong();
	}

	/**
	* Deletes an email connection
	* @param username	username of the user to delete
	* @param connId	numeric id of the email connection
	*/
	public void deleteEmailConnection(String username, long connId) {
		String path = String.format("/v1/users/%s/email_connections/%d", username, connId);

		Map<String,Object> params = getCommonParams("DELETE", path);

		JsonNode result = executeRequest(Unirest.delete(API_ENDPOINT + path).fields(params));
	}

	/**
	* Extracts available domain data from the provided eml file.
	* @param emlFile	the eml file
	* @return 	list of sifts objects with extracted data
	*/
	public List<Sift> discovery(File emlFile) {
		try {
			return discovery(new FileInputStream(emlFile));
		} catch(FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	* Extracts available domain data from the provided eml file.
	* @param emlStream	a stream of eml data
	* @return 	list of sifts objects with extracted data
	*/
	public List<Sift> discovery(InputStream emlStream) {
		List<Sift> sifts = new ArrayList<Sift>();
		String path = "/v1/discovery";
	
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("email", streamToString(emlStream).trim());

		addCommonParams("POST", path, params);

		JsonNode result = executeRequest(Unirest.post(API_ENDPOINT + path).fields(params));

		Iterator<JsonNode> iter = result.elements();
		while(iter.hasNext()) {
			sifts.add(Sift.unmarshallSift(iter.next()));
		}

		return sifts;
	}

	/**
	* Used to notify the Sift development team of emails that were not parsed correctly
	* @param emlFile	the eml file
	* @param locale	locale of the email 
	* @param timezone	timezone of the email 
	* @return 	json object with 2 boolean fields: "classfied" and "extracted"
	*/
	public JsonNode feedback(File emlFile, String locale, String timezone) {
		try {
			return feedback(new FileInputStream(emlFile), locale, timezone);
		} catch(FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	* Used to notify the Sift development team of emails that were not parsed correctly
	* @param emlStream	a stream of eml data
	* @param locale	locale of the email 
	* @param timezone	timezone of the email 
	* @return 	json object with 2 boolean fields: "classfied" and "extracted"
	*/
	public JsonNode feedback(InputStream emlStream, String locale, String timezone) {
		String path = "/v1/feedback";

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("email", streamToString(emlStream).trim());
		params.put("locale", locale);
		params.put("timezone", timezone);

		addCommonParams("POST", path, params);

		JsonNode result = executeRequest(Unirest.post(API_ENDPOINT + path).fields(params));

		return result;
	}

	protected JsonNode executeRequest(BaseRequest request) {
		try {
			HttpResponse<String> response = request.asString();
			if(response.getStatus() >= 400) {
				String msg = String.format("Bad HTTP response from sift server. code: %d message: %s", response.getStatus(), response.getStatusText());
				logger.error(msg);
				throw new ApiException(msg, response.getStatus());
			}

			JsonNode root = objectMapper.readTree(response.getBody());

			logger.debug(root.toString());

			int code = root.get("code").asInt();
			if(code >= 400) {
				String id = root.get("id").asText();
				String msg = String.format("Json rpc error response from sift server. requestId: %s code: %d message: %s", id, code, root.get("message").asText());
				logger.error(msg);
				throw new ApiException(msg, code, id);
			}

			return root.get("result");
		} catch(IOException ioex) {
			logger.error("Failed to parse json response from sift server");
			throw new ApiException("Failed to parse json response from sift server", ioex);
		} catch(UnirestException uniex) {
			logger.error("Exception making REST api call");
			throw new ApiException("Exception making REST api call", uniex);
		}
	}

	protected Map<String,Object> getCommonParams(String method, String path) {
		return addCommonParams(method, path, new HashMap<String,Object>());
	}

	protected Map<String,Object> addCommonParams(String method, String path, Map<String,Object> params) {
		params.put("api_key", apiKey);
		params.put("timestamp", System.currentTimeMillis() / 1000);
		params.put("signature", signatory.generateSignature(method, path, params));

		return params;
	}

	protected static long getEpochSecs(Date date) {
		return date.getTime() / 1000;
	}

	protected static String streamToString(InputStream stream) {
		try {
			char[] buf = new char[1024];
			InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
			StringWriter writer = new StringWriter();

			int numRead;
			while((numRead = reader.read(buf)) != -1) {
				writer.write(buf, 0, numRead);
			}

			reader.close();
			writer.flush();

			return writer.toString();
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) {
		ApiManager apiMan = new ApiManager(args[0], args[1]);

		List<Sift> sifts = apiMan.discovery(new File(args[2]));

		for(Sift sift: sifts) {
			logger.info(sift.toString());
		}
	}
}
