package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.error.StatusHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class MainController extends BaseController {

	@FXML
	private Label log;
	@FXML
	private TextArea rawText;
	@FXML
	private Button reparseBtn;
	@FXML
	private Button clipboardBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// save text binding
		rawText.setText(gameState.toString());
		gameState.getStateBinding().addListener((observable, oldValue, newValue) -> {
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
			StatusHandler.message("Textual save parsed successfully, you can safely edit it!");
		} catch (ParseException e) {
			StatusHandler.error("Parsing error at position " + e.getErrorOffset() + ": " + e.getMessage());
		}
	}
}
