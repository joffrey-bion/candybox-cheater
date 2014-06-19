package com.jbion.candyboxcheater.view.converters;

import java.util.Collection;
import java.util.LinkedHashMap;

import javafx.util.StringConverter;

/**
 * A simple generic implementation of {@link StringConverter}.
 * 
 * @param <T>
 *            the type to map with strings
 */
public class StringMapping<T> extends StringConverter<T> {

	private final LinkedHashMap<T, String> CODES_TO_NAMES = new LinkedHashMap<>();
	private final LinkedHashMap<String, T> NAMES_TO_CODES = new LinkedHashMap<>();

	protected void put(T code, String name) {
		CODES_TO_NAMES.put(code, name);
		NAMES_TO_CODES.put(name, code);
	}

	public Collection<String> getNames() {
		return CODES_TO_NAMES.values();
	}

	@Override
	public String toString(T code) {
		String res = CODES_TO_NAMES.get(code);
		return res;
	}

	@Override
	public T fromString(String string) {
		T res = NAMES_TO_CODES.get(string);
		return res;
	}
}
