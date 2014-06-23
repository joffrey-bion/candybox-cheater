package com.jbion.candyboxcheater.game;

import java.text.ParseException;
import java.util.Map;

import javafx.beans.binding.StringBinding;

import com.jbion.candyboxcheater.game.variables.BooleanVariable;
import com.jbion.candyboxcheater.game.variables.NumberVariable;
import com.jbion.candyboxcheater.game.variables.Variable;
import com.jbion.candyboxcheater.parser.CandyGameSaveParser;

/**
 * Represents the state of a game.
 */
public class GameState {

	/** The text corresponding to a save at the beginning of the game. */
	private static final String INIT_GAME = "bool candiesThrownGotChocolateBar=false, bool candyBoxBoxOpened=false, bool castleBigRoomHovenHappy=false, bool castleRoom2LitFire=false, bool castleRoom2TookObject=false, bool castleTowerFirstVisitDone=false, bool castleTowerPStoneDone=false, bool castleTowerLStoneDone=false, bool castleTowerAStoneDone=false, bool castleTowerYStoneDone=false, bool castleTowerTookTalkingCandy=false, bool castleKilledNougatMonster=false, bool cellarDone=false, bool dragonDone=false, bool dragonUnlockedCyclops=false, bool forgeFoundLollipop=false, bool forgeBoughtWoodenSword=false, bool forgeBoughtIronAxe=false, bool forgeBoughtPolishedSilverSword=false, bool forgeBoughtLightweightBodyArmour=false, bool forgeBoughtScythe=false, bool fortressRoom1ChestFound=false, bool fortressRoom3ChestFound=false, bool fourthHouseFoundLollipopOnCupboard=false, bool gameDebug=false, bool gameInvertedColors=false, bool lighthousePuzzleDone=false, bool lollipopFarmPlant1LollipopButtonUnlocked=false, bool lollipopFarmPlant10LollipopsButtonUnlocked=false, bool lollipopFarmPlant100LollipopsButtonUnlocked=false, bool lollipopFarmPlant1000LollipopsButtonUnlocked=false, bool lollipopFarmIsProductionEachSecond=false, bool lollipopFarmConstructMillButtonUnlocked=false, bool lollipopFarmMillConstructed=false, bool lollipopFarmDigPondButtonUnlocked=false, bool lollipopFarmPondDug=false, bool lollipopFarmPondFeedingLolligators=false, bool lonelyHouseOpenBoxDone=false, bool lonelyHouseShakeBoxDone=false, bool lonelyHouseBreakLockDone=false, bool lonelyHouseKickBoxDone=false, bool lonelyHouseAskTheBoxToOpenItselfDone=false, bool lonelyHouseLureTheBoxWithACandyDone=false, bool lonelyHouseTakeTheBoxDone=false, bool mainMapDoneDesert=false, bool mainMapDoneBridge=false, bool mainMapDoneCaveEntrance=false, bool mainMapDonePier=false, bool mainMapDoneForest=false, bool mainMapDoneCastleEntrance=false, bool questPlayerSpellHealthPotionHasSpell=false, bool questPlayerSpellTurtlePotionHasSpell=false, bool questPlayerSpellAntiGravityPotionHasSpell=false, bool questPlayerSpellBerserkPotionHasSpell=false, bool questPlayerSpellCloningPotionHasSpell=false, bool questPlayerSpellPPotionHasSpell=false, bool questPlayerSpellXPotionHasSpell=false, bool secondHouseLollipop1Bought=false, bool secondHouseLollipop2Bought=false, bool secondHouseLollipop3Bought=false, bool secondHouseLeatherBootsBought=false, bool secondHouseChocolateBarBought=false, bool secondHouseMerchantHatBought=false, bool secondHouseTimeRingBought=false, bool sorceressHutTookLollipop=false, bool sorceressHutBoughtGrimoire=false, bool sorceressHutBoughtGrimoire2=false, bool sorceressHutBoughtCauldron=false, bool sorceressHutBoughtHat=false, bool statusBarUnlocked=true, bool statusBarUnlockedCfg=true, bool statusBarUnlockedSave=true, bool statusBarUnlockedMap=false, bool statusBarUnlockedInventory=false, bool statusBarUnlockedLollipopFarm=false, bool statusBarUnlockedCauldron=false, bool statusBarUnlockedInsideYourBox=false, bool statusBarUnlockedTheComputer=false, bool statusBarUnlockedTheArena=false, bool statusBarUnlockedHealthBar=false, bool SuperRPGReward1=false, bool SuperRPGReward2=false, bool SuperRPGReward3=false, bool SuperRPGReward4=false, bool SuperRPGUnlockedHardmode=false, bool TheCavePattern_ChocolateBarNowGotTheBar=false, bool TheCavePattern_TreasureMapSawMap=false, bool TheCavePattern_TreasureMapFoundTreasure=false, bool theHoleFirstChestFound=false, bool theHoleSecondChestFound=false, bool theHoleThirdChestFound=false, bool theHoleFourthChestFound=false, bool wishingWellFirstCandyThrown=false, bool wishingWellFirstLollipopThrown=false, bool wishingWellWeAreEnchanting=false, bool wishingWellWeArePainAuChocolating=false, bool gridItemPossessedMainMap=false, bool gridItemPossessedTimeRing=false, bool gridItemPossessedThirdHouseKey=false, bool gridItemPossessedBeginnersGrimoire=false, bool gridItemPossessedFeather=false, bool gridItemPossessedPogoStick=false, bool gridItemPossessedHeartPlug=false, bool gridItemPossessedAdvancedGrimoire=false, bool gridItemPossessedSponge=false, bool gridItemPossessedShellPowder=false, bool gridItemPossessedRedSharkFin=false, bool gridItemPossessedBlackMagicGrimoire=false, bool gridItemPossessedGreenSharkFin=false, bool gridItemPossessedPurpleSharkFin=false, bool gridItemPossessedHeartPendant=false, bool gridItemPossessedFortressKey=false, bool gridItemPossessedUnicornHorn=false, bool gridItemPossessedXinopherydonClaw=false, bool gridItemPossessedPitchfork=false, bool gridItemPossessedTalkingCandy=false, bool gridItemPossessedP=false, bool gridItemPossessedL=false, bool gridItemPossessedA=false, bool gridItemPossessedY=false, bool eqItemWeaponWoodenSword=false, bool eqItemWeaponIronAxe=false, bool eqItemWeaponPolishedSilverSword=false, bool eqItemWeaponTrollBludgeon=false, bool eqItemWeaponMonkeyWizardStaff=false, bool eqItemWeaponEnchantedMonkeyWizardStaff=false, bool eqItemWeaponTribalSpear=false, bool eqItemWeaponSummoningTribalSpear=false, bool eqItemWeaponGiantSpoon=false, bool eqItemWeaponScythe=false, bool eqItemWeaponGiantSpoonOfDoom=false, bool eqItemHatOctopusKingCrown=false, bool eqItemHatOctopusKingCrownWithJaspers=false, bool eqItemHatOctopusKingCrownWithObsidian=false, bool eqItemHatMerchantHat=false, bool eqItemHatSorceressHat=false, bool eqItemBodyArmoursLightweightBodyArmour=false, bool eqItemBodyArmoursKnightBodyArmour=false, bool eqItemBodyArmoursEnchantedKnightBodyArmour=false, bool eqItemGlovesLeatherGloves=false, bool eqItemGlovesRedEnchantedGloves=false, bool eqItemGlovesPinkEnchantedGloves=false, bool eqItemBootsLeatherBoots=false, bool eqItemBootsRocketBoots=false, bool eqItemBootsBootsOfIntrospection=false, number aTreeStep=0, number cauldronBookCurrentPage=0, number fourthHouseCupboardStep=0, number fourthHouseCarpetStep=0, number galacticWarsBestScore=0, number gameSecondsElapsedSinceLastLollipopsProduction=0, number gameCandiesAccumulated=40, number gameCandiesCurrent=0, number gameCandiesMax=30, number gameLollipopsAccumulated=0, number gameLollipopsCurrent=0, number gameLollipopsMax=0, number gameChocolateBarsAccumulated=0, number gameChocolateBarsCurrent=0, number gameChocolateBarsMax=0, number gamePainsAuChocolatAccumulated=0, number gamePainsAuChocolatCurrent=0, number gamePainsAuChocolatMax=0, number gameCandiesEatenAccumulated=0, number gameCandiesEatenCurrent=0, number gameCandiesEatenMax=0, number gameCandiesThrownAccumulated=0, number gameCandiesThrownCurrent=0, number gameCandiesThrownMax=0, number gameCandiesUsedToRequestFeaturesAccumulated=40, number gameCandiesUsedToRequestFeaturesCurrent=40, number gameCandiesUsedToRequestFeaturesMax=40, number gameCandiesInCauldronAccumulated=0, number gameCandiesInCauldronCurrent=0, number gameCandiesInCauldronMax=0, number gameLollipopsInCauldronAccumulated=0, number gameLollipopsInCauldronCurrent=0, number gameLollipopsInCauldronMax=0, number gameGiftPower=0, number gameGiftHealth=0, number gameGiftMagic=0, number lollipopFarmLollipopsPlanted=0, number lollipopFarmTimeSinceLastProduction=0, number lollipopFarmProduction=0, number lollipopFarmPondHowManyLolligators=0, number lollipopFarmPondConversionRate=0, number lollipopFarmPreviousCandiesProduction=1, number lollipopFarmCurrentCandiesProduction=1, number mainMapDefaultScroll=400, number playerHp=100, number questPlayerSpellHealthPotionQuantity=0, number questPlayerSpellAntiGravityPotionQuantity=0, number questPlayerSpellTurtlePotionQuantity=0, number questPlayerSpellBerserkPotionQuantity=0, number questPlayerSpellCloningPotionQuantity=0, number questPlayerSpellPPotionQuantity=0, number questPlayerSpellXPotionQuantity=0, number statusBarCornerStep=0, number wishingWellPreviousCandyWishPrice=1, number wishingWellCurrentCandyWishPrice=1, number wishingWellCurrentLollipopWishPrice=1, number wishingWellHowManyChocolateBarsThrown=0, number wishingWellHowManyPainsAuChocolatThrown=0, string gameLanguage=en, string gameWeaponSelected=inventorySpecialNothingWeapon, string gameHatSelected=inventorySpecialNothingHat, string gameBodyArmourSelected=inventorySpecialNothingBodyArmour, string gameGlovesSelected=inventorySpecialNothingGloves, string gameBootsSelected=inventorySpecialNothingBoots, string gameGameMode=normal";

