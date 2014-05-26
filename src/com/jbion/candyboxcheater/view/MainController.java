package com.jbion.candyboxcheater.view;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.util.StringConverter;

import com.jbion.candyboxcheater.game.GameKey;
import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.converters.CarpetStepConverter;
import com.jbion.candyboxcheater.game.converters.CupboardStepConverter;
import com.jbion.candyboxcheater.game.converters.LanguageConverter;
import com.jbion.candyboxcheater.game.converters.StatusBarCornerStepConverter;

public class MainController implements Initializable {

    /*
     * STOCKS TAB
     */

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

    /*
     * VILLAGE TAB
     */

    @FXML
    private CheckBox forgeFoundLollipop;
    @FXML
    private CheckBox cellarDone;
    @FXML
    private CheckBox fourthHouseFoundLollipopOnCupboard;
    @FXML
    private ChoiceBox<String> fourthHouseCupboardStep;
    @FXML
    private ChoiceBox<String> fourthHouseCarpetStep;
       
    
    /*
     * MISCELLANEOUS TAB
     */

    @FXML
    private ChoiceBox<String> gameLanguage;
    @FXML
    private ChoiceBox<String> gameGameMode;
    @FXML
    private ChoiceBox<String> statusBarCornerStep;
    @FXML
    private CheckBox gameInvertedColors;
    @FXML
    private CheckBox gameDebug;

    /*
     * BOTTOM LAYOUT
     */

    @FXML
    private TextArea rawText;

    @FXML
    private Button reparseBtn;

    @FXML
    private Button clipboardBtn;
    @FXML
    private TableView<?> varTable;

    /*
     * CONTROLLER STATE
     */

