package com.huluset.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {
	private static JsonGenerator  getJsonGenerator(StringWriter sw){
		ObjectMapper objectMapper = new ObjectMapper();
		JsonGenerator jsonGenerator = null;;
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(sw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonGenerator;
	}
	
	public static String toJson(Object obj){
		StringWriter sw = new StringWriter();
		JsonGenerator jsonGenerator = getJsonGenerator(sw);
		try {
			jsonGenerator.writeObject(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
}
