package br.com.steventos.utils;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class CastUtils {

	private static final String CLASS_NAME = "className";
	private static final String MODEL_PACKAGE = "br.com.steventos.model.impl.";

	public static Object mapToPojo(Map map) throws ClassNotFoundException {

		String className = (String) map.get(CLASS_NAME);

		map.remove(CLASS_NAME);

		Class<?> clazz = Class.forName(MODEL_PACKAGE + className);

		ObjectMapper mapper = new ObjectMapper();

		return mapper.convertValue(map, clazz);
	}
}
