package com.rasdrive.passwordmanager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import com.rasdrive.passwordmanager.database.LogIn;
import com.rasdrive.passwordmanager.database.SQLConnection;

public class ApplicationMain extends Application {

    SQLConnection connection = new SQLConnection("passwords");
    public ApplicationMain() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("application-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Password Manager");


        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<LogIn> getLogins() throws IOException, SQLException {
        ObservableList<LogIn> logIns = FXCollections.observableArrayList();
        logIns.addAll(connection.readAllFromDB());
        return logIns;
    }

    public static void main(String[] args) {
        launch();
    }
}