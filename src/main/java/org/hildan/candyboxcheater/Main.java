package org.hildan.candyboxcheater;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        URL url = null;
        try {
            url = getClass().getResource("/org.hildan.candyboxcheater/view/main.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org.hildan.candyboxcheater/application.css").toExternalForm());
            stage.setTitle("CandyBox 2 Game Cheater");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println( "Exception on FXMLLoader.load()" );
            System.err.println( "  * url: " + url );
            System.err.println( "  * " + e );
            System.err.println( "    ----------------------------------------\n" );
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
