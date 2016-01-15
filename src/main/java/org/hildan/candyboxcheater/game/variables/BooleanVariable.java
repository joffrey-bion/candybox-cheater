package org.hildan.candyboxcheater.game.variables;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.util.converter.BooleanStringConverter;

public class BooleanVariable extends Variable {

	private BooleanProperty boolValue;

	public BooleanVariable(String name, String value) {
		super(TYPE_BOOL, name, value);
		boolValue = new SimpleBooleanProperty(Boolean.parseBoolean(value));
		Bindings.bindBidirectional(stringValueProperty(), boolValue, new BooleanStringConverter());
	}

	public BooleanProperty boolValueProperty() {
		return boolValue;
	}

	public void setBooleanValue(boolean value) {
		boolValue.set(value);
	}

	public boolean getBooleanValue() {
		return boolValue.get();
	}

	@Override
	public void setStringValue(String value) {
		// parses any incorrect value as 'false'
		boolean b = Boolean.parseBoolean(value);
		super.setStringValue(String.valueOf(b));
	}
}
