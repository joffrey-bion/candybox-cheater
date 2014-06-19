package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.LongConsumer;

import com.jbion.candyboxcheater.game.Key;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StocksController extends BaseController {

	@FXML
	private Label gameCandiesCurrent;
	@FXML
	private Label gameCandiesAccumulated;
	@FXML
	private Label gameCandiesMax;
	@FXML
	private Label gameCandiesEatenCurrent;
	@FXML
	private Label gameCandiesEatenAccumulated;
	@FXML
	private Label gameCandiesEatenMax;
	@FXML
	private Label gameCandiesThrownCurrent;
	@FXML
	private Label gameCandiesThrownAccumulated;
	@FXML
	private Label gameCandiesThrownMax;
	@FXML
	private Label gameLollipopsCurrent;
	@FXML
	private Label gameLollipopsAccumulated;
	@FXML
	private Label gameLollipopsMax;
	@FXML
	private Label gameChocolateBarsCurrent;
	@FXML
	private Label gameChocolateBarsAccumulated;
	@FXML
	private Label gameChocolateBarsMax;
	@FXML
	private Label gamePainsAuChocolatCurrent;
	@FXML
	private Label gamePainsAuChocolatAccumulated;
	@FXML
	private Label gamePainsAuChocolatMax;

	@FXML
	private TextField candiesAddField;
	@FXML
	private TextField eatenCandiesAddField;
	@FXML
	private TextField thrownCandiesAddField;
	@FXML
	private TextField lollipopsAddField;
	@FXML
	private TextField chocolateBarsAddField;
	@FXML
	private TextField painsAuChocolatAddField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bind(gameCandiesCurrent, Key.gameCandiesCurrent);
		bind(gameCandiesAccumulated, Key.gameCandiesAccumulated);
		bind(gameCandiesMax, Key.gameCandiesMax);
		bind(gameCandiesEatenCurrent, Key.gameCandiesEatenCurrent);
		bind(gameCandiesEatenAccumulated, Key.gameCandiesEatenAccumulated);
		bind(gameCandiesEatenMax, Key.gameCandiesEatenMax);
		bind(gameCandiesThrownCurrent, Key.gameCandiesThrownCurrent);
		bind(gameCandiesThrownAccumulated, Key.gameCandiesThrownAccumulated);
		bind(gameCandiesThrownMax, Key.gameCandiesThrownMax);
		bind(gameLollipopsCurrent, Key.gameLollipopsCurrent);
		bind(gameLollipopsAccumulated, Key.gameLollipopsAccumulated);
		bind(gameLollipopsMax, Key.gameLollipopsMax);
		bind(gameChocolateBarsCurrent, Key.gameChocolateBarsCurrent);
		bind(gameChocolateBarsAccumulated, Key.gameChocolateBarsAccumulated);
		bind(gameChocolateBarsMax, Key.gameChocolateBarsMax);
		bind(gamePainsAuChocolatCurrent, Key.gamePainsAuChocolatCurrent);
		bind(gamePainsAuChocolatAccumulated, Key.gamePainsAuChocolatAccumulated);
		bind(gamePainsAuChocolatMax, Key.gamePainsAuChocolatMax);
	}

	@FXML
	private void addCandies(@SuppressWarnings("unused") ActionEvent event) {
		consumeValue(gameState::incrementCandies, candiesAddField);
	}

	@FXML
	private void addEatenCandies(@SuppressWarnings("unused") ActionEvent event) {
		consumeValue(gameState::incrementEatenCandies, eatenCandiesAddField);
	}

	@FXML
	private void addThrownCandies(@SuppressWarnings("unused") ActionEvent event) {
		consumeValue(gameState::incrementThrownCandies, thrownCandiesAddField);
	}

	@FXML
	private void addLollipops(@SuppressWarnings("unused") ActionEvent event) {
		consumeValue(gameState::incrementLollipops, lollipopsAddField);
	}

	@FXML
	private void addChocolateBars(@SuppressWarnings("unused") ActionEvent event) {
		consumeValue(gameState::incrementChocolateBars, chocolateBarsAddField);
	}

	@FXML
	private void addPainsAuChocolat(@SuppressWarnings("unused") ActionEvent event) {
		consumeValue(gameState::incrementPainsAuChocolat, painsAuChocolatAddField);
	}

	private static void consumeValue(LongConsumer consumer, TextField intField) {
		try {
			consumer.accept(Long.parseLong(intField.getText()));
		} catch (NumberFormatException e) {
			System.err.println("Input error");
		}
	}
}
