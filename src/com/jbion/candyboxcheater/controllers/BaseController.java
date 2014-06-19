package com.jbion.candyboxcheater.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.game.variables.BooleanVariable;
import com.jbion.candyboxcheater.game.variables.NumberVariable;
import com.jbion.candyboxcheater.game.variables.Variable;
import com.jbion.candyboxcheater.view.bindings.MultiBooleanBinding;
import com.jbion.candyboxcheater.view.converters.NumberToStringMapping;
import com.jbion.candyboxcheater.view.converters.StringMapping;

public abstract class BaseController implements Initializable {

	protected final GameState gameState = GameState.getInstance();

	protected GameState getGameState() {
		return gameState;
	}

	protected void bind(Label label, Key key) {
		Variable var = gameState.getVariable(key);
		label.textProperty().bind(var.displayValueProperty());
		label.disableProperty().bind(var.disabledProperty());
	}

	protected void bind(CheckBox checkBox, Key booleanVariableKey) {
		BooleanVariable boolVar = gameState.getBooleanVariable(booleanVariableKey);
		checkBox.selectedProperty().bindBidirectional(boolVar.boolValueProperty());
		checkBox.disableProperty().bind(boolVar.disabledProperty());
	}

	protected void bind(IntegerProperty property, Key integerVariableKey) {
		NumberVariable longVar = gameState.getNumberVariable(integerVariableKey);
		property.bindBidirectional(longVar.longValueProperty());
	}

	protected void bind(ChoiceBox<String> choiceBox, Key key, String... items) {
		choiceBox.setItems(FXCollections.observableArrayList(items));
		Variable var = gameState.getVariable(key);
		choiceBox.setValue(var.getStringValue());
		choiceBox.valueProperty().bindBidirectional(var.stringValueProperty());
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	protected void bind(ChoiceBox<String> choiceBox, Key stringVariableKey, StringMapping<String> converter) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		Variable var = gameState.getVariable(stringVariableKey);
		choiceBox.setValue(converter.toString(var.getStringValue()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), var.stringValueProperty(), converter);
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	protected void bindBoxToNumbers(ChoiceBox<String> choiceBox, Key numberVariableKey, String[] values) {
		NumberToStringMapping converter = new NumberToStringMapping(values);
		choiceBox.setItems(FXCollections.observableArrayList(values));
		NumberVariable var = gameState.getNumberVariable(numberVariableKey);
		choiceBox.setValue(converter.toString(var.getLongValue()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), var.longValueProperty(), converter);
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	protected void bindBoxToProgressiveBooleans(ChoiceBox<String> choiceBox, String[] values, Key... booleanKeys) {
		NumberToStringMapping converter = new NumberToStringMapping(values);
		choiceBox.setItems(FXCollections.observableArrayList(values));
		LongProperty tempProperty = new SimpleLongProperty();
		MultiBooleanBinding.createMultiBooleanBinding(gameState, tempProperty, booleanKeys);
		choiceBox.setValue(converter.toString(tempProperty.get()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), tempProperty, converter);
	}
}
