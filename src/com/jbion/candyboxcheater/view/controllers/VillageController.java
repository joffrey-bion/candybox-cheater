package com.jbion.candyboxcheater.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.view.converters.CarpetStepConverter;
import com.jbion.candyboxcheater.view.converters.CupboardStepConverter;
import com.jbion.candyboxcheater.view.converters.ForgeWeaponBoughtConverter;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class VillageController extends BaseController {
	
	// Shop
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

	// Forge
	@FXML
	private CheckBox forgeFoundLollipop;
	@FXML
	private ChoiceBox<String> forgeWeaponBought;

	// 4th House
	@FXML
	private CheckBox fourthHouseFoundLollipopOnCupboard;
	@FXML
	private ChoiceBox<String> fourthHouseCupboardStep;
	@FXML
	private ChoiceBox<String> fourthHouseCarpetStep;

	// 5th House
	@FXML
	private CheckBox cellarDone;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
	}
}
