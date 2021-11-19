package com.rasdrive.passwordmanager;

import com.rasdrive.passwordmanager.database.FileReader;
import com.rasdrive.passwordmanager.database.FileWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.rasdrive.passwordmanager.database.LogIn;
import org.controlsfx.control.PopOver;

public class ApplicationController {

    public ApplicationController() {
    }
    @FXML private Button deleteButton;
    @FXML private TableView<LogIn> table;
    @FXML private TableColumn<LogIn, String> websiteColumn;
    @FXML private TableColumn<LogIn, String> usernameColumn;
    @FXML private TableColumn<LogIn, String> passwordColumn;

    @FXML private TextField websiteField;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    @FXML private Button addLoginButton;

    public void addLoginButtonPress() throws IOException {
        if (!websiteField.getText().trim().isEmpty() &&
            !usernameField.getText().trim().isEmpty() &&
            !passwordField.getText().trim().isEmpty()) {
            LogIn newLogin = new LogIn(websiteField.getText(), usernameField.getText(), passwordField.getText());
            ArrayList<LogIn> logIns = FileReader.readFromFile("data");
            logIns.add(newLogin);
            FileWriter.writeToFile("data", logIns);
            initialize();
            websiteField.clear();
            usernameField.clear();
            passwordField.clear();
        } else {
            Label label = new Label("You must fill out all of the fields before hitting \"Add Login\"");
            label.setWrapText(true);

            PopOver popOver = new PopOver(label);
            popOver.setTitle("Error");
            popOver.show(addLoginButton.getParent());
        }
    }

    public void deleteLoginButtonPress() throws IOException {
        TableView.TableViewSelectionModel<LogIn> selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        ObservableList<LogIn> selectedItems = selectionModel.getSelectedItems();

        ObservableList<LogIn> logIns = getLogins();
        for (int i = 0; i < logIns.size(); i++) {
            if (Objects.equals(selectedItems.get(0).getWebsite(), logIns.get(i).getWebsite()) &&
                    Objects.equals(selectedItems.get(0).getUsername(), logIns.get(i).getUsername()) &&
                    Objects.equals(selectedItems.get(0).getPassword(), logIns.get(i).getPassword())) {
                logIns.remove(i);
                break;
            }
        }
        FileWriter.writeToFile("data", logIns);
        initialize();
        selectionModel.clearSelection();
    }

    public ObservableList<LogIn> getLogins() throws IOException {
        ObservableList<LogIn> logIns = FXCollections.observableArrayList();
        logIns.addAll(FileReader.readFromFile("data"));
        return logIns;
    }

    public void initialize() throws IOException {
        websiteColumn.setCellValueFactory(new PropertyValueFactory<>("website"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        table.setItems(getLogins());
    }
}