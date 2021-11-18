package com.rasdrive.passwordmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

import com.rasdrive.passwordmanager.database.LogIn;
import com.rasdrive.passwordmanager.database.SQLConnection;
import javafx.scene.layout.HBox;
import org.controlsfx.control.PopOver;

public class ApplicationController {
    public ApplicationController() throws IOException {
    }
    private final SQLConnection connection = new SQLConnection("passwords");
    @FXML private TableView<LogIn> table;
    @FXML private TableColumn<LogIn, String> websiteColumn;
    @FXML private TableColumn<LogIn, String> usernameColumn;
    @FXML private TableColumn<LogIn, String> passwordColumn;

    @FXML private TextField websiteField;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    @FXML private Button addLoginButton;

    public void addLoginButtonPress(ActionEvent event) throws IOException {
        if (!websiteField.getText().trim().isEmpty() &&
            !usernameField.getText().trim().isEmpty() &&
            !passwordField.getText().trim().isEmpty()) {
            LogIn newLogin = new LogIn(websiteField.getText(), usernameField.getText(), passwordField.getText());
            System.out.println(newLogin.getWebsite() + " " + newLogin.getUsername() + " " + newLogin.getPassword());
        } else {
            Label label = new Label("You must fill out all of the fields before hitting \"Add Login\"");
            label.setWrapText(true);

            PopOver popOver = new PopOver(label);
            popOver.setTitle("Error");
            popOver.show(addLoginButton.getParent());
        }
    }

    public ObservableList<LogIn> getLogins() throws IOException, SQLException {
        ObservableList<LogIn> logIns = FXCollections.observableArrayList();
        logIns.addAll(connection.readAllFromDB());
        return logIns;
    }

    public void initialize() throws SQLException, IOException {
        websiteColumn.setCellValueFactory(new PropertyValueFactory<>("website"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        table.setItems(getLogins());
    }
}