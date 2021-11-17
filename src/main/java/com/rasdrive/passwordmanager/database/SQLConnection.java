package com.rasdrive.passwordmanager.database;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {
    private static Connection connection;
    private static ResultSet resultSet;
    private static Statement statement;

    private static String url;

    public SQLConnection() throws IOException {
        connection = null;
        resultSet = null;
        statement = null;

        String currentPath = new java.io.File(".").getCanonicalPath();
        url = "jdbc:sqlite" + currentPath + "/sqlite/passwords.sqlite";
    }

    public SQLConnection(String databaseName) throws IOException {
        connection = null;
        resultSet = null;
        statement = null;

        String currentPath = new java.io.File(".").getCanonicalPath();
        url = "jdbc:sqlite:" + currentPath + "/sqlite/" + databaseName + ".sqlite";
    }

    public String getUrl() {
        return url;
    }

    public static void connectToDB() {
        try {
            connection = DriverManager.getConnection(url);

            if (connection != null) {
                System.out.println("Connection established\n");
            }
            assert connection != null;
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred");
        }
    }

    public void closeDB() {
        try {
            connection.close();
            System.out.println("Successfully closed database");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error closing database");
        }
    }

    public void createTable() {
        if (connection == null) {
            connectToDB();
        }
        try {
            statement.executeUpdate("CREATE TABLE passwords(website text, username text, password text)");
        } catch (SQLException e) {
            System.out.println("Table passwords already exists");
        }
    }

    public void insertIntoTable(LogIn logIn) throws SQLException {
        if (connection == null) {
            connectToDB();
        }
        statement.executeUpdate("INSERT INTO passwords VALUES(\"" +  logIn.getWebsite() + "\", \"" +
                                                                logIn.getUsername() + "\", \"" +
                                                                logIn.getPassword() + "\")"
                                                            );
    }

    public void dropTableFromDB() throws SQLException {
        if (connection == null) {
            connectToDB();
        }
        statement.executeUpdate("DROP TABLE passwords");
    }

    public ArrayList<LogIn> readAllFromDB() throws SQLException {
        ArrayList<LogIn> returnList = new ArrayList<>();
        if (connection == null) {
            connectToDB();
        }
        resultSet = statement.executeQuery("SELECT * FROM passwords");
        while (resultSet.next()) {
            returnList.add(new LogIn(resultSet.getString("website"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"))
            );
        }
        return returnList;
    }

}
