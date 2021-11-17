package com.rasdrive.passwordmanager;

import com.rasdrive.passwordmanager.database.LogIn;
import com.rasdrive.passwordmanager.database.SQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class ApplicationController {
    public ApplicationController() throws IOException {
    }
    SQLConnection connection = new SQLConnection("passwords");
    @FXML private TableView<LogIn> table;
    @FXML private TableColumn<LogIn, String> websiteColumn;
    @FXML private TableColumn<LogIn, String> usernameColumn;
    @FXML private TableColumn<LogIn, String> passwordColumn;



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