package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import com.jbion.candyboxcheater.controllers.widgets.IntegerFieldController;
import com.jbion.candyboxcheater.game.Key;

public class InventoryController extends BaseController {
	@FXML
	private CheckBox gridItemPossessedMainMap;
	@FXML
	private CheckBox gridItemPossessedThirdHouseKey;
	@FXML
	private CheckBox gridItemPossessedFortressKey;
	@FXML
	private CheckBox gridItemPossessedTimeRing;
	@FXML
	private CheckBox gridItemPossessedPogoStick;
	@FXML
	private CheckBox gridItemPossessedFeather;
	@FXML
	private CheckBox gridItemPossessedHeartPlug;
	@FXML
	private CheckBox gridItemPossessedHeartPendant;
	@FXML
	private CheckBox gridItemPossessedPitchfork;
	@FXML
	private CheckBox gridItemPossessedSponge;
	@FXML
	private CheckBox gridItemPossessedShellPowder;
	@FXML
	private CheckBox gridItemPossessedRedSharkFin;
	@FXML
	private CheckBox gridItemPossessedGreenSharkFin;
	@FXML
	private CheckBox gridItemPossessedPurpleSharkFin;
	@FXML
	private CheckBox gridItemPossessedBeginnersGrimoire;
	@FXML
	private CheckBox gridItemPossessedAdvancedGrimoire;
	@FXML
	private CheckBox gridItemPossessedBlackMagicGrimoire;
	@FXML
	private CheckBox gridItemPossessedXinopherydonClaw;
	@FXML
	private CheckBox gridItemPossessedUnicornHorn;
	@FXML
	private CheckBox gridItemPossessedP;
	@FXML
	private CheckBox gridItemPossessedL;
	@FXML
	private CheckBox gridItemPossessedA;
	@FXML
	private CheckBox gridItemPossessedY;
	@FXML
	private CheckBox gridItemPossessedTalkingCandy;
	
	@FXML
	private IntegerFieldController giftPowerController;
	@FXML
	private IntegerFieldController giftHealthController;
	@FXML
	private ChoiceBox<String> gameGiftMagic;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bind(gridItemPossessedMainMap, Key.gridItemPossessedMainMap);
		bind(gridItemPossessedThirdHouseKey, Key.gridItemPossessedThirdHouseKey);
		bind(gridItemPossessedFortressKey, Key.gridItemPossessedFortressKey);
		bind(gridItemPossessedTimeRing, Key.gridItemPossessedTimeRing);
		bind(gridItemPossessedPogoStick, Key.gridItemPossessedPogoStick);
		bind(gridItemPossessedFeather, Key.gridItemPossessedFeather);
		bind(gridItemPossessedHeartPlug, Key.gridItemPossessedHeartPlug);
		bind(gridItemPossessedHeartPendant, Key.gridItemPossessedHeartPendant);
		bind(gridItemPossessedPitchfork, Key.gridItemPossessedPitchfork);
		bind(gridItemPossessedSponge, Key.gridItemPossessedSponge);
		bind(gridItemPossessedShellPowder, Key.gridItemPossessedShellPowder);
		bind(gridItemPossessedRedSharkFin, Key.gridItemPossessedRedSharkFin);
		bind(gridItemPossessedGreenSharkFin, Key.gridItemPossessedGreenSharkFin);
		bind(gridItemPossessedPurpleSharkFin, Key.gridItemPossessedPurpleSharkFin);
		bind(gridItemPossessedBeginnersGrimoire, Key.gridItemPossessedBeginnersGrimoire);
		bind(gridItemPossessedAdvancedGrimoire, Key.gridItemPossessedAdvancedGrimoire);
		bind(gridItemPossessedBlackMagicGrimoire, Key.gridItemPossessedBlackMagicGrimoire);
		bind(gridItemPossessedXinopherydonClaw, Key.gridItemPossessedXinopherydonClaw);
		bind(gridItemPossessedUnicornHorn, Key.gridItemPossessedUnicornHorn);
		bind(gridItemPossessedP, Key.gridItemPossessedP);
		bind(gridItemPossessedL, Key.gridItemPossessedL);
		bind(gridItemPossessedA, Key.gridItemPossessedA);
		bind(gridItemPossessedY, Key.gridItemPossessedY);
		bind(gridItemPossessedTalkingCandy, Key.gridItemPossessedTalkingCandy);
		
		bind(giftPowerController.valueProperty(), Key.gameGiftPower);
		bind(giftHealthController.valueProperty(), Key.gameGiftHealth);
		String[] giftMagicValues = {"0%", "15%", "30%", "45%", "60%", "75%", "90%"};
		bindBoxToNumbers(gameGiftMagic, Key.gameGiftMagic, giftMagicValues);
	}
}
