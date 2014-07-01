package com.jbion.candyboxcheater.controllers;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jbion.candyboxcheater.error.StatusHandler;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.paint.Color;

public class MainController extends AbstractBaseController {
	
	@FXML
	private EquipmentController equipmentController;
	@FXML
	private InventoryController inventoryController;
	@FXML
	private MiscellaneousController miscellaneousController;
	@FXML
	private ProgressController progressController;
	@FXML
	private StocksController stocksController;

	@FXML
	private Label log;
	@FXML
	private TextArea rawText;
	@FXML
	private Button reparseBtn;
	@FXML
	private Button clipboardBtn;
	
	private ChangeListener<Boolean> errorStatusListener = (obs, old, newValue) -> {
		if (newValue) {
			// the text is an error
			log.setTextFill(Color.web("#CC0000"));
		} else {
			// the text is not an error
			log.setTextFill(Color.BLACK);
		}
	};

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		statusHandler = new StatusHandler(errorStatusListener, log.textProperty());
		equipmentController.setStatusHandler(statusHandler);
		inventoryController.setStatusHandler(statusHandler);
		miscellaneousController.setStatusHandler(statusHandler);
		progressController.setStatusHandler(statusHandler);
		stocksController.setStatusHandler(statusHandler);
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
			statusHandler.message("Textual save parsed successfully, you can safely edit it!");
		} catch (ParseException e) {
			statusHandler.error("Parsing error (position " + e.getErrorOffset() + "): " + e.getMessage());
		}
	}
}
