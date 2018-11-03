package br.com.steventos.utils;

public class StringUtils {

	public static String toGetter(String texto) {
		return "get" + texto.toUpperCase().charAt(0) + texto.toLowerCase().substring(1);
	}
	
	public static String toSetter(String texto) {
		return "set" + texto.toUpperCase().charAt(0) + texto.toLowerCase().substring(1);
	}
}
