package com.battleships;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("translations");
        System.out.println(bundle.getString("how_are_you"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Parent root = loader.load();
//        root.getStylesheets().add(getClass().getResource("style.css").toString());
        primaryStage.setTitle("battleships");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
