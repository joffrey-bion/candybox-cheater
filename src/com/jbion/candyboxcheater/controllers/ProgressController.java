package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.game.Key;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class ProgressController extends BaseController {

	@FXML
	private ChoiceBox<String> mainMapProgress;
	@FXML
	private CheckBox mainMapDoneBridge;
	@FXML
	private CheckBox mainMapDonePier;
	@FXML
	private ChoiceBox<String> pStoneProgress;
	@FXML
	private ChoiceBox<String> lStoneProgress;
	@FXML
	private ChoiceBox<String> aStoneProgress;
	@FXML
	private ChoiceBox<String> yStoneProgress;
	@FXML
	private ChoiceBox<String> talkingCandyProgress;

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

	@FXML
	private CheckBox lonelyHouseOpenBoxDone;
	@FXML
	private CheckBox lonelyHouseShakeBoxDone;
	@FXML
	private CheckBox lonelyHouseBreakLockDone;
	@FXML
	private CheckBox lonelyHouseKickBoxDone;
	@FXML
	private CheckBox lonelyHouseAskTheBoxToOpenItselfDone;
	@FXML
	private CheckBox lonelyHouseLureTheBoxWithACandyDone;
	@FXML
	private CheckBox lonelyHouseTakeTheBoxDone;

	@FXML
	private ChoiceBox<String> squirrelProgress;

	@FXML
	private CheckBox TheCavePattern_ChocolateBarNowGotTheBar;
	@FXML
	private ChoiceBox<String> treasureProgress;

	@FXML
	private CheckBox sorceressHutTookLollipop;
	@FXML
	private CheckBox sorceressHutBoughtGrimoire;
	@FXML
	private CheckBox sorceressHutBoughtGrimoire2;
	@FXML
	private CheckBox sorceressHutBoughtCauldron;
	@FXML
	private CheckBox sorceressHutBoughtHat;

	@FXML
	private CheckBox theHoleFirstChestFound;
	@FXML
	private CheckBox theHoleSecondChestFound;
	@FXML
	private CheckBox theHoleThirdChestFound;
	@FXML
	private CheckBox theHoleFourthChestFound;

	@FXML
	private CheckBox fortressRoom3ChestFound;
	@FXML
	private CheckBox fortressRoom1ChestFound;

	@FXML
	private CheckBox castleBigRoomHovenHappy;
	@FXML
	private ChoiceBox<String> castleDarkRoomProgress;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Key[] mainMapProgressKeys = { Key.cellarDone, Key.mainMapDoneDesert, Key.mainMapDoneCaveEntrance,
				Key.mainMapDoneForest, Key.mainMapDoneCastleEntrance, Key.dragonDone };
		String[] mainMapProgressValues = { "Nothing done", "Main Map obtained", "Desert done", "Cave done",
				"Forest done", "Castle entrance done", "Dragone done" };
		bindBoxToProgressiveBooleans(mainMapProgress, mainMapProgressValues, mainMapProgressKeys);
		bind(mainMapDoneBridge, Key.mainMapDoneBridge);
		bind(mainMapDonePier, Key.mainMapDonePier);
		Key[] pStoneProgressKeys = { Key.dragonUnlockedCyclops, Key.lighthousePuzzleDone, Key.castleTowerPStoneDone };
		String[] pStoneProgressValues = { "Nothing done yet", "Talked to dragon about candies",
				"Solved lighthouse puzzle", "Put P Stone in tower" };
		bindBoxToProgressiveBooleans(pStoneProgress, pStoneProgressValues, pStoneProgressKeys);
		Key[] lStoneProgressKeys = { Key.gridItemPossessedL, Key.castleTowerLStoneDone };
		String[] lStoneProgressValues = { "Nothing done yet", "Crossed eggs room", "Put L Stone in tower" };
		bindBoxToProgressiveBooleans(lStoneProgress, lStoneProgressValues, lStoneProgressKeys);
		Key[] aStoneProgressKeys = { Key.gridItemPossessedA, Key.castleTowerAStoneDone };
		String[] aStoneProgressValues = { "Nothing done yet", "Devil beaten", "Put A Stone in tower" };
		bindBoxToProgressiveBooleans(aStoneProgress, aStoneProgressValues, aStoneProgressKeys);
		Key[] yStoneProgressKeys = { Key.gridItemPossessedY, Key.castleTowerYStoneDone };
		String[] yStoneProgressValues = { "Nothing done yet", "Developer beaten", "Put Y Stone in tower" };
		bindBoxToProgressiveBooleans(yStoneProgress, yStoneProgressValues, yStoneProgressKeys);
		Key[] talkingCandyProgressKeys = { Key.castleKilledNougatMonster, Key.castleTowerFirstVisitDone,
				Key.castleTowerTookTalkingCandy, Key.candyBoxBoxOpened };
		String[] talkingCandyProgressValues = { "Nothing done yet", "Nougat Monster killed", "Tower visited",
				"Talking candy taken", "CandyBox opened!" };
		bindBoxToProgressiveBooleans(talkingCandyProgress, talkingCandyProgressValues, talkingCandyProgressKeys);

		bind(secondHouseLollipop1Bought, Key.secondHouseLollipop1Bought);
		bind(secondHouseLollipop2Bought, Key.secondHouseLollipop2Bought);
		bind(secondHouseLollipop3Bought, Key.secondHouseLollipop3Bought);
		bind(secondHouseChocolateBarBought, Key.secondHouseChocolateBarBought);
		bind(secondHouseTimeRingBought, Key.secondHouseTimeRingBought);
		bind(secondHouseMerchantHatBought, Key.secondHouseMerchantHatBought);

		bind(forgeFoundLollipop, Key.forgeFoundLollipop);
		Key[] forgeWeaponBoughtKeys = { Key.forgeBoughtWoodenSword, Key.forgeBoughtIronAxe,
				Key.forgeBoughtPolishedSilverSword, Key.forgeBoughtLightweightBodyArmour, Key.forgeBoughtScythe };
		String[] forgeWeaponBoughtValues = { "Nothing bought", "Wooden Sword bought", "Iron Axe bought",
				"Polished Silver Sword bought", "Lightweight Body Armor bought", "Scythe bought" };
		bindBoxToProgressiveBooleans(forgeWeaponBought, forgeWeaponBoughtValues, forgeWeaponBoughtKeys);

		bind(fourthHouseFoundLollipopOnCupboard, Key.fourthHouseFoundLollipopOnCupboard);
		String[] cupboardStepsValues = { "Nothing done", "Cupboard door opened", "Lollipop picked up" };
		bindBoxToNumbers(fourthHouseCupboardStep, Key.fourthHouseCupboardStep, cupboardStepsValues);
		String[] carpetStepsValues = { "Nothing done", "Lollipop unveiled", "Lollipop picked up" };
		bindBoxToNumbers(fourthHouseCarpetStep, Key.fourthHouseCarpetStep, carpetStepsValues);

		bind(cellarDone, Key.cellarDone);

		bind(lonelyHouseOpenBoxDone, Key.lonelyHouseOpenBoxDone);
		bind(lonelyHouseShakeBoxDone, Key.lonelyHouseShakeBoxDone);
		bind(lonelyHouseBreakLockDone, Key.lonelyHouseBreakLockDone);
		bind(lonelyHouseKickBoxDone, Key.lonelyHouseKickBoxDone);
		bind(lonelyHouseAskTheBoxToOpenItselfDone, Key.lonelyHouseAskTheBoxToOpenItselfDone);
		bind(lonelyHouseLureTheBoxWithACandyDone, Key.lonelyHouseLureTheBoxWithACandyDone);
		bind(lonelyHouseTakeTheBoxDone, Key.lonelyHouseTakeTheBoxDone);

		String[] squirrelProgressValues = { "Nothing done", "Talked to it once", "Answered 1st question (yes)", "Answered 2nd question (C)",
				"Answered 3rd question (current candies)", "Answered 4th question (10)", "Answered 5th question (wet)", "Started playing game", 
				"Won game (put crosses out of the grid)", "Finished" };
		bindBoxToNumbers(squirrelProgress, Key.aTreeStep, squirrelProgressValues);
		
		bind(TheCavePattern_ChocolateBarNowGotTheBar, Key.TheCavePattern_ChocolateBarNowGotTheBar);
		Key[] treasureProgressKeys = { Key.TheCavePattern_TreasureMapSawMap, Key.TheCavePattern_TreasureMapFoundTreasure };
		String[] treasureProgressValues = { "Nothing done", "Treasure map discovered", "Treasure found" };
		bindBoxToProgressiveBooleans(treasureProgress, treasureProgressValues, treasureProgressKeys);
		
		bind(sorceressHutTookLollipop, Key.sorceressHutTookLollipop);
		bind(sorceressHutBoughtGrimoire, Key.sorceressHutBoughtGrimoire);
		bind(sorceressHutBoughtGrimoire2, Key.sorceressHutBoughtGrimoire2);
		bind(sorceressHutBoughtCauldron, Key.sorceressHutBoughtCauldron);
		bind(sorceressHutBoughtHat, Key.sorceressHutBoughtHat);
		
		bind(theHoleFirstChestFound, Key.theHoleFirstChestFound);
		bind(theHoleSecondChestFound, Key.theHoleSecondChestFound);
		bind(theHoleThirdChestFound, Key.theHoleThirdChestFound);
		bind(theHoleFourthChestFound, Key.theHoleFourthChestFound);
		
		bind(fortressRoom3ChestFound, Key.fortressRoom3ChestFound);
		bind(fortressRoom1ChestFound, Key.fortressRoom1ChestFound);
		
		bind(castleBigRoomHovenHappy, Key.castleBigRoomHovenHappy);
		Key[] darkRoomProgressKeys = { Key.castleRoom2LitFire, Key.castleRoom2TookObject };
		String[] darkRoomProgressValues = { "Nothing done", "Fire lit", "Pitchfork found" };
		bindBoxToProgressiveBooleans(castleDarkRoomProgress, darkRoomProgressValues, darkRoomProgressKeys);
	}
}
