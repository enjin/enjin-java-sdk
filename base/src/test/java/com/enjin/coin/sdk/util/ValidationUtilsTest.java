package com.enjin.coin.sdk.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ValidationUtilsTest {
	
	@Test
	public void testConstructor() {
		ValidationUtils validationUtils = new ValidationUtils();
		assertNotNull(validationUtils);
	}

	@Test
	public void testIsEmpty_String_False() {
		String str = "str";
		boolean isEmpty = ValidationUtils.isEmpty(str);
		assertFalse(isEmpty);
	}
	
	@Test
	public void testIsEmpty_String_TrueNull() {
		String str = null;
		boolean isEmpty = ValidationUtils.isEmpty(str);
		assertTrue(isEmpty);
	}
	
	@Test
	public void testIsEmpty_String_TrueEmpty() {
		String str = "";
		boolean isEmpty = ValidationUtils.isEmpty(str);
		assertTrue(isEmpty);
	}
	
	@Test
	public void testIsNotEmpty_String_FalseEmpty() {
		String str = "";
		boolean isEmpty = ValidationUtils.isNotEmpty(str);
		assertFalse(isEmpty);
	}
	@Test
	public void testIsNotEmpty_String_FalseNull() {
		String str = null;
		boolean isEmpty = ValidationUtils.isNotEmpty(str);
		assertFalse(isEmpty);
	}
	@Test
	public void testIsNotEmpty_String_True() {
		String str = "str";
		boolean isEmpty = ValidationUtils.isNotEmpty(str);
		assertTrue(isEmpty);
	}
	
	@Test
	public void testIsEmpty_Array_False() {
		Object[] arr = new Object[] {new Object()};
		boolean isEmpty = ValidationUtils.isEmpty(arr);
		assertFalse(isEmpty);
	}
	
	@Test
	public void testIsEmpty_Array_TrueNull() {
		Object[] arr = null;
		boolean isEmpty = ValidationUtils.isEmpty(arr);
		assertTrue(isEmpty);
	}
	
	@Test
	public void testIsEmpty_Array_TrueEmpty() {
		Object[] arr = new Object[] {};
		boolean isEmpty = ValidationUtils.isEmpty(arr);
		assertTrue(isEmpty);
	}
	
	@Test
	public void testIsNotEmpty_Array_FalseEmpty() {
		Object[] arr = new Object[] {};
		boolean isEmpty = ValidationUtils.isNotEmpty(arr);
		assertFalse(isEmpty);
	}
	@Test
	public void testIsNotEmpty_Array_FalseNull() {
		Object[] arr = null;
		boolean isEmpty = ValidationUtils.isNotEmpty(arr);
		assertFalse(isEmpty);
	}
	@Test
	public void testIsNotEmpty_Array_True() {
		Object[] arr = new Object[] {new Object()};
		boolean isEmpty = ValidationUtils.isNotEmpty(arr);
		assertTrue(isEmpty);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIsEmpty_Map_False() {
		Map map = new HashMap();
		map.put("key", "value");
		boolean isEmpty = ValidationUtils.isEmpty(map);
		assertFalse(isEmpty);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void testIsEmpty_Map_TrueNull() {
		Map map = null;
		boolean isEmpty = ValidationUtils.isEmpty(map);
		assertTrue(isEmpty);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void testIsEmpty_Map_TrueEmpty() {
		Map map = new HashMap();
		boolean isEmpty = ValidationUtils.isEmpty(map);
		assertTrue(isEmpty);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void testIsNotEmpty_Map_FalseEmpty() {
		Map map = new HashMap();
		boolean isEmpty = ValidationUtils.isNotEmpty(map);
		assertFalse(isEmpty);
	}
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void testIsNotEmpty_Map_FalseNull() {
		Map map = null;
		boolean isEmpty = ValidationUtils.isNotEmpty(map);
		assertFalse(isEmpty);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIsNotEmpty_Map_True() {
		Map map = new HashMap();
		map.put("key", "value");
		boolean isEmpty = ValidationUtils.isNotEmpty(map);
		assertTrue(isEmpty);
	}
}
