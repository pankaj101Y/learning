package com.example.learnings.edsl.utility;//package com.airtel.pe.eDSL.common.utility;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utility {
	
	static final List<String> dateFormatList=new ArrayList<String>(){
		/**
		 *
		 */

	{
		add("yyyy-MM-dd'T'HH:mm:ss.SSS");
		add("dd/MM/yyyy HH:mm:ss");
		add("E MMM dd HH:mm:ss Z yyyy");
		add("dd/MM/yyyy");
	}};

	public static HttpEntity<String> getHttpEntity(final String username, final String password) {

		HttpHeaders httpHeader = new HttpHeaders() {

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			{
				String encodedAuth = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
				set("Content-Type", "application/json");
				set("Accept", "application/json");
			}
		};
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeader);
		return httpEntity;
	}

	public static  HttpEntity<Object> getHttpEntityForPutRequest(final String username, final String password,
			final Object request,final org.springframework.http.MediaType contentType) {

		HttpHeaders httpHeader = new HttpHeaders() {

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			{
				String encodedAuth = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
				setContentType(contentType);
			}
		};
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(request, httpHeader);
		return httpEntity;
	}

	public static <T> HttpEntity<T> getHttpEntityForPostRequest(final String username, final String password,
			final T request,final org.springframework.http.MediaType contentType) {

		HttpHeaders httpHeader = new HttpHeaders() {

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			{
				String encodedAuth = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
				setContentType(contentType);
			}
		};
		HttpEntity<T> httpEntity = new HttpEntity<T>(request, httpHeader);
		return httpEntity;
	}

	public static <T> HttpEntity<T> getHttpEntityForEvRequest(final T request,
			final org.springframework.http.MediaType contentType) {

		HttpHeaders httpHeader = new HttpHeaders() {

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			{
				setContentType(contentType);
			}
		};

		HttpEntity<T> httpEntity = new HttpEntity<T>(request, httpHeader);
		return httpEntity;
	}

	public static Date parseStringToDate(String date) throws ParseException {

		for(String dateFormat:dateFormatList){
			try{
				if (date != null) {
					SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
					return sdf.parse(date);
				}
			}catch(Exception e){
				log.error("Error while parsing date {} to format {}",date,dateFormat);
			}
		}

		return null;
	}
	
	public static Date parseDobStringToDate(String date) throws ParseException {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			return sdf.parse(date);
		}
		return null;
	}


	public static  String removeAllSpaces(String str){
		return  str.replaceAll("\\s+","");
	}
	
	public static HashMap<String, List<String>> convertToMap(String property) {
			try {
				List<String> list=Arrays.asList(property.split(";"));
				HashMap<String, List<String>>  map=new HashMap<String, List<String>>();
				for (String milestone : list) {
					map.put(milestone.split(":")[0], Arrays.asList(milestone.split(":")[1].split(",")));
				}
				return map;
			} catch (Exception e) {
				log.error(" covertToMap @Error ",e);
				return null;
			}
		}

}
