package com.jbion.candyboxcheater.view.converters;

import javafx.util.StringConverter;

/**
 * Provides an implementation of {@link StringConverter} that associates each
 * {@link String} of an array to its index in that array.
 */
public class IndexStringConverter extends StringConverter<Number> {

	private final String[] table;

	/**
	 * Creates a new {@link IndexStringConverter} for the specified array.
	 * 
	 * @param values
	 *            the array of strings
	 */
	public IndexStringConverter(final String... values) {
		this.table = values;
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
