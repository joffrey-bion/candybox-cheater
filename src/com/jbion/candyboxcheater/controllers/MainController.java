package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.error.ErrorHandler;
import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.game.Key.Dependency;
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
		bindIdentities();
		bindStringDependencies();

		// save text binding
		rawText.setText(gameState.toString());
		gameState.getStringBinding().addListener((observable, oldValue, newValue) -> {
			rawText.setText(newValue);
		});
	}

	private void bindIdentities() {
		for (Key[] identity : Key.IDENTITIES) {
			for (int i = 0; i < identity.length - 1; i++) {
				final BooleanVariable var1 = gameState.getBooleanVariable(identity[i]);
				final BooleanVariable var2 = gameState.getBooleanVariable(identity[i + 1]);
				Bindings.bindBidirectional(var1.boolValueProperty(), var2.boolValueProperty());
			}
		}
	}

	private void bindStringDependencies() {
		for (Dependency dependency : Key.STRONG_DEPENDENCIES) {
			final BooleanVariable required = gameState.getBooleanVariable(dependency.getRequired());
			final BooleanVariable dependent = gameState.getBooleanVariable(dependency.getDependent());
			required.boolValueProperty().addListener((obs, oldValue, newValue) -> {
				if (!newValue) {
					// the required variable became false, so the dependent can't be true
					dependent.setBooleanValue(false);
				}
			});
			dependent.boolValueProperty().addListener((obs, oldValue, newValue) -> {
				if (newValue) {
					// the dependent variable became true, so the required has to be true
					required.setBooleanValue(true);
				}
			});
		}
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
			ErrorHandler.display("Parsing error at position " + e.getErrorOffset() + ": " + e.getMessage());
		}
	}
}
