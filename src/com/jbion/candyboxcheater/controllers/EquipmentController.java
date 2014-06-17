package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.game.Key;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class EquipmentController extends BaseController {
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
	}
}
