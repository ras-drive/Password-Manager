package com.rasdrive.passwordmanager.database;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

// Writes 20MBs of data to a test file then deletes it
public class TestDataBase {
    protected static void testDataBase() throws IOException {
        LogIn logIn;
        LinkedList<LogIn> logIns = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            logIn = new LogIn("test", "test", "test");
            logIns.add(logIn);
        }

        try {
            FileWriter.writeToFile("test", logIns);
        } catch (IOException e) {
            System.out.println("Write test failed!");
            return;
        }

        System.out.println("Write test passed!");

        LinkedList<LogIn> newLogIns = FileReader.readFromFile("test");
        for (LogIn log : newLogIns) {
            if (log == null) {
                System.out.println("Read test Failed!");
                return;
            }
        }

        System.out.println("Read test passed!");

        File file = new File("test");
        //noinspection ResultOfMethodCallIgnored
        file.delete();
    }

    public static void main(String[] args) throws IOException {
        testDataBase();
    }
}
