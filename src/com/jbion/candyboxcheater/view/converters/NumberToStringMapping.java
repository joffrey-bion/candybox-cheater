package com.jbion.candyboxcheater.view.converters;

import javafx.util.StringConverter;

/**
 * Provides an implementation of {@link StringConverter} for numbers conversion,
 * fixing {@code null} pointer problems. This class also provides simple
 * initialization
 */
public class NumberToStringMapping extends StringConverter<Number> {

	private final String[] table;

	public NumberToStringMapping(final String... values) {
		table = values;
	}

	protected void put(Number code, String name) {
		table[code.intValue()] = name;
	}

	@Override
	public String toString(Number number) {
		return table[number.intValue()];
	}

	@Override
	public Number fromString(String string) {
		if (string == null) {
			return null;
		}
		for (int i = 0; i < table.length; i++) {
			if (table[i].equalsIgnoreCase(string)) {
				return i;
			}
		}
		return null;
	}
}
