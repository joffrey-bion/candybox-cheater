package com.jbion.candyboxcheater.game.converters;

import java.util.Collection;
import java.util.LinkedHashMap;

import javafx.util.StringConverter;

public class StringMapping<T> extends StringConverter<T> {

	private final LinkedHashMap<T, String> CODES_TO_NAMES = new LinkedHashMap<>();
	private final LinkedHashMap<String, T> NAMES_TO_CODES = new LinkedHashMap<>();

	protected void put(T code, String name) {
		CODES_TO_NAMES.put(code, name);
		NAMES_TO_CODES.put(name, code);
		System.out.println("PUT: " + code + " -> " + name);
	}

	public Collection<String> getNames() {
		return CODES_TO_NAMES.values();
	}

	@Override
	public String toString(T code) {
		String res = CODES_TO_NAMES.get(code);
		System.out.println(getClass().getSimpleName() + ".toString(" + code + ") = " + res + "  (map size=" + CODES_TO_NAMES.size() + ")");
		return res;
	}

	@Override
	public T fromString(String string) {
		T res = NAMES_TO_CODES.get(string);
		System.out.println(getClass().getSimpleName() + ".fromString(" + string + ") = " + res + "  (map size=" + NAMES_TO_CODES.size() + ")");
		return res;
	}
}
