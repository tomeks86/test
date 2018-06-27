package com.battleships;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Settings {
    @FXML
    ChoiceBox<String> languageSelector;

    public void initialize() {
        languageSelector.setItems(FXCollections.observableArrayList("en", "pl"));
        languageSelector.getSelectionModel().selectFirst();
        System.out.println("started...");
    }
}
