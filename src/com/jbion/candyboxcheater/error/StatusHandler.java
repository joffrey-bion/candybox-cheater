package com.jbion.candyboxcheater.error;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;

public class StatusHandler {

	private BooleanProperty isError;
	private StringProperty text;

	public StatusHandler(ChangeListener<Boolean> isErrorListener, Property<String> textProperty) {
		isError = new SimpleBooleanProperty(false);
		text = new SimpleStringProperty("");
		if (isErrorListener != null) {
			isError.addListener(isErrorListener);
		}
		if (textProperty != null) {
			textProperty.bind(text);
		}
	}

	public void error(String msg) {
		System.err.println(msg);
		isError.set(true);
		text.set(msg);
	}

	public void message(String msg) {
		System.out.println(msg);
		isError.set(false);
		text.set(msg);
	}

}
