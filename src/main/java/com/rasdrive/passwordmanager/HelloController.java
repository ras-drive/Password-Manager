package com.rasdrive.passwordmanager;

import com.rasdrive.passwordmanager.database.TestSQLConnection;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {

    @FXML
    protected void onHelloButtonClick() throws IOException, SQLException {
        TestSQLConnection.testDB();
        // welcomeText.setText("Welcome to JavaFX Application!");
    }
}