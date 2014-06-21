package com.jbion.candyboxcheater.game;

import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

public enum Key {

	candiesThrownGotChocolateBar,
	candyBoxBoxOpened,
	castleBigRoomHovenHappy,
	castleRoom2LitFire,
	castleRoom2TookObject,
	castleTowerFirstVisitDone,
	castleTowerPStoneDone,
	castleTowerLStoneDone,
	castleTowerAStoneDone,
	castleTowerYStoneDone,
	castleTowerTookTalkingCandy,
	castleKilledNougatMonster,
	cellarDone,
	dragonDone,
	dragonUnlockedCyclops,
	forgeFoundLollipop,
	forgeBoughtWoodenSword,
	forgeBoughtIronAxe,
	forgeBoughtPolishedSilverSword,
	forgeBoughtLightweightBodyArmour,
	forgeBoughtScythe,
	fortressRoom1ChestFound,
	fortressRoom3ChestFound,
	fourthHouseFoundLollipopOnCupboard,
	gameDebug,
	gameInvertedColors,
	lighthousePuzzleDone,
	lollipopFarmPlant1LollipopButtonUnlocked,
	lollipopFarmPlant10LollipopsButtonUnlocked,
	lollipopFarmPlant100LollipopsButtonUnlocked,
	lollipopFarmPlant1000LollipopsButtonUnlocked,
	lollipopFarmIsProductionEachSecond,
	lollipopFarmConstructMillButtonUnlocked,
	lollipopFarmMillConstructed,
	lollipopFarmDigPondButtonUnlocked,
	lollipopFarmPondDug,
	lollipopFarmPondFeedingLolligators,
	lonelyHouseOpenBoxDone,
	lonelyHouseShakeBoxDone,
	lonelyHouseBreakLockDone,
	lonelyHouseKickBoxDone,
	lonelyHouseAskTheBoxToOpenItselfDone,
	lonelyHouseLureTheBoxWithACandyDone,
	lonelyHouseTakeTheBoxDone,
	mainMapDoneDesert,
	mainMapDoneBridge,
	mainMapDoneCaveEntrance,
	mainMapDonePier,
	mainMapDoneForest,
	mainMapDoneCastleEntrance,
	questPlayerSpellHealthPotionHasSpell,
	questPlayerSpellTurtlePotionHasSpell,
	questPlayerSpellAntiGravityPotionHasSpell,
	questPlayerSpellBerserkPotionHasSpell,
	questPlayerSpellCloningPotionHasSpell,
	questPlayerSpellPPotionHasSpell,
	questPlayerSpellXPotionHasSpell,
	secondHouseLollipop1Bought,
	secondHouseLollipop2Bought,
	secondHouseLollipop3Bought,
	secondHouseLeatherBootsBought,
	secondHouseChocolateBarBought,
	secondHouseMerchantHatBought,
	secondHouseTimeRingBought,
	sorceressHutTookLollipop,
	sorceressHutBoughtGrimoire,
	sorceressHutBoughtGrimoire2,
	sorceressHutBoughtCauldron,
	sorceressHutBoughtHat,
	statusBarUnlocked,
	statusBarUnlockedCfg,
	statusBarUnlockedSave,
	statusBarUnlockedMap,
	statusBarUnlockedInventory,
	statusBarUnlockedLollipopFarm,
	statusBarUnlockedCauldron,
	statusBarUnlockedInsideYourBox,
	statusBarUnlockedTheComputer,
	statusBarUnlockedTheArena,
	statusBarUnlockedHealthBar,
	SuperRPGReward1,
	SuperRPGReward2,
	SuperRPGReward3,
	SuperRPGReward4,
	SuperRPGUnlockedHardmode,
	TheCavePattern_ChocolateBarNowGotTheBar,
	TheCavePattern_TreasureMapSawMap,
	TheCavePattern_TreasureMapFoundTreasure,
	theHoleFirstChestFound,
	theHoleSecondChestFound,
	theHoleThirdChestFound,
	theHoleFourthChestFound,
	wishingWellFirstCandyThrown,
	wishingWellFirstLollipopThrown,
	wishingWellWeAreEnchanting,
	wishingWellWeArePainAuChocolating,
	gridItemPossessedMainMap,
	gridItemPossessedTimeRing,
	gridItemPossessedThirdHouseKey,
	gridItemPossessedBeginnersGrimoire,
	gridItemPossessedFeather,
	gridItemPossessedPogoStick,
	gridItemPossessedHeartPlug,
	gridItemPossessedAdvancedGrimoire,
	gridItemPossessedSponge,
	gridItemPossessedShellPowder,
	gridItemPossessedRedSharkFin,
	gridItemPossessedBlackMagicGrimoire,
	gridItemPossessedGreenSharkFin,
	gridItemPossessedPurpleSharkFin,
	gridItemPossessedHeartPendant,
	gridItemPossessedFortressKey,
	gridItemPossessedUnicornHorn,
	gridItemPossessedXinopherydonClaw,
	gridItemPossessedPitchfork,
	gridItemPossessedTalkingCandy,
	gridItemPossessedP,
	gridItemPossessedL,
	gridItemPossessedA,
	gridItemPossessedY,
	eqItemWeaponWoodenSword,
	eqItemWeaponIronAxe,
	eqItemWeaponPolishedSilverSword,
	eqItemWeaponTrollBludgeon,
	eqItemWeaponMonkeyWizardStaff,
	eqItemWeaponEnchantedMonkeyWizardStaff,
	eqItemWeaponTribalSpear,
	eqItemWeaponSummoningTribalSpear,
	eqItemWeaponGiantSpoon,
	eqItemWeaponScythe,
	eqItemWeaponGiantSpoonOfDoom,
	eqItemHatOctopusKingCrown,
	eqItemHatOctopusKingCrownWithJaspers,
	eqItemHatOctopusKingCrownWithObsidian,
	eqItemHatMerchantHat,
	eqItemHatSorceressHat,
	eqItemBodyArmoursLightweightBodyArmour,
	eqItemBodyArmoursKnightBodyArmour,
	eqItemBodyArmoursEnchantedKnightBodyArmour,
	eqItemGlovesLeatherGloves,
	eqItemGlovesRedEnchantedGloves,
	eqItemGlovesPinkEnchantedGloves,
	eqItemBootsLeatherBoots,
	eqItemBootsRocketBoots,
	eqItemBootsBootsOfIntrospection,
	aTreeStep,
	cauldronBookCurrentPage,
	fourthHouseCupboardStep,
	fourthHouseCarpetStep,
	galacticWarsBestScore,
	gameSecondsElapsedSinceLastLollipopsProduction,
	gameCandiesAccumulated,
	gameCandiesCurrent,
	gameCandiesMax,
	gameLollipopsAccumulated,
	gameLollipopsCurrent,
	gameLollipopsMax,
	gameChocolateBarsAccumulated,
	gameChocolateBarsCurrent,
	gameChocolateBarsMax,
	gamePainsAuChocolatAccumulated,
	gamePainsAuChocolatCurrent,
	gamePainsAuChocolatMax,
	gameCandiesEatenAccumulated,
	gameCandiesEatenCurrent,
	gameCandiesEatenMax,
	gameCandiesThrownAccumulated,
	gameCandiesThrownCurrent,
	gameCandiesThrownMax,
	gameCandiesUsedToRequestFeaturesAccumulated,
	gameCandiesUsedToRequestFeaturesCurrent,
	gameCandiesUsedToRequestFeaturesMax,
	gameCandiesInCauldronAccumulated,
	gameCandiesInCauldronCurrent,
	gameCandiesInCauldronMax,
	gameLollipopsInCauldronAccumulated,
	gameLollipopsInCauldronCurrent,
	gameLollipopsInCauldronMax,
	gameGiftPower,
	gameGiftHealth,
	gameGiftMagic,
	lollipopFarmLollipopsPlanted,
	lollipopFarmTimeSinceLastProduction,
	lollipopFarmProduction,
	lollipopFarmPondHowManyLolligators,
	lollipopFarmPondConversionRate,
	lollipopFarmPreviousCandiesProduction,
	lollipopFarmCurrentCandiesProduction,
	mainMapDefaultScroll,
	playerHp,
	questPlayerSpellHealthPotionQuantity,
	questPlayerSpellAntiGravityPotionQuantity,
	questPlayerSpellTurtlePotionQuantity,
	questPlayerSpellBerserkPotionQuantity,
	questPlayerSpellCloningPotionQuantity,
	questPlayerSpellPPotionQuantity,
	questPlayerSpellXPotionQuantity,
	statusBarCornerStep,
	wishingWellPreviousCandyWishPrice,
	wishingWellCurrentCandyWishPrice,
	wishingWellCurrentLollipopWishPrice,
	wishingWellHowManyChocolateBarsThrown,
	wishingWellHowManyPainsAuChocolatThrown,
	gameLanguage,
	gameWeaponSelected,
	gameHatSelected,
	gameBodyArmourSelected,
	gameGlovesSelected,
	gameBootsSelected,
	gameGameMode;

