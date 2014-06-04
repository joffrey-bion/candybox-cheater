package com.jbion.candyboxcheater.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.util.StringConverter;

import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.game.variables.NumberVariable;
import com.jbion.candyboxcheater.view.converters.CarpetStepConverter;
import com.jbion.candyboxcheater.view.converters.CupboardStepConverter;
import com.jbion.candyboxcheater.view.converters.LanguageConverter;
import com.jbion.candyboxcheater.view.converters.StatusBarCornerStepConverter;

public class MainController implements Initializable {

	/*
	 * STOCKS TAB
	 */

	@FXML
	private Label gameCandiesCurrent;
	@FXML
	private Label gameCandiesAccumulated;
	@FXML
	private Label gameCandiesMax;

	@FXML
	private Label gameCandiesEatenCurrent;
	@FXML
	private Label gameCandiesEatenAccumulated;
	@FXML
	private Label gameCandiesEatenMax;

	@FXML
	private Label gameCandiesThrownCurrent;
	@FXML
	private Label gameCandiesThrownAccumulated;
	@FXML
	private Label gameCandiesThrownMax;

	@FXML
	private Label gameLollipopsCurrent;
	@FXML
	private Label gameLollipopsAccumulated;
	@FXML
	private Label gameLollipopsMax;

	@FXML
	private Label gameChocolateBarsCurrent;
	@FXML
	private Label gameChocolateBarsAccumulated;
	@FXML
	private Label gameChocolateBarsMax;

	@FXML
	private Label gamePainsAuChocolatCurrent;
	@FXML
	private Label gamePainsAuChocolatAccumulated;
	@FXML
	private Label gamePainsAuChocolatMax;

	@FXML
	private TextField candiesAddField;
	@FXML
	private TextField eatenCandiesAddField;
	@FXML
	private TextField thrownCandiesAddField;
	@FXML
	private TextField lollipopsAddField;
	@FXML
	private TextField chocolateBarsAddField;
	@FXML
	private TextField painsAuChocolatAddField;

	/*
	 * VILLAGE TAB
	 */

	@FXML
	private CheckBox forgeFoundLollipop;
	@FXML
	private CheckBox cellarDone;
	@FXML
	private CheckBox fourthHouseFoundLollipopOnCupboard;
	@FXML
	private ChoiceBox<String> fourthHouseCupboardStep;
	@FXML
	private ChoiceBox<String> fourthHouseCarpetStep;

	/*
	 * MISCELLANEOUS TAB
	 */

	@FXML
	private ChoiceBox<String> gameLanguage;
	@FXML
	private ChoiceBox<String> gameGameMode;
	@FXML
	private ChoiceBox<String> statusBarUnlocked;
	@FXML
	private ChoiceBox<String> statusBarCornerStep;
	@FXML
	private CheckBox gameInvertedColors;
	@FXML
	private CheckBox gameDebug;

	/*
	 * BOTTOM LAYOUT
	 */

	@FXML
	private TextArea rawText;

	@FXML
	private Button reparseBtn;

	@FXML
	private Button clipboardBtn;
	@FXML
	private TableView<?> varTable;

	/*
	 * CONTROLLER STATE
	 */

	private GameState gameState;

