package com.jbion.candyboxcheater.game;

import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

/**
 * Represents the dependency graph of the variables of the game.
 * <p>
 * There are 2 types of dependency between 2 boolean variables R and D:
 * </p>
 * <ul>
 * <li><b>Identity:</b> R and D must always have the same value.</li>
 * <li><b>Requirement:</b> R is required to be {@code true} for D to be {@code true},
 * but D can be {@code false} even if R is {@code true}.</li>
 * </ul>
 * <p>
 * A boolean variable D can similarly depend on a numeric variable R:
 * </p>
 * <ul>
 * <li><b>Threshold identity:</b> for a given threshold {@code t}, D is always equal
 * to {@code R >= t}.</li>
 * <li><b>Threshold requirement:</b> D can't be true if R is less than a given
 * threshold, but D can be {@code false} even if R is greater than (or equal to) the
 * threshold.</li>
 * </ul>
 * 
 */
public class GameGraph {

	/**
	 * Defines sets of {@link Key}s that must always have the same value.
	 */
	public static final List<Key[]> BOOLEAN_IDENTITIES = new LinkedList<>();

	/**
	 * Defines {@link Dependency} relations between boolean variables where:
	 * <ul>
	 * <li>If {@code R} becomes {@code false}, {@code D} must be set to {@code false}
	 * because it depends on {@code R}</li>
	 * <li>If {@code D} becomes {@code true}, {@code R} must be set to {@code true}
	 * because it is required for {@code D}</li>
	 * </ul>
	 */
	public static final List<Dependency> BOOLEAN_REQUIREMENTS = new LinkedList<>();

	/**
	 * Defines {@link Dependency} relations between a numeric variable R and a
	 * boolean variable D where D must always be equal to {@code R >= t}.
	 */
	public static final List<ThresholdDependency> THRESHOLD_IDENTITIES = new LinkedList<>();

	/**
	 * Defines {@link Dependency} relations between a numeric variable R and a
	 * boolean variable D where:
	 * <ul>
	 * <li>If {@code R} falls below the threshold, {@code D} must be set to
	 * {@code false}</li>
	 * <li>If {@code D} becomes {@code true}, then if {@code R} is less than the
	 * threshold, it must be set equal to the threshold</li>
	 * </ul>
	 */
	public static final List<ThresholdDependency> THRESHOLD_REQUIREMENTS = new LinkedList<>();

