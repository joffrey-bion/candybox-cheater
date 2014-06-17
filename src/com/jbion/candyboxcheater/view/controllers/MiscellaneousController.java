package com.jbion.candyboxcheater.view.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.view.converters.LanguageConverter;
import com.jbion.candyboxcheater.view.converters.StatusBarCornerStepConverter;
import com.jbion.candyboxcheater.view.converters.StatusBarLevelConverter;

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
		bindBoxToMultipleBooleans(statusBarLevel, new StatusBarLevelConverter(), statusBarLevelKeys);
		bindBoxToNumbers(statusBarCornerStep, Key.statusBarCornerStep, new StatusBarCornerStepConverter());
		bind(gameLanguage, Key.gameLanguage, new LanguageConverter());
		bind(gameGameMode, Key.gameGameMode, Key.GAME_MODES);
		bind(gameDebug, Key.gameDebug);
		bind(gameInvertedColors, Key.gameInvertedColors);
	}
}