	private static GameState instance;

	/**
	 * Returns the only instance of the {@link GameState}, which is lazily
	 * initialized.
	 * 
	 * @return the only instance of the {@link GameState}.
	 */
	public static GameState getInstance() {
		if (instance == null) {
			instance = new GameState();
		}
		return instance;
	}

	private Map<Key, Variable> vars;
	private StringBinding textValue;

	/**
	 * Creates a new {@link GameState} with initial values corresponding to the
	 * beginning of the game.
	 */
	private GameState() {
		try {
			this.vars = CandyGameSaveParser.parse(INIT_GAME);
		} catch (ParseException e) {
			throw new RuntimeException("Incorrect initial save", e);
		}
	}

	/**
	 * Resets this {@link GameState} to the save corresponding to the beginning of
	 * the game.
	 */
	public void reset() {
		try {
			updateTo(INIT_GAME);
		} catch (ParseException e) {
			throw new RuntimeException("Incorrect initial save", e);
		}
	}

	/**
	 * Updates this {@link GameState} with the values of the variables contained in
	 * the specified textual save.
	 * 
	 * @param saveText
	 *            the text of the save to parse
	 * @throws ParseException
	 *             if an error occurred while parsing the specified text
	 */
	public void updateTo(String saveText) throws ParseException {
		CandyGameSaveParser.parseAndUpdate(saveText, vars);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Key key : vars.keySet()) {
			sb.append(vars.get(key).toString()).append(',');
		}
		int lastCommaPosition = sb.lastIndexOf(",");
		if (lastCommaPosition >= 0) {
			sb.deleteCharAt(lastCommaPosition);
		}
		return sb.toString();
	}

	/**
	 * Returns a binding to the string value of this {@link GameState}.
	 * 
	 * @return a binding to the string value of this {@link GameState}.
	 */
	public StringBinding getStateBinding() {
		textValue = new StringBinding() {
			{
				for (Key key : vars.keySet()) {
					bind(vars.get(key).stringValueProperty());
				}
			}

			@Override
			protected String computeValue() {
				return GameState.this.toString();
			}
		};
		return textValue;
	}

	/**
	 * Returns the variable referred to by the specified {@link Key}.
	 * 
	 * @param key
	 *            the key of the variable to get
	 * @return the requested {@link Variable} object
	 */
	public Variable getVariable(Key key) {
		return vars.get(key);
	}

	/**
	 * Returns the boolean variable referred to by the specified {@link Key}.
	 * 
	 * @param key
	 *            the key of the variable to get
	 * @return the requested {@link BooleanVariable} object
	 * @throws ClassCastException
	 *             if the key does not refer to a {@link BooleanVariable}
	 */
	public BooleanVariable getBooleanVariable(Key key) throws ClassCastException {
		return (BooleanVariable) vars.get(key);
	}

	/**
	 * Returns the numeric variable referred to by the specified {@link Key}.
	 * 
	 * @param key
	 *            the key of the variable to get
	 * @return the requested {@link NumberVariable} object
	 * @throws ClassCastException
	 *             if the key does not refer to a {@link NumberVariable}
	 */
	public NumberVariable getNumberVariable(Key key) throws ClassCastException {
		return (NumberVariable) vars.get(key);
	}

	public void incrementCandies(long amount) {
		incrementVariable(amount, Key.gameCandiesCurrent, Key.gameCandiesAccumulated, Key.gameCandiesMax);
	}

	public void incrementEatenCandies(long amount) {
		incrementVariable(amount, Key.gameCandiesEatenCurrent, Key.gameCandiesEatenAccumulated,
				Key.gameCandiesEatenMax, Key.gameCandiesAccumulated);
	}

	public void incrementThrownCandies(long amount) {
		incrementVariable(amount, Key.gameCandiesThrownCurrent, Key.gameCandiesThrownAccumulated,
				Key.gameCandiesThrownMax, Key.gameCandiesAccumulated);
	}

	public void incrementLollipops(long amount) {
		incrementVariable(amount, Key.gameLollipopsCurrent, Key.gameLollipopsAccumulated, Key.gameLollipopsMax);
	}

	public void incrementChocolateBars(long amount) {
		incrementVariable(amount, Key.gameChocolateBarsCurrent, Key.gameChocolateBarsAccumulated,
				Key.gameChocolateBarsMax);
	}

	public void incrementPainsAuChocolat(long amount) {
		incrementVariable(amount, Key.gamePainsAuChocolatCurrent, Key.gamePainsAuChocolatAccumulated,
				Key.gamePainsAuChocolatMax);
	}

	/**
	 * Increments the specified variable. This method allows to maintain consistency
	 * of related variables in addition to the simple current value.
	 * 
	 * @param amount
	 *            The amount to add to the variable
	 * @param currentKey
	 *            The key of the variable representing the current value
	 * @param accumulatorKey
	 *            The key of the variable representing the accumulated value
	 * @param maxKey
	 *            The key of the variable representing the max reached value
	 */
	private void incrementVariable(long amount, Key currentKey, Key accumulatorKey, Key maxKey,
			Key... parentAccumulators) {
		long newCurrent = getNumberVariable(currentKey).increment(amount);
		NumberVariable max = getNumberVariable(maxKey);
		if (newCurrent > max.getLongValue()) {
			max.setLongValue(newCurrent);
		}
		getNumberVariable(accumulatorKey).increment(amount);
		for (Key accKey : parentAccumulators) {
			getNumberVariable(accKey).increment(amount);
		}
	}
}
