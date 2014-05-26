package com.jbion.candyboxcheater.game;

import java.util.Map;
import java.util.Set;

import javafx.beans.binding.StringBinding;

import com.jbion.candyboxcheater.game.variables.BooleanVariable;
import com.jbion.candyboxcheater.game.variables.NumberVariable;
import com.jbion.candyboxcheater.game.variables.Variable;
import com.jbion.candyboxcheater.parser.CandyGameSaveParser;

public class GameState {

    public static final String INIT_GAME = "bool candiesThrownGotChocolateBar=false, bool candyBoxBoxOpened=false, bool castleBigRoomHovenHappy=false, bool castleRoom2LitFire=false, bool castleRoom2TookObject=false, bool castleTowerFirstVisitDone=false, bool castleTowerPStoneDone=false, bool castleTowerLStoneDone=false, bool castleTowerAStoneDone=false, bool castleTowerYStoneDone=false, bool castleTowerTookTalkingCandy=false, bool castleKilledNougatMonster=false, bool cellarDone=false, bool dragonDone=false, bool dragonUnlockedCyclops=false, bool forgeFoundLollipop=false, bool forgeBoughtWoodenSword=false, bool forgeBoughtIronAxe=false, bool forgeBoughtPolishedSilverSword=false, bool forgeBoughtLightweightBodyArmour=false, bool forgeBoughtScythe=false, bool fortressRoom1ChestFound=false, bool fortressRoom3ChestFound=false, bool fourthHouseFoundLollipopOnCupboard=false, bool gameDebug=false, bool gameInvertedColors=false, bool lighthousePuzzleDone=false, bool lollipopFarmPlant1LollipopButtonUnlocked=false, bool lollipopFarmPlant10LollipopsButtonUnlocked=false, bool lollipopFarmPlant100LollipopsButtonUnlocked=false, bool lollipopFarmPlant1000LollipopsButtonUnlocked=false, bool lollipopFarmIsProductionEachSecond=false, bool lollipopFarmConstructMillButtonUnlocked=false, bool lollipopFarmMillConstructed=false, bool lollipopFarmDigPondButtonUnlocked=false, bool lollipopFarmPondDug=false, bool lollipopFarmPondFeedingLolligators=false, bool lonelyHouseOpenBoxDone=false, bool lonelyHouseShakeBoxDone=false, bool lonelyHouseBreakLockDone=false, bool lonelyHouseKickBoxDone=false, bool lonelyHouseAskTheBoxToOpenItselfDone=false, bool lonelyHouseLureTheBoxWithACandyDone=false, bool lonelyHouseTakeTheBoxDone=false, bool mainMapDoneDesert=false, bool mainMapDoneBridge=false, bool mainMapDoneCaveEntrance=false, bool mainMapDonePier=false, bool mainMapDoneForest=false, bool mainMapDoneCastleEntrance=false, bool questPlayerSpellHealthPotionHasSpell=false, bool questPlayerSpellTurtlePotionHasSpell=false, bool questPlayerSpellAntiGravityPotionHasSpell=false, bool questPlayerSpellBerserkPotionHasSpell=false, bool questPlayerSpellCloningPotionHasSpell=false, bool questPlayerSpellPPotionHasSpell=false, bool questPlayerSpellXPotionHasSpell=false, bool secondHouseLollipop1Bought=false, bool secondHouseLollipop2Bought=false, bool secondHouseLollipop3Bought=false, bool secondHouseLeatherBootsBought=false, bool secondHouseChocolateBarBought=false, bool secondHouseMerchantHatBought=false, bool secondHouseTimeRingBought=false, bool sorceressHutTookLollipop=false, bool sorceressHutBoughtGrimoire=false, bool sorceressHutBoughtGrimoire2=false, bool sorceressHutBoughtCauldron=false, bool sorceressHutBoughtHat=false, bool statusBarUnlocked=true, bool statusBarUnlockedCfg=true, bool statusBarUnlockedSave=true, bool statusBarUnlockedMap=false, bool statusBarUnlockedInventory=false, bool statusBarUnlockedLollipopFarm=false, bool statusBarUnlockedCauldron=false, bool statusBarUnlockedInsideYourBox=false, bool statusBarUnlockedTheComputer=false, bool statusBarUnlockedTheArena=false, bool statusBarUnlockedHealthBar=false, bool SuperRPGReward1=false, bool SuperRPGReward2=false, bool SuperRPGReward3=false, bool SuperRPGReward4=false, bool SuperRPGUnlockedHardmode=false, bool TheCavePattern_ChocolateBarNowGotTheBar=false, bool TheCavePattern_TreasureMapSawMap=false, bool TheCavePattern_TreasureMapFoundTreasure=false, bool theHoleFirstChestFound=false, bool theHoleSecondChestFound=false, bool theHoleThirdChestFound=false, bool theHoleFourthChestFound=false, bool wishingWellFirstCandyThrown=false, bool wishingWellFirstLollipopThrown=false, bool wishingWellWeAreEnchanting=false, bool wishingWellWeArePainAuChocolating=false, bool gridItemPossessedMainMap=false, bool gridItemPossessedTimeRing=false, bool gridItemPossessedThirdHouseKey=false, bool gridItemPossessedBeginnersGrimoire=false, bool gridItemPossessedFeather=false, bool gridItemPossessedPogoStick=false, bool gridItemPossessedHeartPlug=false, bool gridItemPossessedAdvancedGrimoire=false, bool gridItemPossessedSponge=false, bool gridItemPossessedShellPowder=false, bool gridItemPossessedRedSharkFin=false, bool gridItemPossessedBlackMagicGrimoire=false, bool gridItemPossessedGreenSharkFin=false, bool gridItemPossessedPurpleSharkFin=false, bool gridItemPossessedHeartPendant=false, bool gridItemPossessedFortressKey=false, bool gridItemPossessedUnicornHorn=false, bool gridItemPossessedXinopherydonClaw=false, bool gridItemPossessedPitchfork=false, bool gridItemPossessedTalkingCandy=false, bool gridItemPossessedP=false, bool gridItemPossessedL=false, bool gridItemPossessedA=false, bool gridItemPossessedY=false, bool eqItemWeaponWoodenSword=false, bool eqItemWeaponIronAxe=false, bool eqItemWeaponPolishedSilverSword=false, bool eqItemWeaponTrollBludgeon=false, bool eqItemWeaponMonkeyWizardStaff=false, bool eqItemWeaponEnchantedMonkeyWizardStaff=false, bool eqItemWeaponTribalSpear=false, bool eqItemWeaponSummoningTribalSpear=false, bool eqItemWeaponGiantSpoon=false, bool eqItemWeaponScythe=false, bool eqItemWeaponGiantSpoonOfDoom=false, bool eqItemHatOctopusKingCrown=false, bool eqItemHatOctopusKingCrownWithJaspers=false, bool eqItemHatOctopusKingCrownWithObsidian=false, bool eqItemHatMerchantHat=false, bool eqItemHatSorceressHat=false, bool eqItemBodyArmoursLightweightBodyArmour=false, bool eqItemBodyArmoursKnightBodyArmour=false, bool eqItemBodyArmoursEnchantedKnightBodyArmour=false, bool eqItemGlovesLeatherGloves=false, bool eqItemGlovesRedEnchantedGloves=false, bool eqItemGlovesPinkEnchantedGloves=false, bool eqItemBootsLeatherBoots=false, bool eqItemBootsRocketBoots=false, bool eqItemBootsBootsOfIntrospection=false, number aTreeStep=0, number cauldronBookCurrentPage=0, number fourthHouseCupboardStep=0, number fourthHouseCarpetStep=0, number galacticWarsBestScore=0, number gameSecondsElapsedSinceLastLollipopsProduction=0, number gameCandiesAccumulated=40, number gameCandiesCurrent=0, number gameCandiesMax=30, number gameLollipopsAccumulated=0, number gameLollipopsCurrent=0, number gameLollipopsMax=0, number gameChocolateBarsAccumulated=0, number gameChocolateBarsCurrent=0, number gameChocolateBarsMax=0, number gamePainsAuChocolatAccumulated=0, number gamePainsAuChocolatCurrent=0, number gamePainsAuChocolatMax=0, number gameCandiesEatenAccumulated=0, number gameCandiesEatenCurrent=0, number gameCandiesEatenMax=0, number gameCandiesThrownAccumulated=0, number gameCandiesThrownCurrent=0, number gameCandiesThrownMax=0, number gameCandiesUsedToRequestFeaturesAccumulated=40, number gameCandiesUsedToRequestFeaturesCurrent=40, number gameCandiesUsedToRequestFeaturesMax=40, number gameCandiesInCauldronAccumulated=0, number gameCandiesInCauldronCurrent=0, number gameCandiesInCauldronMax=0, number gameLollipopsInCauldronAccumulated=0, number gameLollipopsInCauldronCurrent=0, number gameLollipopsInCauldronMax=0, number gameGiftPower=0, number gameGiftHealth=0, number gameGiftMagic=0, number lollipopFarmLollipopsPlanted=0, number lollipopFarmTimeSinceLastProduction=0, number lollipopFarmProduction=0, number lollipopFarmPondHowManyLolligators=0, number lollipopFarmPondConversionRate=0, number lollipopFarmPreviousCandiesProduction=1, number lollipopFarmCurrentCandiesProduction=1, number mainMapDefaultScroll=400, number playerHp=100, number questPlayerSpellHealthPotionQuantity=0, number questPlayerSpellAntiGravityPotionQuantity=0, number questPlayerSpellTurtlePotionQuantity=0, number questPlayerSpellBerserkPotionQuantity=0, number questPlayerSpellCloningPotionQuantity=0, number questPlayerSpellPPotionQuantity=0, number questPlayerSpellXPotionQuantity=0, number statusBarCornerStep=0, number wishingWellPreviousCandyWishPrice=1, number wishingWellCurrentCandyWishPrice=1, number wishingWellCurrentLollipopWishPrice=1, number wishingWellHowManyChocolateBarsThrown=0, number wishingWellHowManyPainsAuChocolatThrown=0, string gameLanguage=en, string gameWeaponSelected=inventorySpecialNothingWeapon, string gameHatSelected=inventorySpecialNothingHat, string gameBodyArmourSelected=inventorySpecialNothingBodyArmour, string gameGlovesSelected=inventorySpecialNothingGloves, string gameBootsSelected=inventorySpecialNothingBoots, string gameGameMode=normal";
    public static final String[] LANGUAGES = { "en", "br", "zh", "cz", "nl", "fr", "de", "hu", "id", "pl", "se" };
    public static final String[] GAME_MODES = { "normal", "hard" };

