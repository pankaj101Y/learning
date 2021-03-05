package com.example.learnings.edsl.services;//package com.airtel.pe.eDSL.acquisition.adapter.impl;

import java.io.IOException;
import java.net.URI;

import com.example.learnings.edsl.utility.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class ESBAdapterImpl {

	private static Logger logger = LoggerFactory.getLogger(ESBAdapterImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	//@HystrixCommand(commandKey="esb", fallbackMethod="pingFallbackPost")
	public <T> ResponseEntity<T> getResponseFromESB(String url, String userName, String password, Class<T> responseType)
			throws JsonParseException, JsonMappingException, IOException {

		logger.info("Request for ESB {}", url);
		try {
			HttpEntity<String> request = Utility.getHttpEntity(userName, password);
			ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
			logger.info("Request {} , Response from ESB {}", url, mapper.writeValueAsString(response.getBody()));
			return response;
		} catch (HttpStatusCodeException hte) {
			String responseString = hte.getResponseBodyAsString();
			logger.error("Request {} , Error Response {}", url, responseString);
			T responseObject = (T) mapper.readValue(responseString, responseType);
			ResponseEntity<T> response = new ResponseEntity<T>(responseObject, hte.getStatusCode());
			return response;
		}

	}

	public <T> ResponseEntity<T> putResponseFromESB(String url, String userName, String password, Object request,
			Class<T> responseType) throws JsonParseException, JsonMappingException, IOException {

		ResponseEntity<T> response = null;
		try {
			logger.info("Request for ESB {} ", url);

			HttpEntity<Object> requestHeader = Utility.getHttpEntityForPutRequest(userName, password, request,
					org.springframework.http.MediaType.APPLICATION_JSON);
			response = restTemplate.exchange(url, HttpMethod.PUT, requestHeader, responseType);
			logger.info("Request {} ,Response from ESB {}", request.toString(),
					mapper.writeValueAsString(response.getBody()));
		} catch (HttpStatusCodeException hte) {
			String responseString = hte.getResponseBodyAsString();
			logger.error("Request {} , Error Response {}", request.toString(), responseString);
			try {
				T responseObject = (T) mapper.readValue(responseString, responseType);
				response = new ResponseEntity<T>(responseObject, hte.getStatusCode());
			} catch (JsonParseException | JsonMappingException e) {
				response = new ResponseEntity<T>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return response;
	}

	public <T> ResponseEntity<T> postResponseFromESB(String url, String userName, String password, Object request,
			Class<T> responseType) throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<T> response = null;
		try {
			logger.info("Url for ESB {}", url);
			logger.debug("Request for ESB {}", request.toString());
			HttpEntity<Object> requestHeader = Utility.getHttpEntityForPostRequest(userName, password, request,
					org.springframework.http.MediaType.APPLICATION_JSON);
			response = restTemplate.postForEntity(url, requestHeader, responseType, request);
			logger.info("Response from ESB {}",
					mapper.writeValueAsString(response.getBody()));
		} catch (HttpStatusCodeException hte) {
			String responseString = hte.getResponseBodyAsString();
			logger.error("Request {} , Error Response {}", request.toString(), responseString);
			try{
				T responseObject = (T) mapper.readValue(responseString, responseType);
				response = new ResponseEntity<T>(responseObject, hte.getStatusCode());
			}catch(JsonParseException | JsonMappingException e){
				response = new ResponseEntity<T>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return response;
	}

	public <T> ResponseEntity<T> pingFallbackPost(String url, String userName, String password, Class<T> responseType)
			throws JsonParseException, JsonMappingException, IOException {
		return null;
	}


	public <T> ResponseEntity<T> getResponseFromESB(URI uri, String userName, String password, Class<T> responseType)
			throws JsonParseException, JsonMappingException, IOException {

		logger.info("Request for ESB {}", uri);
		try {
			HttpEntity<String> request = Utility.getHttpEntity(userName, password);
			ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, request, responseType);
			logger.info("Request {} , Response from ESB {}", uri, mapper.writeValueAsString(response.getBody()));
			return response;
		} catch (HttpStatusCodeException hte) {
			String responseString = hte.getResponseBodyAsString();
			logger.error("Request {} , Error Response {}", uri, responseString);
			T responseObject = (T) mapper.readValue(responseString, responseType);
			ResponseEntity<T> response = new ResponseEntity<T>(responseObject, hte.getStatusCode());
			return response;
		}

	}



}
