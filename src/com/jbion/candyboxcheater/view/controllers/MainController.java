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
import com.jbion.candyboxcheater.game.variables.BooleanVariable;
import com.jbion.candyboxcheater.game.variables.NumberVariable;
import com.jbion.candyboxcheater.game.variables.Variable;
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
	 * Equipement
	 */

	@FXML
	private CheckBox eqItemWeaponWoodenSword;
	@FXML
	private CheckBox eqItemWeaponIronAxe;
	@FXML
	private CheckBox eqItemWeaponPolishedSilverSword;
	@FXML
	private CheckBox eqItemWeaponTrollBludgeon;
	@FXML
	private CheckBox eqItemWeaponMonkeyWizardStaff;
	@FXML
	private CheckBox eqItemWeaponEnchantedMonkeyWizardStaff;
	@FXML
	private CheckBox eqItemWeaponTribalSpear;
	@FXML
	private CheckBox eqItemWeaponSummoningTribalSpear;
	@FXML
	private CheckBox eqItemWeaponGiantSpoon;
	@FXML
	private CheckBox eqItemWeaponScythe;
	@FXML
	private CheckBox eqItemWeaponGiantSpoonOfDoom;
	@FXML
	private CheckBox eqItemHatOctopusKingCrown;
	@FXML
	private CheckBox eqItemHatOctopusKingCrownWithJaspers;
	@FXML
	private CheckBox eqItemHatOctopusKingCrownWithObsidian;
	@FXML
	private CheckBox eqItemHatMerchantHat;
	@FXML
	private CheckBox eqItemHatSorceressHat;
	@FXML
	private CheckBox eqItemBodyArmoursLightweightBodyArmour;
	@FXML
	private CheckBox eqItemBodyArmoursKnightBodyArmour;
	@FXML
	private CheckBox eqItemBodyArmoursEnchantedKnightBodyArmour;
	@FXML
	private CheckBox eqItemGlovesLeatherGloves;
	@FXML
	private CheckBox eqItemGlovesRedEnchantedGloves;
	@FXML
	private CheckBox eqItemGlovesPinkEnchantedGloves;
	@FXML
	private CheckBox eqItemBootsLeatherBoots;
	@FXML
	private CheckBox eqItemBootsRocketBoots;
	@FXML
	private CheckBox eqItemBootsBootsOfIntrospection;
	
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

		Key[] statusBarLevelKeys = { Key.statusBarUnlocked, Key.statusBarUnlockedCfg, Key.statusBarUnlockedSave,
				Key.statusBarUnlockedHealthBar, Key.statusBarUnlockedMap };
		bindBoxToMultipleBooleans(statusBarLevel, new StatusBarLevelConverter(), statusBarLevelKeys);
		bindBoxToNumbers(statusBarCornerStep, Key.statusBarCornerStep, new StatusBarCornerStepConverter());
		bind(gameLanguage, Key.gameLanguage, new LanguageConverter());
		bind(gameGameMode, Key.gameGameMode, GameState.GAME_MODES);
		bind(gameDebug, Key.gameDebug);
		bind(gameInvertedColors, Key.gameInvertedColors);
		
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

		/*
		 * Village
		 */
		bind(secondHouseLollipop1Bought, Key.secondHouseLollipop1Bought);
		bind(secondHouseLollipop2Bought, Key.secondHouseLollipop2Bought);
		bind(secondHouseLollipop3Bought, Key.secondHouseLollipop3Bought);
		bind(secondHouseChocolateBarBought, Key.secondHouseChocolateBarBought);
		bind(secondHouseTimeRingBought, Key.secondHouseTimeRingBought);
		bind(secondHouseMerchantHatBought, Key.secondHouseMerchantHatBought);
		bind(forgeFoundLollipop, Key.forgeFoundLollipop);
		Key[] forgeWeaponBoughtKeys = { Key.forgeBoughtWoodenSword, Key.forgeBoughtIronAxe,
				Key.forgeBoughtPolishedSilverSword, Key.forgeBoughtLightweightBodyArmour, Key.forgeBoughtScythe };
		bindBoxToMultipleBooleans(forgeWeaponBought, new ForgeWeaponBoughtConverter(), forgeWeaponBoughtKeys);
		bind(fourthHouseFoundLollipopOnCupboard, Key.fourthHouseFoundLollipopOnCupboard);
		bindBoxToNumbers(fourthHouseCupboardStep, Key.fourthHouseCupboardStep, new CupboardStepConverter());
		bindBoxToNumbers(fourthHouseCarpetStep, Key.fourthHouseCarpetStep, new CarpetStepConverter());
		bind(cellarDone, Key.cellarDone);
		
		/*
		 * Equipment
		 */
		bind(eqItemWeaponWoodenSword, Key.eqItemWeaponWoodenSword);
		bind(eqItemWeaponIronAxe, Key.eqItemWeaponIronAxe);
		bind(eqItemWeaponPolishedSilverSword, Key.eqItemWeaponPolishedSilverSword);
		bind(eqItemWeaponTrollBludgeon, Key.eqItemWeaponTrollBludgeon);
		bind(eqItemWeaponMonkeyWizardStaff, Key.eqItemWeaponMonkeyWizardStaff);
		bind(eqItemWeaponEnchantedMonkeyWizardStaff, Key.eqItemWeaponEnchantedMonkeyWizardStaff);
		bind(eqItemWeaponTribalSpear, Key.eqItemWeaponTribalSpear);
		bind(eqItemWeaponSummoningTribalSpear, Key.eqItemWeaponSummoningTribalSpear);
		bind(eqItemWeaponGiantSpoon, Key.eqItemWeaponGiantSpoon);
		bind(eqItemWeaponScythe, Key.eqItemWeaponScythe);
		bind(eqItemWeaponGiantSpoonOfDoom, Key.eqItemWeaponGiantSpoonOfDoom);
		bind(eqItemHatOctopusKingCrown, Key.eqItemHatOctopusKingCrown);
		bind(eqItemHatOctopusKingCrownWithJaspers, Key.eqItemHatOctopusKingCrownWithJaspers);
		bind(eqItemHatOctopusKingCrownWithObsidian, Key.eqItemHatOctopusKingCrownWithObsidian);
		bind(eqItemHatMerchantHat, Key.eqItemHatMerchantHat);
		bind(eqItemHatSorceressHat, Key.eqItemHatSorceressHat);
		bind(eqItemBodyArmoursLightweightBodyArmour, Key.eqItemBodyArmoursLightweightBodyArmour);
		bind(eqItemBodyArmoursKnightBodyArmour, Key.eqItemBodyArmoursKnightBodyArmour);
		bind(eqItemBodyArmoursEnchantedKnightBodyArmour, Key.eqItemBodyArmoursEnchantedKnightBodyArmour);
		bind(eqItemGlovesLeatherGloves, Key.eqItemGlovesLeatherGloves);
		bind(eqItemGlovesRedEnchantedGloves, Key.eqItemGlovesRedEnchantedGloves);
		bind(eqItemGlovesPinkEnchantedGloves, Key.eqItemGlovesPinkEnchantedGloves);
		bind(eqItemBootsLeatherBoots, Key.eqItemBootsLeatherBoots);
		bind(eqItemBootsRocketBoots, Key.eqItemBootsRocketBoots);
		bind(eqItemBootsBootsOfIntrospection, Key.eqItemBootsBootsOfIntrospection);
		
		// save text binding
		rawText.setText(gameState.toString());
		gameState.getStringBinding().addListener((observable, oldValue, newValue) -> rawText.setText(newValue));
	}

	private void bind(Label label, Key key) {
		Variable var = gameState.getVariable(key);
		label.textProperty().bind(var.stringValueProperty());
		label.disableProperty().bind(var.disabledProperty());
	}

	private void bind(CheckBox checkBox, Key booleanVariableKey) {
		BooleanVariable boolVar = gameState.getBooleanVariable(booleanVariableKey);
		checkBox.selectedProperty().bindBidirectional(boolVar.boolValueProperty());
		checkBox.disableProperty().bind(boolVar.disabledProperty());
	}

	private void bind(ChoiceBox<String> choiceBox, Key key, String... items) {
		choiceBox.setItems(FXCollections.observableArrayList(items));
		Variable var = gameState.getVariable(key);
		choiceBox.setValue(var.getStringValue());
		choiceBox.valueProperty().bindBidirectional(var.stringValueProperty());
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	private void bind(ChoiceBox<String> choiceBox, Key stringVariableKey, StringMapping<String> converter) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		Variable var = gameState.getVariable(stringVariableKey);
		choiceBox.setValue(converter.toString(var.getStringValue()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), var.stringValueProperty(), converter);
		choiceBox.disableProperty().bind(var.disabledProperty());
	}

	private void bindBoxToNumbers(ChoiceBox<String> choiceBox, Key numberVariableKey, StringMapping<Number> converter) {
		choiceBox.setItems(FXCollections.observableArrayList(converter.getNames()));
		NumberVariable var = gameState.getNumberVariable(numberVariableKey);
		choiceBox.setValue(converter.toString(var.getLongValue()));
		Bindings.bindBidirectional(choiceBox.valueProperty(), var.longValueProperty(), converter);
		choiceBox.disableProperty().bind(var.disabledProperty());
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