    private GameState gameState;
    private Map<GameKey, ChoiceBox<String>> numberVarsChoiceBoxes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameState = new GameState();
        bindGameVariables();
    }

    private void bindGameVariables() {
        bind(gameCandiesCurrent, GameKey.gameCandiesCurrent);
        bind(gameCandiesAccumulated, GameKey.gameCandiesAccumulated);
        bind(gameCandiesMax, GameKey.gameCandiesMax);
        bind(gameCandiesEatenCurrent, GameKey.gameCandiesEatenCurrent);
        bind(gameCandiesEatenAccumulated, GameKey.gameCandiesEatenAccumulated);
        bind(gameCandiesEatenMax, GameKey.gameCandiesEatenMax);
        bind(gameCandiesThrownCurrent, GameKey.gameCandiesThrownCurrent);
        bind(gameCandiesThrownAccumulated, GameKey.gameCandiesThrownAccumulated);
        bind(gameCandiesThrownMax, GameKey.gameCandiesThrownMax);
        bind(gameLollipopsCurrent, GameKey.gameLollipopsCurrent);
        bind(gameLollipopsAccumulated, GameKey.gameLollipopsAccumulated);
        bind(gameLollipopsMax, GameKey.gameLollipopsMax);
        bind(gameChocolateBarsCurrent, GameKey.gameChocolateBarsCurrent);
        bind(gameChocolateBarsAccumulated, GameKey.gameChocolateBarsAccumulated);
        bind(gameChocolateBarsMax, GameKey.gameChocolateBarsMax);
        bind(gamePainsAuChocolatCurrent, GameKey.gamePainsAuChocolatCurrent);
        bind(gamePainsAuChocolatAccumulated, GameKey.gamePainsAuChocolatAccumulated);
        bind(gamePainsAuChocolatMax, GameKey.gamePainsAuChocolatMax);

        bind(forgeFoundLollipop, GameKey.forgeFoundLollipop);
        bind(fourthHouseFoundLollipopOnCupboard, GameKey.fourthHouseFoundLollipopOnCupboard);
        fourthHouseCupboardStep.setItems(FXCollections.observableArrayList(CupboardStepConverter.getNames()));
        bindBoxToNumbers(fourthHouseCupboardStep, GameKey.fourthHouseCupboardStep, new CupboardStepConverter());
        fourthHouseCarpetStep.setItems(FXCollections.observableArrayList(CarpetStepConverter.getNames()));
        bindBoxToNumbers(fourthHouseCarpetStep, GameKey.fourthHouseCarpetStep, new CarpetStepConverter());
        bind(cellarDone, GameKey.cellarDone);

        gameLanguage.setItems(FXCollections.observableArrayList(LanguageConverter.getNames()));
        bindBoxToStrings(gameLanguage, GameKey.gameLanguage, new LanguageConverter());
        ObservableList<String> list = FXCollections.observableArrayList(StatusBarCornerStepConverter.getNames());
        System.out.println(list);
        statusBarCornerStep.setItems(list);
        bindBoxToNumbers(statusBarCornerStep, GameKey.statusBarCornerStep, new StatusBarCornerStepConverter());
        gameGameMode.setItems(FXCollections.observableArrayList(GameState.GAME_MODES));
        bind(gameGameMode, GameKey.gameGameMode);
        bind(gameDebug, GameKey.gameDebug);
        bind(gameInvertedColors, GameKey.gameInvertedColors);

        rawText.textProperty().bind(gameState.getStringBinding());
    }

    private void bind(Label label, GameKey key) {
        label.textProperty().bind(gameState.getVariable(key).stringValueProperty());
    }

    private void bind(CheckBox checkBox, GameKey key) {
        checkBox.selectedProperty().bindBidirectional(gameState.getBooleanVariable(key).boolValueProperty());
    }

    private void bind(ChoiceBox<String> choiceBox, GameKey key) {
        choiceBox.valueProperty().bindBidirectional(gameState.getVariable(key).stringValueProperty());
    }

    private void bindBoxToStrings(ChoiceBox<String> choiceBox, GameKey key, StringConverter<String> converter) {
        Bindings.bindBidirectional(choiceBox.valueProperty(), gameState.getVariable(key).stringValueProperty(), converter);
    }

    private void bindBoxToNumbers(ChoiceBox<String> choiceBox, GameKey key, StringConverter<Number> converter) {
        Property<String> strProp = choiceBox.valueProperty();
        Property<Number> longProp = gameState.getNumberVariable(key).longValueProperty();
        Bindings.bindBidirectional(strProp, longProp, converter);
    }

    @FXML
    private void addCandies(ActionEvent event) {
        try {
            gameState.incrementCandies(Integer.parseInt(candiesAddField.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Input error");
        }
    }

    @FXML
    private void addEatenCandies(ActionEvent event) {
        try {
            gameState.incrementEatenCandies(Integer.parseInt(eatenCandiesAddField.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Input error");
        }
    }

    @FXML
    private void addThrownCandies(ActionEvent event) {
        try {
            gameState.incrementThrownCandies(Integer.parseInt(thrownCandiesAddField.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Input error");
        }
    }

    @FXML
    private void addLollipops(ActionEvent event) {
        try {
            gameState.incrementLollipops(Integer.parseInt(lollipopsAddField.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Input error");
        }
    }

    @FXML
    private void addChocolateBars(ActionEvent event) {
        try {
            gameState.incrementChocolateBars(Integer.parseInt(chocolateBarsAddField.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Input error");
        }
    }

    @FXML
    private void addPainsAuChocolat(ActionEvent event) {
        try {
            gameState.incrementPainsAuChocolat(Integer.parseInt(painsAuChocolatAddField.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Input error");
        }
    }

    @FXML
    private void copyToClipboard(ActionEvent event) {
        ClipboardContent content = new ClipboardContent();
        content.putString(rawText.getText());
        Clipboard.getSystemClipboard().setContent(content);
    }

    @FXML
    private void parseSaveText(ActionEvent event) {
        String saveText = rawText.getText();
        gameState = new GameState(saveText);
        bindGameVariables();
    }
}
