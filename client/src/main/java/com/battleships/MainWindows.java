package com.battleships;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainWindows {
    private Socket socket;
    private PrintWriter socketWriter;
    private Scanner socketReader;

    @FXML
    VBox vBox;

    public void initialize() {
        try {
            socket = new Socket("localhost", 50000);
            socketWriter = new PrintWriter(socket.getOutputStream());
            socketReader = new Scanner(socket.getInputStream());

            for (int i = 0; i < 10; i++) {
                HBox hBox = new HBox();
                vBox.getChildren().add(hBox);
                for (int j = 0; j < 10; j++) {
                    Button btn = new Button();
                    btn.setPrefWidth(30);
                    btn.setPrefHeight(30);
                    btn.idProperty().setValue(i + " " + j);
                    btn.onActionProperty().setValue(event -> {
                        Button btn1 = (Button) event.getSource();
                        socketWriter.println(btn1.getId());
                        socketWriter.flush();
                    });
                    hBox.getChildren().add(btn);
                }
            }
        } catch (IOException e) {
            System.out.println("unable to connect to server; exiting");
            Platform.exit();
        }
    }

    public void shutdown() {
        try {
            System.out.println("closing...");
            socketWriter.println("quit");
            socketWriter.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
