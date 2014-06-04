package com.jbion.candyboxcheater.game;

import java.util.Arrays;
import java.util.List;

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
	
	private List<Key> controlledKeys;
	
	private Key(Key... controlledKeys) {
		this.controlledKeys = Arrays.asList(controlledKeys);
	}
	
	public List<Key> getControlledKeys() {
		return controlledKeys;
	}
}