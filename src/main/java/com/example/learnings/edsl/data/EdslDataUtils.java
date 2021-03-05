package com.example.learnings.edsl.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

public class EdslDataUtils {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(EdslDataUtils.class);



	public static int convertStringToInteger(String element) {
		int elementValue = 0;
		try{
			if(!StringUtils.isEmpty(element)){
				elementValue = (int)(Double.parseDouble(element));
			}
		}catch(NumberFormatException e){
			LOGGER.error("Illegal Argument {}",element,e.getMessage(),e);

		}

		return elementValue;

	}

	


	public static String convertDateToString(Date date, SimpleDateFormat simpleDateFormat) {
		String response = "";
		try {
			response = simpleDateFormat.format(date);
		} catch (Exception e) {
			LOGGER.error("Error Occurred while converting date to string : ", e);
		}
		return response;
	}


	public static <T>
	Stream<T> collectionToStream(Collection<T> collection) {
		return Optional.ofNullable(collection)
				.map(Collection::stream)
				.orElseGet(Stream::empty);
	}

	public static double convertStringToDouble(String element){
		double elementValue = 0;
		try{
			if(!StringUtils.isEmpty(element)){
				elementValue = Double.parseDouble(element);
			}
		}catch(NumberFormatException e){
			LOGGER.error("Illegal Argument {}",element,e.getMessage(),e);
		}

		return elementValue;

	}
}
