package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.view.converters.LanguageConverter;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class MiscellaneousController extends BaseController {

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Key[] statusBarLevelKeys = { Key.statusBarUnlocked, Key.statusBarUnlockedCfg, Key.statusBarUnlockedSave,
				Key.statusBarUnlockedHealthBar, Key.statusBarUnlockedMap };
		String[] statusBarLevelValues = { "No status bar", "Status bar unlocked", "Config button unlocked",
				"Save button unlocked", "Health bar unlocked", "Map button unlocked" };
		bindBoxToProgressiveBooleans(statusBarLevel, statusBarLevelValues, statusBarLevelKeys);

		String[] statusBarCornerStepValues = { "+ + + +", "* * * *", "# # # #", "- - - -", "A B C D", "0 1 2 3",
				"@ @ @ @" };
		bindBoxToNumbers(statusBarCornerStep, Key.statusBarCornerStep, statusBarCornerStepValues);
		bind(gameLanguage, Key.gameLanguage, new LanguageConverter());
		bind(gameGameMode, Key.gameGameMode, Key.GAME_MODES);
		bind(gameDebug, Key.gameDebug);
		bind(gameInvertedColors, Key.gameInvertedColors);
	}
}
