package com.jbion.candyboxcheater.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import com.jbion.candyboxcheater.bindings.MultiBooleanBinding;
import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.game.variables.BooleanVariable;
import com.jbion.candyboxcheater.game.variables.NumberVariable;
import com.jbion.candyboxcheater.game.variables.Variable;
import com.jbion.candyboxcheater.view.converters.IndexStringConverter;
import com.jbion.candyboxcheater.view.converters.StringMapping;

public abstract class AbstractBaseController implements Initializable {

	protected final GameState gameState = GameState.getInstance();

	/**
	 * Binds the specified {@link Label} to the value of the specified variable.
	 * 
	 * @param label
	 *            the label to bind
	 * @param key
	 *            the key of the variable to bind to the label
	 */
	protected void bind(Label label, Key key) {
		Variable var = gameState.getVariable(key);
		label.textProperty().bind(var.displayValueProperty());
		label.disableProperty().bind(var.disabledProperty());
	}

	/**
	 * Creates a bidirectional binding between the specified {@link CheckBox} and the
	 * specified boolean variable.
	 * 
	 * @param checkBox
	 *            the {@link CheckBox} to bind
	 * @param booleanVariableKey
	 *            the key to the {@link BooleanVariable} to bind
	 */
	protected void bind(CheckBox checkBox, Key booleanVariableKey) {
		BooleanVariable boolVar = gameState.getBooleanVariable(booleanVariableKey);
		checkBox.selectedProperty().bindBidirectional(boolVar.boolValueProperty());
		checkBox.disableProperty().bind(boolVar.disabledProperty());
	}

	/**
	 * Creates a bidirectional binding between the specified {@link IntegerProperty}
	 * and the specified number variable.
	 * 
	 * @param property
	 *            the {@link IntegerProperty} to bind
	 * @param integerVariableKey
	 *            the key to the {@link NumberVariable} to bind
	 */
	protected void bind(IntegerProperty property, Key integerVariableKey) {
		NumberVariable longVar = gameState.getNumberVariable(integerVariableKey);
		property.bindBidirectional(longVar.longValueProperty());
	}

	/**
	 * Creates a bidirectional binding between the specified choice box and the
	 * specified String variable.
	 * 
	 * @param choiceBox
	 *            the {@link ChoiceBox} to bind
	 * @param key
	 *            the key to the variable to bind
	 * @param values
	 *            the possible values for the variable
	 */
	protected void bind(ChoiceBox<String> choiceBox, Key key, String... values) {
		choiceBox.setItems(FXCollections.observableArrayList(values));
		Variable var = gameState.getVariable(key);
		choiceBox.setValue(var.getStringValue());
		choiceBox.valueProperty().bindBidirectional(var.stringValueProperty());
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	/**
	 * Creates a bidirectional binding between the specified choice box and the
	 * specified String variable.
	 * 
	 * @param choiceBox
	 *            the {@link ChoiceBox} to bind
	 * @param key
	 *            the key to the variable to bind
	 * @param converter
	 *            the converter to use when propagating changes. Its
	 *            {@link StringMapping#fromString(String)} method will be called to
	 *            convert the {@link ChoiceBox} values into variable values, and
	 *            {@link StringMapping#toString()} will be used for the other way
	 *            around.
	 */
	protected void bind(ChoiceBox<String> choiceBox, Key key, StringMapping<String> converter) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		Variable var = gameState.getVariable(key);
		choiceBox.setValue(converter.toString(var.getStringValue()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), var.stringValueProperty(), converter);
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	/**
	 * Creates a bidirectional binding between the specified {@link ChoiceBox} and
	 * the specified {@link NumberVariable}. Each value of the {@link ChoiceBox} is
	 * mapped to its 0-based index in the box.
	 * 
	 * @param choiceBox
	 *            the {@link ChoiceBox} to bind
	 * @param numberVariableKey
	 *            the key to the {@link NumberVariable} to bind
	 * @param values
	 *            the possible values for the {@link ChoiceBox}
	 */
	protected void bindBoxToNumbers(ChoiceBox<String> choiceBox, Key numberVariableKey, String[] values) {
		IndexStringConverter converter = new IndexStringConverter(values);
		choiceBox.setItems(FXCollections.observableArrayList(values));
		NumberVariable var = gameState.getNumberVariable(numberVariableKey);
		choiceBox.setValue(converter.toString(var.getLongValue()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), var.longValueProperty(), converter);
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	/**
	 * Creates a bidirectional binding between the specified {@link ChoiceBox} and
	 * the specified list of {@link BooleanVariable}s. Each value of the
	 * {@link ChoiceBox} corresponds to one of the variables, except the first
	 * choice.
	 * <ul>
	 * <li>The first choice is mapped to the state where all variables are
	 * {@code false}</li>
	 * <li>A choice corresponding to a variable {@code V} is mapped to the state
	 * where all variables up to (and including) {@code V} are {@code true}, and all
	 * others are {@code false}.</li>
	 * </ul>
	 * Notes:
	 * <ul>
	 * <li>When a variable {@code V} becomes {@code true}, all the variables before
	 * {@code V} become {@code true} as well, and the {@link ChoiceBox} is set to
	 * {@code V}.</li>
	 * <li>When a variable {@code V} becomes {@code false}, all the variables after
	 * {@code V} become {@code false} as well, and the {@link ChoiceBox} is set to
	 * the last {@code true} variable.</li>
	 * </ul>
	 * 
	 * @param choiceBox
	 *            the {@link ChoiceBox} to bind
	 * @param values
	 *            the possible values for the {@link ChoiceBox}
	 * @param booleanKeys
	 *            the keys to the {@link BooleanVariable}s to bind
	 */
	protected void bindBoxToProgressiveBooleans(ChoiceBox<String> choiceBox, String[] values, Key... booleanKeys) {
		if (values.length != booleanKeys.length + 1) {
			throw new IllegalArgumentException("There must be one extra value compared to variables,"
					+ " to represent the state where all variables are false.");
		}
		IndexStringConverter converter = new IndexStringConverter(values);
		choiceBox.setItems(FXCollections.observableArrayList(values));
		LongProperty tempProperty = new SimpleLongProperty();
		createMultiBooleanBinding(gameState, tempProperty, booleanKeys);
		choiceBox.setValue(converter.toString(tempProperty.get()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), tempProperty, converter);
	}

	private static MultiBooleanBinding createMultiBooleanBinding(GameState state, LongProperty numberProperty,
			Key... booleanKeys) {
		BooleanProperty[] booleanProperties = new BooleanProperty[booleanKeys.length];
		for (int i = 0; i < booleanProperties.length; i++) {
			booleanProperties[i] = state.getBooleanVariable(booleanKeys[i]).boolValueProperty();
		}
		return MultiBooleanBinding.bind(numberProperty, booleanProperties);
	}
}
