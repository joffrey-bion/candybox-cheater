package com.jbion.candyboxcheater.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;
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

import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.view.bindings.MultiBooleanBinding;
import com.jbion.candyboxcheater.view.converters.CarpetStepConverter;
import com.jbion.candyboxcheater.view.converters.CupboardStepConverter;
import com.jbion.candyboxcheater.view.converters.ForgeWeaponBoughtConverter;
import com.jbion.candyboxcheater.view.converters.LanguageConverter;
import com.jbion.candyboxcheater.view.converters.StatusBarCornerStepConverter;
import com.jbion.candyboxcheater.view.converters.StatusBarLevelConverter;
import com.jbion.candyboxcheater.view.converters.StringMapping;

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

	// shop
	@FXML
	private CheckBox secondHouseLollipop1Bought;
	@FXML
	private CheckBox secondHouseLollipop2Bought;
	@FXML
	private CheckBox secondHouseLollipop3Bought;
	@FXML
	private CheckBox secondHouseChocolateBarBought;
	@FXML
	private CheckBox secondHouseTimeRingBought;
	@FXML
	private CheckBox secondHouseMerchantHatBought;

	// forge
	@FXML
	private CheckBox forgeFoundLollipop;
	@FXML
	private ChoiceBox<String> forgeWeaponBought;

	// 4th house
	@FXML
	private CheckBox fourthHouseFoundLollipopOnCupboard;
	@FXML
	private ChoiceBox<String> fourthHouseCupboardStep;
	@FXML
	private ChoiceBox<String> fourthHouseCarpetStep;

	// 5th house
	@FXML
	private CheckBox cellarDone;

	/*
	 * MISCELLANEOUS TAB
	 */

	@FXML
	private ChoiceBox<String> gameLanguage;
	@FXML
	private ChoiceBox<String> gameGameMode;
	@FXML
	private ChoiceBox<String> statusBarLevel;
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

		bind(secondHouseLollipop1Bought, Key.secondHouseLollipop1Bought);
		bind(secondHouseLollipop2Bought, Key.secondHouseLollipop2Bought);
		bind(secondHouseLollipop3Bought, Key.secondHouseLollipop3Bought);
		bind(secondHouseChocolateBarBought, Key.secondHouseChocolateBarBought);
		bind(secondHouseTimeRingBought, Key.secondHouseTimeRingBought);
		bind(secondHouseMerchantHatBought, Key.secondHouseMerchantHatBought);

		bind(forgeFoundLollipop, Key.forgeFoundLollipop);
		bind(fourthHouseFoundLollipopOnCupboard, Key.fourthHouseFoundLollipopOnCupboard);
		bind(cellarDone, Key.cellarDone);
		bind(gameGameMode, Key.gameGameMode, GameState.GAME_MODES);
		bind(gameDebug, Key.gameDebug);
		bind(gameInvertedColors, Key.gameInvertedColors);

		bindBoxToNumbers(fourthHouseCupboardStep, Key.fourthHouseCupboardStep, new CupboardStepConverter());
		bindBoxToNumbers(fourthHouseCarpetStep, Key.fourthHouseCarpetStep, new CarpetStepConverter());
		bindBoxToNumbers(statusBarCornerStep, Key.statusBarCornerStep, new StatusBarCornerStepConverter());
		bind(gameLanguage, Key.gameLanguage, new LanguageConverter());

		Key[] statusBarLevelKeys = { Key.statusBarUnlocked, Key.statusBarUnlockedCfg, Key.statusBarUnlockedSave,
				Key.statusBarUnlockedHealthBar, Key.statusBarUnlockedMap };
		bindBoxToMultipleBooleans(statusBarLevel, new StatusBarLevelConverter(), statusBarLevelKeys);

		Key[] forgeWeaponBoughtKeys = { Key.forgeBoughtWoodenSword, Key.forgeBoughtIronAxe,
				Key.forgeBoughtPolishedSilverSword, Key.forgeBoughtLightweightBodyArmour, Key.forgeBoughtScythe };
		bindBoxToMultipleBooleans(forgeWeaponBought, new ForgeWeaponBoughtConverter(), forgeWeaponBoughtKeys);

		rawText.setText(gameState.toString());
		gameState.getStringBinding().addListener((observable, oldValue, newValue) -> rawText.setText(newValue));
	}

	private void bind(Label label, Key key) {
		label.textProperty().bind(gameState.getVariable(key).stringValueProperty());
	}

	private void bind(CheckBox checkBox, Key booleanVariableKey) {
		checkBox.selectedProperty().bindBidirectional(
				gameState.getBooleanVariable(booleanVariableKey).boolValueProperty());
	}

	private void bind(ChoiceBox<String> choiceBox, Key key, String... items) {
		choiceBox.setItems(FXCollections.observableArrayList(items));
		choiceBox.valueProperty().bindBidirectional(gameState.getVariable(key).stringValueProperty());
	}

	private void bind(ChoiceBox<String> choiceBox, Key stringVariableKey, StringMapping<String> converter) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		StringProperty property = gameState.getVariable(stringVariableKey).stringValueProperty();
		choiceBox.setValue(converter.toString(property.get()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), property, converter);
	}

	private void bindBoxToNumbers(ChoiceBox<String> choiceBox, Key numberVariableKey, StringMapping<Number> converter) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		LongProperty property = gameState.getNumberVariable(numberVariableKey).longValueProperty();
		choiceBox.setValue(converter.toString(property.get()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), property, converter);
	}

	private void bindBoxToMultipleBooleans(ChoiceBox<String> choiceBox, StringMapping<Number> converter,
			Key... booleanKeys) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		LongProperty tempProperty = new SimpleLongProperty();
		MultiBooleanBinding.createMultiBooleanBinding(gameState, tempProperty, booleanKeys);
		choiceBox.setValue(converter.toString(tempProperty.get()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), tempProperty, converter);
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
