package com.jbion.candyboxcheater.controllers.widgets;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class IntegerFieldController implements Initializable {

	@FXML
	private TextField field;

	private IntegerProperty value;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		field.setText("0");
		value = new SimpleIntegerProperty(0);
		Bindings.bindBidirectional(field.textProperty(), value, new NumberStringConverter());
	}

	public IntegerProperty valueProperty() {
		return value;
	}

	@FXML
	void decrement(@SuppressWarnings("unused") ActionEvent event) {
		int i = value.get();
		if (i > 0) {
			value.set(i - 1);
		}
	}

	@FXML
	void increment(@SuppressWarnings("unused") ActionEvent event) {
		value.set(value.get() + 1);
	}
}
