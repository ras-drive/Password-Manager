package com.rasdrive.passwordmanager.database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestSQLConnection {
    public static void testDB() throws SQLException, IOException {
        SQLConnection connection = new SQLConnection("test");
        System.out.println(connection.getUrl());
        LogIn logIn = new LogIn("Amazon", "example@domain.com", "Password01");
        LogIn logIn1 = new LogIn("hbo", "test@domain.com", "Password02");
        LogIn logIn2 = new LogIn("netflix", "domain@example.com", "Password03");
        SQLConnection.connectToDB();
        connection.createTable();
        connection.insertIntoTable(logIn);
        connection.insertIntoTable(logIn1);
        connection.insertIntoTable(logIn2);
        ArrayList<LogIn> list = SQLConnection.readAllFromDB();
        for (LogIn log : list) {
            System.out.println(log.getWebsite() + " " +
                    log.getUserName() + " " +
                    log.getPassword() + " ");
        }
        connection.dropTableFromDB();
        System.out.println("Test passed!");
    }

    public static void main(String[] args) throws SQLException, IOException {
        testDB();
    }
}