    private Map<GameKey, Variable> vars;

    public GameState() {
        this(INIT_GAME);
    }

    public GameState(String saveText) {
        this.vars = CandyGameSaveParser.parse(saveText);
    }

    public StringBinding getStringBinding() {
        return new StringBinding() {
            {
                for (GameKey key : vars.keySet()) {
                    bind(vars.get(key).stringValueProperty());
                }
            }

            @Override
            protected String computeValue() {
                return GameState.this.toString();
            }

        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (GameKey key : vars.keySet()) {
            sb.append(vars.get(key).toString()).append(',');
        }
        int lastCommaPosition = sb.lastIndexOf(",");
        if (lastCommaPosition >= 0) {
            sb.deleteCharAt(lastCommaPosition);
        }
        return sb.toString();
    }

    public void set(GameKey key, Variable v) {
        Variable old = vars.get(key);
        if (old != null) {
            old.updateTo(v);
        }
        vars.put(key, v);
    }

    public Variable getVariable(GameKey key) {
        return vars.get(key);
    }

    public BooleanVariable getBooleanVariable(GameKey key) {
        return (BooleanVariable) vars.get(key);
    }

    public NumberVariable getNumberVariable(GameKey key) {
        return (NumberVariable) vars.get(key);
    }

    public String getValue(GameKey key) {
        return vars.get(key).getAsString();
    }

    public Set<GameKey> keySet() {
        return vars.keySet();
    }

    public void incrementCandies(int amount) {
        incrementVariable(amount, GameKey.gameCandiesCurrent, GameKey.gameCandiesAccumulated, GameKey.gameCandiesMax);
    }

    public void incrementEatenCandies(int amount) {
        incrementVariable(amount, GameKey.gameCandiesEatenCurrent, GameKey.gameCandiesEatenAccumulated,
                GameKey.gameCandiesEatenMax, GameKey.gameCandiesAccumulated);
    }

    public void incrementThrownCandies(int amount) {
        incrementVariable(amount, GameKey.gameCandiesThrownCurrent, GameKey.gameCandiesThrownAccumulated,
                GameKey.gameCandiesThrownMax, GameKey.gameCandiesAccumulated);
    }

    public void incrementLollipops(int amount) {
        incrementVariable(amount, GameKey.gameLollipopsCurrent, GameKey.gameLollipopsAccumulated,
                GameKey.gameLollipopsMax);
    }

    public void incrementChocolateBars(int amount) {
        incrementVariable(amount, GameKey.gameChocolateBarsCurrent, GameKey.gameChocolateBarsAccumulated,
                GameKey.gameChocolateBarsMax);
    }

    public void incrementPainsAuChocolat(int amount) {
        incrementVariable(amount, GameKey.gamePainsAuChocolatCurrent, GameKey.gamePainsAuChocolatAccumulated,
                GameKey.gamePainsAuChocolatMax);
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
    private void incrementVariable(int amount, GameKey currentKey, GameKey accumulatorKey, GameKey maxKey,
            GameKey... parentAccumulators) {
        long newCurrent = getNumberVariable(currentKey).increment(amount);
        NumberVariable max = getNumberVariable(maxKey);
        if (newCurrent > max.getAsLong()) {
            max.set(newCurrent);
        }
        getNumberVariable(accumulatorKey).increment(amount);
        for (GameKey accKey : parentAccumulators) {
            getNumberVariable(accKey).increment(amount);
        }
    }
}