	static {
		// BEGINNING
		addMinThresholdIdentity(Key.gameCandiesThrownAccumulated, Key.candiesThrownGotChocolateBar, 1630);
		addMinThresholdIdentity(Key.gameCandiesUsedToRequestFeaturesAccumulated, Key.statusBarUnlocked, 30);
		addMinThresholdIdentity(Key.gameCandiesUsedToRequestFeaturesAccumulated, Key.statusBarUnlockedCfg, 35);
		addMinThresholdIdentity(Key.gameCandiesUsedToRequestFeaturesAccumulated, Key.statusBarUnlockedSave, 40);
		addMinThresholdIdentity(Key.gameCandiesUsedToRequestFeaturesAccumulated, Key.statusBarUnlockedHealthBar, 45);
		addMinThresholdIdentity(Key.gameCandiesUsedToRequestFeaturesAccumulated, Key.statusBarUnlockedMap, 55);

		// VILLAGE
		// shop
		addRequirement(Key.statusBarUnlockedMap, Key.secondHouseLollipop1Bought);
		addRequirement(Key.statusBarUnlockedMap, Key.secondHouseLollipop2Bought);
		addRequirement(Key.statusBarUnlockedMap, Key.secondHouseLollipop3Bought);
		addRequirement(Key.statusBarUnlockedMap, Key.secondHouseChocolateBarBought);
		addRequirement(Key.statusBarUnlockedInventory, Key.eqItemGlovesLeatherGloves);
		addRequirement(Key.statusBarUnlockedInventory, Key.eqItemBootsLeatherBoots);
		addRequirement(Key.statusBarUnlockedInventory, Key.secondHouseTimeRingBought);
		addIdentity(Key.secondHouseTimeRingBought, Key.gridItemPossessedTimeRing);
		addRequirement(Key.statusBarUnlockedInventory, Key.secondHouseMerchantHatBought);
		addIdentity(Key.secondHouseMerchantHatBought, Key.eqItemHatMerchantHat);
		// 3rd house
		addRequirement(Key.gridItemPossessedThirdHouseKey, Key.SuperRPGReward1);
		addRequirement(Key.SuperRPGReward1, Key.SuperRPGReward2);
		addRequirement(Key.SuperRPGReward2, Key.SuperRPGReward3);
		addRequirement(Key.SuperRPGReward3, Key.SuperRPGReward4);
		addIdentity(Key.SuperRPGReward4, Key.SuperRPGUnlockedHardmode);
		// forge
		addRequirement(Key.statusBarUnlockedMap, Key.forgeFoundLollipop);
		addRequirement(Key.statusBarUnlockedMap, Key.forgeBoughtWoodenSword);
		addIdentity(Key.forgeBoughtWoodenSword, Key.eqItemWeaponWoodenSword, Key.statusBarUnlockedInventory);
		addRequirement(Key.forgeBoughtWoodenSword, Key.forgeBoughtIronAxe);
		addIdentity(Key.forgeBoughtIronAxe, Key.eqItemWeaponIronAxe);
		addRequirement(Key.forgeBoughtIronAxe, Key.forgeBoughtPolishedSilverSword);
		addIdentity(Key.forgeBoughtPolishedSilverSword, Key.eqItemWeaponPolishedSilverSword);
		addRequirement(Key.forgeBoughtPolishedSilverSword, Key.forgeBoughtLightweightBodyArmour);
		addRequirement(Key.mainMapDoneCaveEntrance, Key.forgeBoughtLightweightBodyArmour);
		addIdentity(Key.forgeBoughtLightweightBodyArmour, Key.eqItemBodyArmoursLightweightBodyArmour);
		addRequirement(Key.forgeBoughtLightweightBodyArmour, Key.forgeBoughtScythe);
		addRequirement(Key.dragonDone, Key.forgeBoughtScythe);
		addIdentity(Key.forgeBoughtScythe, Key.eqItemWeaponScythe);
		// 4th house
		addRequirement(Key.statusBarUnlockedMap, Key.fourthHouseFoundLollipopOnCupboard);
		// TODO cupboard steps dependency on statusBarUnlockedMap
		// TODO carpet steps dependency on statusBarUnlockedMap
		// 5th house
		addRequirement(Key.forgeBoughtWoodenSword, Key.cellarDone);
		addIdentity(Key.cellarDone, Key.gridItemPossessedMainMap);

		// MAP LEVEL 1
		addRequirement(Key.gridItemPossessedMainMap, Key.mainMapDoneDesert);
		// squirrel
		addMinThresholdIdentity(Key.aTreeStep, Key.gridItemPossessedThirdHouseKey, 8);
		// lonely house
		addRequirement(Key.gridItemPossessedMainMap, Key.lonelyHouseOpenBoxDone);
		addRequirement(Key.gridItemPossessedMainMap, Key.lonelyHouseShakeBoxDone);
		addRequirement(Key.gridItemPossessedMainMap, Key.lonelyHouseBreakLockDone);
		addRequirement(Key.gridItemPossessedMainMap, Key.lonelyHouseKickBoxDone);
		addRequirement(Key.gridItemPossessedMainMap, Key.lonelyHouseAskTheBoxToOpenItselfDone);
		addRequirement(Key.gridItemPossessedMainMap, Key.lonelyHouseLureTheBoxWithACandyDone);
		addRequirement(Key.lonelyHouseOpenBoxDone, Key.lonelyHouseTakeTheBoxDone);
		addRequirement(Key.lonelyHouseShakeBoxDone, Key.lonelyHouseTakeTheBoxDone);
		addRequirement(Key.lonelyHouseBreakLockDone, Key.lonelyHouseTakeTheBoxDone);
		addRequirement(Key.lonelyHouseKickBoxDone, Key.lonelyHouseTakeTheBoxDone);
		addRequirement(Key.lonelyHouseAskTheBoxToOpenItselfDone, Key.lonelyHouseTakeTheBoxDone);
		addRequirement(Key.lonelyHouseLureTheBoxWithACandyDone, Key.lonelyHouseTakeTheBoxDone);

		// MAP LEVEL 2
		addRequirement(Key.mainMapDoneDesert, Key.mainMapDoneBridge);
		addIdentity(Key.mainMapDoneBridge, Key.eqItemWeaponTrollBludgeon);
		addRequirement(Key.mainMapDoneDesert, Key.gridItemPossessedPogoStick);
		addRequirement(Key.mainMapDoneDesert, Key.gridItemPossessedFeather);
		// lollipop farm
		addIdentity(Key.mainMapDoneDesert, Key.statusBarUnlockedLollipopFarm,
				Key.lollipopFarmPlant1LollipopButtonUnlocked);
		addMinThresholdIdentity(Key.gameLollipopsMax, Key.lollipopFarmPlant10LollipopsButtonUnlocked, 10);
		addMinThresholdIdentity(Key.gameLollipopsMax, Key.lollipopFarmPlant100LollipopsButtonUnlocked, 100);
		addMinThresholdIdentity(Key.gameLollipopsMax, Key.lollipopFarmPlant1000LollipopsButtonUnlocked, 1000);
		addMinThresholdIdentity(Key.gameLollipopsMax, Key.lollipopFarmConstructMillButtonUnlocked, 10000);
		addRequirement(Key.lollipopFarmConstructMillButtonUnlocked, Key.lollipopFarmMillConstructed);
		addMinThresholdIdentity(Key.gameLollipopsMax, Key.lollipopFarmDigPondButtonUnlocked, 100000);
		addRequirement(Key.lollipopFarmDigPondButtonUnlocked, Key.lollipopFarmPondDug);
		// cave
		addRequirement(Key.mainMapDoneDesert, Key.mainMapDoneCaveEntrance);
		addRequirement(Key.mainMapDoneDesert, Key.gridItemPossessedHeartPlug);
		addRequirement(Key.mainMapDoneDesert, Key.TheCavePattern_ChocolateBarNowGotTheBar);
		addRequirement(Key.mainMapDoneDesert, Key.TheCavePattern_TreasureMapSawMap);
		addRequirement(Key.TheCavePattern_TreasureMapSawMap, Key.TheCavePattern_TreasureMapFoundTreasure);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemWeaponMonkeyWizardStaff);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemHatOctopusKingCrown);
		// wishing well
		addRequirement(Key.mainMapDoneDesert, Key.wishingWellFirstCandyThrown);
		addRequirement(Key.mainMapDoneDesert, Key.wishingWellFirstLollipopThrown);
		addRequirement(Key.mainMapDoneDesert, Key.wishingWellWeAreEnchanting);
		addRequirement(Key.mainMapDoneDesert, Key.wishingWellWeArePainAuChocolating);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemGlovesRedEnchantedGloves);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemGlovesPinkEnchantedGloves);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemHatOctopusKingCrownWithJaspers);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemHatOctopusKingCrownWithObsidian);
		addRequirement(Key.mainMapDoneDesert, Key.eqItemWeaponEnchantedMonkeyWizardStaff);

		// SORCERESS
		addRequirement(Key.mainMapDoneBridge, Key.sorceressHutTookLollipop);
		addRequirement(Key.mainMapDoneBridge, Key.sorceressHutBoughtGrimoire);
		addIdentity(Key.sorceressHutBoughtGrimoire, Key.gridItemPossessedBeginnersGrimoire);
		addRequirement(Key.mainMapDoneBridge, Key.sorceressHutBoughtGrimoire2);
		addIdentity(Key.sorceressHutBoughtGrimoire2, Key.gridItemPossessedAdvancedGrimoire);
		addRequirement(Key.mainMapDoneBridge, Key.sorceressHutBoughtCauldron);
		addIdentity(Key.sorceressHutBoughtCauldron, Key.statusBarUnlockedCauldron);
		addRequirement(Key.mainMapDoneBridge, Key.sorceressHutBoughtHat);
		addIdentity(Key.sorceressHutBoughtHat, Key.eqItemHatSorceressHat);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellHealthPotionHasSpell);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellTurtlePotionHasSpell);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellAntiGravityPotionHasSpell);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellBerserkPotionHasSpell);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellCloningPotionHasSpell);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellPPotionHasSpell);
		addRequirement(Key.sorceressHutBoughtCauldron, Key.questPlayerSpellXPotionHasSpell);
		addRequirement(Key.questPlayerSpellXPotionHasSpell, Key.eqItemBootsBootsOfIntrospection);

		// MAP LEVEL 3
		addRequirement(Key.mainMapDoneCaveEntrance, Key.mainMapDoneForest);
		// pier
		addRequirement(Key.mainMapDoneCaveEntrance, Key.mainMapDonePier);
		// underwater
		addRequirement(Key.mainMapDoneCaveEntrance, Key.gridItemPossessedShellPowder);
		addRequirement(Key.mainMapDoneCaveEntrance, Key.gridItemPossessedSponge);
		addRequirement(Key.mainMapDoneCaveEntrance, Key.gridItemPossessedRedSharkFin);
		addRequirement(Key.mainMapDoneCaveEntrance, Key.gridItemPossessedGreenSharkFin);
		addRequirement(Key.mainMapDoneCaveEntrance, Key.gridItemPossessedPurpleSharkFin);

		// MAP LEVEL 4
		addRequirement(Key.mainMapDoneForest, Key.mainMapDoneCastleEntrance);
		// the hole
		addRequirement(Key.mainMapDoneForest, Key.eqItemWeaponTribalSpear);
		addRequirement(Key.mainMapDoneForest, Key.eqItemWeaponSummoningTribalSpear);
		addRequirement(Key.mainMapDoneForest, Key.theHoleFirstChestFound);
		addIdentity(Key.theHoleFirstChestFound, Key.gridItemPossessedHeartPendant);
		addRequirement(Key.mainMapDoneForest, Key.theHoleSecondChestFound);
		addIdentity(Key.theHoleSecondChestFound, Key.gridItemPossessedFortressKey);
		addRequirement(Key.mainMapDoneForest, Key.theHoleThirdChestFound);
		addIdentity(Key.theHoleThirdChestFound, Key.gridItemPossessedBlackMagicGrimoire);
		addRequirement(Key.mainMapDoneForest, Key.theHoleFourthChestFound);

		// FORTRESS
		addRequirement(Key.gridItemPossessedFortressKey, Key.eqItemWeaponGiantSpoon);
		addRequirement(Key.gridItemPossessedFortressKey, Key.eqItemWeaponGiantSpoonOfDoom);
		addRequirement(Key.gridItemPossessedFortressKey, Key.fortressRoom3ChestFound);
		addIdentity(Key.fortressRoom3ChestFound, Key.eqItemBootsRocketBoots);
		addRequirement(Key.eqItemBootsRocketBoots, Key.gridItemPossessedXinopherydonClaw);
		addRequirement(Key.eqItemBootsRocketBoots, Key.fortressRoom1ChestFound);
		addIdentity(Key.fortressRoom1ChestFound, Key.gridItemPossessedUnicornHorn);

		// CASTLE
		addRequirement(Key.mainMapDoneCastleEntrance, Key.eqItemBodyArmoursKnightBodyArmour);
		addRequirement(Key.mainMapDoneCastleEntrance, Key.eqItemBodyArmoursEnchantedKnightBodyArmour);
		addRequirement(Key.mainMapDoneCastleEntrance, Key.castleRoom2LitFire);
		addRequirement(Key.castleRoom2LitFire, Key.castleRoom2TookObject);
		addIdentity(Key.castleRoom2TookObject, Key.gridItemPossessedPitchfork);
		addRequirement(Key.mainMapDoneCastleEntrance, Key.castleBigRoomHovenHappy);
		addRequirement(Key.mainMapDoneCastleEntrance, Key.gridItemPossessedL);
		addRequirement(Key.mainMapDoneCastleEntrance, Key.dragonDone);
		addRequirement(Key.dragonDone, Key.dragonUnlockedCyclops);
		addRequirement(Key.mainMapDonePier, Key.lighthousePuzzleDone);
		addRequirement(Key.dragonUnlockedCyclops, Key.lighthousePuzzleDone);
		addIdentity(Key.lighthousePuzzleDone, Key.gridItemPossessedP);
		addRequirement(Key.dragonDone, Key.gridItemPossessedA);
		addRequirement(Key.dragonDone, Key.gridItemPossessedY);
		addRequirement(Key.gridItemPossessedP, Key.castleTowerPStoneDone);
		addRequirement(Key.gridItemPossessedL, Key.castleTowerLStoneDone);
		addRequirement(Key.gridItemPossessedA, Key.castleTowerAStoneDone);
		addRequirement(Key.gridItemPossessedY, Key.castleTowerYStoneDone);
		addRequirement(Key.castleKilledNougatMonster, Key.castleTowerFirstVisitDone);
		addRequirement(Key.castleTowerFirstVisitDone, Key.castleTowerPStoneDone);
		addRequirement(Key.castleTowerFirstVisitDone, Key.castleTowerLStoneDone);
		addRequirement(Key.castleTowerFirstVisitDone, Key.castleTowerAStoneDone);
		addRequirement(Key.castleTowerFirstVisitDone, Key.castleTowerYStoneDone);
		addRequirement(Key.castleTowerPStoneDone, Key.castleTowerTookTalkingCandy);
		addRequirement(Key.castleTowerLStoneDone, Key.castleTowerTookTalkingCandy);
		addRequirement(Key.castleTowerAStoneDone, Key.castleTowerTookTalkingCandy);
		addRequirement(Key.castleTowerYStoneDone, Key.castleTowerTookTalkingCandy);
		addIdentity(Key.castleTowerTookTalkingCandy, Key.gridItemPossessedTalkingCandy);
		addRequirement(Key.castleTowerTookTalkingCandy, Key.candyBoxBoxOpened);
		addIdentity(Key.candyBoxBoxOpened, Key.statusBarUnlockedInsideYourBox, Key.statusBarUnlockedTheComputer,
				Key.statusBarUnlockedTheArena);
	}

	private static void addIdentity(Key... identicalKeys) {
		BOOLEAN_IDENTITIES.add(identicalKeys);
	}

	private static void addRequirement(Key required, Key dependent) {
		BOOLEAN_REQUIREMENTS.add(new Dependency(required, dependent));
	}

	private static void addMinThresholdIdentity(Key required, Key dependent, long threshold) {
		THRESHOLD_IDENTITIES.add(new ThresholdDependency(required, dependent, threshold));
	}

	/**
	 * Defines a dependency between 2 {@link Key}s R (required) and D (dependent).
	 */
	public static class Dependency extends Pair<Key, Key> {

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

	/**
	 * Defines a dependency between 2 {@link Key}s R (required) and D (dependent),
	 * where a numeric threshold is involved. This class can be used to represent
	 * dependencies with numeric variables.
	 */
	public static class ThresholdDependency extends Dependency {

		private final long threshold;

		public ThresholdDependency(Key required, Key dependent, long threshold) {
			super(required, dependent);
			this.threshold = threshold;
		}

		public long getThreshold() {
			return threshold;
		}
	}
}
