package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.game.variables.BooleanVariable;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class MainController extends BaseController {

	@FXML
	private TextArea rawText;
	@FXML
	private Button reparseBtn;
	@FXML
	private Button clipboardBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (Key[] identity : Key.IDENTITIES) {
			for (int i = 0; i < identity.length - 1; i++) {
				BooleanVariable var1 = gameState.getBooleanVariable(identity[i]);
				BooleanVariable var2 = gameState.getBooleanVariable(identity[i + 1]);
				Bindings.bindBidirectional(var1.boolValueProperty(), var2.boolValueProperty());
			}
		}

		// save text binding
		rawText.setText(gameState.toString());
		gameState.getStringBinding().addListener((observable, oldValue, newValue) -> {
			rawText.setText(newValue);
		});
	}

	@FXML
	private void copyToClipboard(@SuppressWarnings("unused") ActionEvent event) {
		ClipboardContent content = new ClipboardContent();
		content.putString(rawText.getText());
		Clipboard.getSystemClipboard().setContent(content);
	}

	@FXML
	private void parseSaveText(@SuppressWarnings("unused") ActionEvent event) {
		String saveText = rawText.getText();
		try {
			gameState.updateTo(saveText);
			rawText.setText(gameState.toString());
		} catch (ParseException e) {
			System.err.println("Parsing error at position " + e.getErrorOffset() + ": " + e.getMessage());
		}
	}
}
