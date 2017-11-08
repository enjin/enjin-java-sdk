package com.enjin.coin.sdk.util;

import java.util.Map;

public class ValidationUtils {

	/**
	 * Method to check if a string is empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {		
		boolean isEmpty = false;
		if (str == null || str.length() == 0) {
			isEmpty = true;
		}
		
		return isEmpty;
	}

	/**
	 * Method to check if a string is not empty
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {		
		boolean isNotEmpty = false;
		if (str != null && str.length() > 0) {
			isNotEmpty = true;
		}
		
		return isNotEmpty;
	}

	/**
	 * Method to check if an array is empty 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		boolean isEmpty = false;
		if (array == null || array.length == 0) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	/**
	 * Method to check if an array is not empty 
	 * @param array
	 * @return
	 */
	public static boolean isNotEmpty(Object[] array) {
		boolean isNotEmpty = false;
		if (array != null && array.length > 0) {
			isNotEmpty = true;
		}
		
		return isNotEmpty;
	}

	/**
	 * Method to check if a map is empty
	 * @param array
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map) {
		boolean isEmpty = false;
		if (map == null || map.isEmpty()) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	/**
	 * Method to check if a map is not empty
	 * @param array
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Map map) {
		boolean isNotEmpty = false;
		if (map != null && !map.isEmpty()) {
			isNotEmpty = true;
		}
		
		return isNotEmpty;
	}
}
