package com.jbion.candyboxcheater.game.variables;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import com.jbion.candyboxcheater.game.Key;

/**
 * Represents a game variable instance, including its value and disabled state.
 */
public class Variable {

	static final String TYPE_BOOL = "bool";
	static final String TYPE_STRING = "string";
	static final String TYPE_NUMBER = "number";

	private String type;
	private String name;

	private StringProperty stringValue;
	private BooleanProperty disabled;

	/**
	 * Creates a new {@link Variable}.
	 * 
	 * @param type
	 *            the type of the variable. It must be one of {@link #TYPE_BOOL},
	 *            {@link #TYPE_NUMBER} or {@link #TYPE_STRING}.
	 * @param name
	 *            the name of the variable
	 * @param value
	 *            the string representation of the value of the variable
	 * @return the created variable of the specific class corresponding to the
	 *         specified {@code type}.
	 */
	public static Variable create(String type, String name, String value) {
		switch (type) {
		case TYPE_BOOL:
			return new BooleanVariable(name, value);
		case TYPE_NUMBER:
			return new NumberVariable(name, value);
		case TYPE_STRING:
			return new Variable(TYPE_STRING, name, value);
		default:
			throw new IllegalArgumentException("Unknown type '" + type + "'");
		}
	}

	/**
	 * Creates a new {@link Variable}.
	 * 
	 * @param type
	 *            the type of the variable. It should be one of {@link #TYPE_BOOL},
	 *            {@link #TYPE_NUMBER} or {@link #TYPE_STRING}.
	 * @param name
	 *            the name of the variable
	 * @param value
	 *            the string representation of the value of the variable
	 */
	protected Variable(String type, String name, String value) {
		super();
		this.type = type;
		this.name = name;
		this.stringValue = new SimpleStringProperty(value);
		this.disabled = new SimpleBooleanProperty(false);
	}

	/**
	 * Returns the enum {@link Key} value of this variable.
	 * 
	 * @return the enum {@link Key} value of this variable.
	 */
	public Key getKey() {
		return Key.valueOf(name);
	}

	/**
	 * Returns the {@link BooleanProperty} representing the disabled state of this
	 * variable. When {@code true} this property means this variable can't be set.
	 * 
	 * @return the disabled property of this variable
	 */
	public BooleanProperty disabledProperty() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled.set(disabled);
	}

	public boolean getDisabled() {
		return disabled.get();
	}

	public StringProperty stringValueProperty() {
		return stringValue;
	}

	public void setStringValue(String value) {
		this.stringValue.set(value);
	}

	public String getStringValue() {
		return stringValue.get();
	}

	public void updateTo(Variable var) {
		if (!name.equals(var.name)) {
			throw new IllegalArgumentException("Cannot clone variable '" + var.name + "' into this variable named '"
					+ name + "'");
		}
		if (!type.equals(var.type)) {
			throw new IllegalArgumentException("This " + type + " variable '" + name + "', cannot take the given "
					+ var.type + " value");
		}
		this.stringValue.set(var.getStringValue());
	}

	/**
	 * Returns a {@link StringProperty} that is suitable for presentation.
	 * 
	 * @return a {@link StringProperty} that is suitable for presentation.
	 */
	public StringProperty displayValueProperty() {
		return stringValue;
	}

	@Override
	public String toString() {
		return type + ' ' + name + '=' + stringValue.get();
	}
}