	// private Map<Key, ChoiceBox<String>> numberVarsChoiceBoxes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gameState = new GameState();
		bindGameVariables();
	}

	private void bindGameVariables() {
		bind(gameCandiesCurrent, Key.gameCandiesCurrent);
		bind(gameCandiesAccumulated, Key.gameCandiesAccumulated);
		bind(gameCandiesMax, Key.gameCandiesMax);
		bind(gameCandiesEatenCurrent, Key.gameCandiesEatenCurrent);
		bind(gameCandiesEatenAccumulated, Key.gameCandiesEatenAccumulated);
		bind(gameCandiesEatenMax, Key.gameCandiesEatenMax);
		bind(gameCandiesThrownCurrent, Key.gameCandiesThrownCurrent);
		bind(gameCandiesThrownAccumulated, Key.gameCandiesThrownAccumulated);
		bind(gameCandiesThrownMax, Key.gameCandiesThrownMax);
		bind(gameLollipopsCurrent, Key.gameLollipopsCurrent);
		bind(gameLollipopsAccumulated, Key.gameLollipopsAccumulated);
		bind(gameLollipopsMax, Key.gameLollipopsMax);
		bind(gameChocolateBarsCurrent, Key.gameChocolateBarsCurrent);
		bind(gameChocolateBarsAccumulated, Key.gameChocolateBarsAccumulated);
		bind(gameChocolateBarsMax, Key.gameChocolateBarsMax);
		bind(gamePainsAuChocolatCurrent, Key.gamePainsAuChocolatCurrent);
		bind(gamePainsAuChocolatAccumulated, Key.gamePainsAuChocolatAccumulated);
		bind(gamePainsAuChocolatMax, Key.gamePainsAuChocolatMax);

		bind(forgeFoundLollipop, Key.forgeFoundLollipop);
		bind(fourthHouseFoundLollipopOnCupboard, Key.fourthHouseFoundLollipopOnCupboard);		
		bind(cellarDone, Key.cellarDone);
		bind(gameGameMode, Key.gameGameMode);
		bind(gameDebug, Key.gameDebug);
		bind(gameInvertedColors, Key.gameInvertedColors);

		CupboardStepConverter cupboardStepConverter = new CupboardStepConverter();
		fourthHouseCupboardStep.setItems(FXCollections.observableArrayList(cupboardStepConverter.getNames()));
		bindBoxToNumbers(fourthHouseCupboardStep, Key.fourthHouseCupboardStep, cupboardStepConverter);

		CarpetStepConverter carpetStepConverter = new CarpetStepConverter();
		fourthHouseCarpetStep.setItems(FXCollections.observableArrayList(carpetStepConverter.getNames()));
		bindBoxToNumbers(fourthHouseCarpetStep, Key.fourthHouseCarpetStep, carpetStepConverter);

		LanguageConverter languageConverter = new LanguageConverter();
		gameLanguage.setItems(FXCollections.observableArrayList(languageConverter.getNames()));
		bindBoxToStrings(gameLanguage, Key.gameLanguage, languageConverter);

		StatusBarCornerStepConverter statusBarConverter = new StatusBarCornerStepConverter();
		statusBarCornerStep.setItems(FXCollections.observableArrayList(statusBarConverter.getNames()));
		bindBoxToNumbers(statusBarCornerStep, Key.statusBarCornerStep, statusBarConverter);

		gameGameMode.setItems(FXCollections.observableArrayList(GameState.GAME_MODES));
		
		rawText.setText(gameState.toString());
		gameState.getStringBinding().addListener((observable, oldValue, newValue) -> rawText.setText(newValue));
	}

	private void bind(Label label, Key key) {
		label.textProperty().bind(gameState.getVariable(key).stringValueProperty());
	}

	private void bind(CheckBox checkBox, Key key) {
		checkBox.selectedProperty().bindBidirectional(gameState.getBooleanVariable(key).boolValueProperty());
	}

	private void bind(ChoiceBox<String> choiceBox, Key key) {
		choiceBox.valueProperty().bindBidirectional(gameState.getVariable(key).stringValueProperty());
	}

	private void bindBoxToStrings(ChoiceBox<String> choiceBox, Key key, StringConverter<String> converter) {
		Bindings.bindBidirectional(choiceBox.valueProperty(), gameState.getVariable(key).stringValueProperty(),
				converter);
	}

	private void bindBoxToNumbers(ChoiceBox<String> choiceBox, Key key, StringConverter<Number> converter) {
		NumberVariable var = gameState.getNumberVariable(key);
		Long value = var.getLongValue();
		String convertValue = converter.toString(value);
		System.out.println("Value:  " + value + " -> " + convertValue + "  " + var.getKey());
		choiceBox.setValue(convertValue);
		Property<String> strProp = choiceBox.valueProperty();
		Property<Number> longProp = gameState.getNumberVariable(key).longValueProperty();
		Bindings.bindBidirectional(strProp, longProp, converter);
		System.out.println();
	}

	@FXML
	private void addCandies(@SuppressWarnings("unused") ActionEvent event) {
		try {
			gameState.incrementCandies(Integer.parseInt(candiesAddField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}

	@FXML
	private void addEatenCandies(@SuppressWarnings("unused") ActionEvent event) {
		try {
			gameState.incrementEatenCandies(Integer.parseInt(eatenCandiesAddField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}

	@FXML
	private void addThrownCandies(@SuppressWarnings("unused") ActionEvent event) {
		try {
			gameState.incrementThrownCandies(Integer.parseInt(thrownCandiesAddField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}

	@FXML
	private void addLollipops(@SuppressWarnings("unused") ActionEvent event) {
		try {
			gameState.incrementLollipops(Integer.parseInt(lollipopsAddField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}

	@FXML
	private void addChocolateBars(@SuppressWarnings("unused") ActionEvent event) {
		try {
			gameState.incrementChocolateBars(Integer.parseInt(chocolateBarsAddField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}

	@FXML
	private void addPainsAuChocolat(@SuppressWarnings("unused") ActionEvent event) {
		try {
			gameState.incrementPainsAuChocolat(Integer.parseInt(painsAuChocolatAddField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}

	@FXML
	private void copyToClipboard(@SuppressWarnings("unused") ActionEvent event) {
		ClipboardContent content = new ClipboardContent();
		content.putString(rawText.getText());
		Clipboard.getSystemClipboard().setContent(content);
	}

	@FXML
	private void parseSaveText(@SuppressWarnings("unused") ActionEvent event) {
		String saveText = rawText.getText();
		gameState.updateTo(saveText);
	}
}