	public static final String[] GAME_MODES = { "normal", "hard" };
	public static final String[] LANGUAGES = { "en", "br", "zh", "cz", "nl", "fr", "de", "hu", "id", "pl", "se" };
	/**
	 * Defines sets of {@link Key}s that must always have the same value.
	 */
	public static final List<Key[]> IDENTITIES = new LinkedList<>();
	/**
	 * Defines {@link Dependency} relations where:
	 * <ul>
	 * <li>If {@code R} becomes {@code false}, {@code D} must be set to {@code false}
	 * because it depends on {@code R}</li>
	 * <li>If {@code D} becomes {@code true}, {@code R} must be set to {@code true}
	 * because it is required for {@code D}</li>
	 * </ul>
	 */
	public static final List<Dependency> STRONG_DEPENDENCIES = new LinkedList<>();

	static {
		addIdentity(forgeBoughtWoodenSword, eqItemWeaponWoodenSword, statusBarUnlockedInventory);
		addIdentity(forgeBoughtIronAxe, eqItemWeaponIronAxe);
		addIdentity(forgeBoughtPolishedSilverSword, eqItemWeaponPolishedSilverSword);
		addIdentity(forgeBoughtLightweightBodyArmour, eqItemBodyArmoursLightweightBodyArmour);
		addIdentity(forgeBoughtScythe, eqItemWeaponScythe);
		addIdentity(cellarDone, gridItemPossessedMainMap);
		addIdentity(secondHouseTimeRingBought, gridItemPossessedTimeRing);
		addIdentity(secondHouseMerchantHatBought, eqItemHatMerchantHat);
		addIdentity(SuperRPGReward4, SuperRPGUnlockedHardmode);
		addIdentity(mainMapDoneDesert, statusBarUnlockedLollipopFarm, lollipopFarmPlant1LollipopButtonUnlocked);
		addIdentity(mainMapDoneBridge, eqItemWeaponTrollBludgeon);
		addIdentity(sorceressHutBoughtGrimoire, gridItemPossessedBeginnersGrimoire);
		addIdentity(sorceressHutBoughtGrimoire2, gridItemPossessedAdvancedGrimoire);
		addIdentity(sorceressHutBoughtCauldron, statusBarUnlockedCauldron);
		addIdentity(sorceressHutBoughtHat, eqItemHatSorceressHat);
		addIdentity(theHoleFirstChestFound, gridItemPossessedHeartPendant);
		addIdentity(theHoleSecondChestFound, gridItemPossessedFortressKey);
		addIdentity(theHoleThirdChestFound, gridItemPossessedBlackMagicGrimoire);
		addIdentity(fortressRoom3ChestFound, eqItemBootsRocketBoots);
		addIdentity(fortressRoom1ChestFound, gridItemPossessedUnicornHorn);
		addIdentity(castleRoom2TookObject, gridItemPossessedPitchfork);
		addIdentity(lighthousePuzzleDone, gridItemPossessedP);
		addIdentity(castleTowerTookTalkingCandy, gridItemPossessedTalkingCandy);
		addIdentity(candyBoxBoxOpened, statusBarUnlockedInsideYourBox, statusBarUnlockedTheComputer,
				statusBarUnlockedTheArena);

		// BEGINNING
		addStrongDependency(statusBarUnlocked, statusBarUnlockedCfg);
		addStrongDependency(statusBarUnlockedCfg, statusBarUnlockedSave);
		addStrongDependency(statusBarUnlockedSave, statusBarUnlockedHealthBar);
		addStrongDependency(statusBarUnlockedHealthBar, statusBarUnlockedMap);

		// VILLAGE
		// shop
		addStrongDependency(statusBarUnlockedMap, secondHouseLollipop1Bought);
		addStrongDependency(statusBarUnlockedMap, secondHouseLollipop2Bought);
		addStrongDependency(statusBarUnlockedMap, secondHouseLollipop3Bought);
		addStrongDependency(statusBarUnlockedMap, secondHouseChocolateBarBought);
		addStrongDependency(statusBarUnlockedInventory, eqItemGlovesLeatherGloves);
		addStrongDependency(statusBarUnlockedInventory, eqItemBootsLeatherBoots);
		// 3rd house
		addStrongDependency(gridItemPossessedMainMap, SuperRPGReward1);
		addStrongDependency(SuperRPGReward1, SuperRPGReward2);
		addStrongDependency(SuperRPGReward2, SuperRPGReward3);
		addStrongDependency(SuperRPGReward3, SuperRPGReward4);
		// forge
		addStrongDependency(statusBarUnlockedMap, forgeFoundLollipop);
		addStrongDependency(statusBarUnlockedMap, forgeBoughtWoodenSword);
		addStrongDependency(forgeBoughtWoodenSword, forgeBoughtIronAxe);
		addStrongDependency(forgeBoughtIronAxe, forgeBoughtPolishedSilverSword);
		addStrongDependency(forgeBoughtPolishedSilverSword, forgeBoughtLightweightBodyArmour);
		addStrongDependency(forgeBoughtLightweightBodyArmour, forgeBoughtScythe);
		// 4th house
		addStrongDependency(statusBarUnlockedMap, fourthHouseFoundLollipopOnCupboard);

		// MAP LEVEL 1
		addStrongDependency(gridItemPossessedMainMap, mainMapDoneDesert);
		addStrongDependency(gridItemPossessedMainMap, lonelyHouseOpenBoxDone);
		addStrongDependency(gridItemPossessedMainMap, lonelyHouseShakeBoxDone);
		addStrongDependency(gridItemPossessedMainMap, lonelyHouseBreakLockDone);
		addStrongDependency(gridItemPossessedMainMap, lonelyHouseKickBoxDone);
		addStrongDependency(gridItemPossessedMainMap, lonelyHouseAskTheBoxToOpenItselfDone);
		addStrongDependency(gridItemPossessedMainMap, lonelyHouseLureTheBoxWithACandyDone);
		addStrongDependency(lonelyHouseOpenBoxDone, lonelyHouseTakeTheBoxDone);
		addStrongDependency(lonelyHouseShakeBoxDone, lonelyHouseTakeTheBoxDone);
		addStrongDependency(lonelyHouseBreakLockDone, lonelyHouseTakeTheBoxDone);
		addStrongDependency(lonelyHouseKickBoxDone, lonelyHouseTakeTheBoxDone);
		addStrongDependency(lonelyHouseAskTheBoxToOpenItselfDone, lonelyHouseTakeTheBoxDone);
		addStrongDependency(lonelyHouseLureTheBoxWithACandyDone, lonelyHouseTakeTheBoxDone);

		// MAP LEVEL 2
		addStrongDependency(mainMapDoneDesert, mainMapDoneBridge);
		addStrongDependency(mainMapDoneDesert, gridItemPossessedPogoStick);
		addStrongDependency(mainMapDoneDesert, gridItemPossessedFeather);
		// cave
		addStrongDependency(mainMapDoneDesert, mainMapDoneCaveEntrance);
		addStrongDependency(mainMapDoneDesert, gridItemPossessedHeartPlug);
		addStrongDependency(mainMapDoneDesert, TheCavePattern_ChocolateBarNowGotTheBar);
		addStrongDependency(mainMapDoneDesert, TheCavePattern_TreasureMapSawMap);
		addStrongDependency(TheCavePattern_TreasureMapSawMap, TheCavePattern_TreasureMapFoundTreasure);
		addStrongDependency(mainMapDoneDesert, eqItemWeaponMonkeyWizardStaff);
		addStrongDependency(mainMapDoneDesert, eqItemHatOctopusKingCrown);
		// wishing well
		addStrongDependency(mainMapDoneDesert, eqItemGlovesRedEnchantedGloves);
		addStrongDependency(mainMapDoneDesert, eqItemGlovesPinkEnchantedGloves);
		addStrongDependency(mainMapDoneDesert, eqItemHatOctopusKingCrownWithJaspers);
		addStrongDependency(mainMapDoneDesert, eqItemHatOctopusKingCrownWithObsidian);
		addStrongDependency(mainMapDoneDesert, eqItemWeaponEnchantedMonkeyWizardStaff);

		// SORCERESS
		addStrongDependency(mainMapDoneBridge, sorceressHutTookLollipop);
		addStrongDependency(mainMapDoneBridge, sorceressHutBoughtGrimoire);
		addStrongDependency(mainMapDoneBridge, sorceressHutBoughtGrimoire2);
		addStrongDependency(mainMapDoneBridge, sorceressHutBoughtCauldron);
		addStrongDependency(mainMapDoneBridge, sorceressHutBoughtHat);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellHealthPotionHasSpell);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellTurtlePotionHasSpell);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellAntiGravityPotionHasSpell);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellBerserkPotionHasSpell);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellCloningPotionHasSpell);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellPPotionHasSpell);
		addStrongDependency(sorceressHutBoughtCauldron, questPlayerSpellXPotionHasSpell);
		addStrongDependency(questPlayerSpellXPotionHasSpell, eqItemBootsBootsOfIntrospection);

		// MAP LEVEL 3
		addStrongDependency(mainMapDoneCaveEntrance, mainMapDoneForest);
		addStrongDependency(mainMapDoneCaveEntrance, mainMapDonePier);
		addStrongDependency(mainMapDoneCaveEntrance, gridItemPossessedShellPowder);
		addStrongDependency(mainMapDoneCaveEntrance, gridItemPossessedSponge);
		addStrongDependency(mainMapDoneCaveEntrance, gridItemPossessedRedSharkFin);
		addStrongDependency(mainMapDoneCaveEntrance, gridItemPossessedGreenSharkFin);
		addStrongDependency(mainMapDoneCaveEntrance, gridItemPossessedPurpleSharkFin);

		// MAP LEVEL 4
		addStrongDependency(mainMapDoneForest, mainMapDoneCastleEntrance);
		addStrongDependency(mainMapDoneForest, eqItemWeaponTribalSpear);
		addStrongDependency(mainMapDoneForest, eqItemWeaponSummoningTribalSpear);
		addStrongDependency(mainMapDoneForest, theHoleFirstChestFound);
		addStrongDependency(mainMapDoneForest, theHoleSecondChestFound);
		addStrongDependency(mainMapDoneForest, theHoleThirdChestFound);
		addStrongDependency(mainMapDoneForest, theHoleFourthChestFound);

		// FORTRESS
		addStrongDependency(theHoleSecondChestFound, eqItemWeaponGiantSpoon);
		addStrongDependency(theHoleSecondChestFound, eqItemWeaponGiantSpoonOfDoom);
		addStrongDependency(theHoleSecondChestFound, fortressRoom3ChestFound);
		addStrongDependency(eqItemBootsRocketBoots, fortressRoom1ChestFound);
		addStrongDependency(eqItemBootsRocketBoots, gridItemPossessedXinopherydonClaw);

		// CASTLE
		addStrongDependency(mainMapDoneCastleEntrance, eqItemBodyArmoursKnightBodyArmour);
		addStrongDependency(mainMapDoneCastleEntrance, eqItemBodyArmoursEnchantedKnightBodyArmour);
		addStrongDependency(mainMapDoneCastleEntrance, castleRoom2LitFire);
		addStrongDependency(castleRoom2LitFire, castleRoom2TookObject);
		addStrongDependency(mainMapDoneCastleEntrance, castleBigRoomHovenHappy);
		addStrongDependency(mainMapDoneCastleEntrance, gridItemPossessedL);
		addStrongDependency(mainMapDoneCastleEntrance, dragonDone);
		addStrongDependency(dragonDone, dragonUnlockedCyclops);
		addStrongDependency(dragonUnlockedCyclops, lighthousePuzzleDone);
		addStrongDependency(dragonDone, gridItemPossessedA);
		addStrongDependency(dragonDone, gridItemPossessedY);
		addStrongDependency(gridItemPossessedP, castleTowerPStoneDone);
		addStrongDependency(gridItemPossessedL, castleTowerLStoneDone);
		addStrongDependency(gridItemPossessedA, castleTowerAStoneDone);
		addStrongDependency(gridItemPossessedY, castleTowerYStoneDone);
		addStrongDependency(castleKilledNougatMonster, castleTowerFirstVisitDone);
		addStrongDependency(castleTowerFirstVisitDone, castleTowerPStoneDone);
		addStrongDependency(castleTowerFirstVisitDone, castleTowerLStoneDone);
		addStrongDependency(castleTowerFirstVisitDone, castleTowerAStoneDone);
		addStrongDependency(castleTowerFirstVisitDone, castleTowerYStoneDone);
		addStrongDependency(castleTowerPStoneDone, castleTowerTookTalkingCandy);
		addStrongDependency(castleTowerLStoneDone, castleTowerTookTalkingCandy);
		addStrongDependency(castleTowerAStoneDone, castleTowerTookTalkingCandy);
		addStrongDependency(castleTowerYStoneDone, castleTowerTookTalkingCandy);
		addStrongDependency(castleTowerTookTalkingCandy, candyBoxBoxOpened);
	}

	private static void addIdentity(Key... identicalKeys) {
		IDENTITIES.add(identicalKeys);
	}

	private static void addStrongDependency(Key required, Key dependent) {
		STRONG_DEPENDENCIES.add(new Dependency(required, dependent));
	}

	/**
	 * Returns whether the specified key exists in the game.
	 * 
	 * @param name
	 *            the name of the key to check
	 * @return {@code true} if the key exists, false otherwise.
	 */
	public static boolean exists(String name) {
		try {
			valueOf(name);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Defines a dependency between 2 {@link Key}s R (required) and D (dependent).
	 */
	public static final class Dependency extends Pair<Key, Key> {

		public Dependency(Key required, Key dependent) {
			super(required, dependent);
		}

		public Key getRequired() {
			return getKey();
		}

		public Key getDependent() {
			return getValue();
		}
	}
}
