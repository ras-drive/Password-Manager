package com.rasdrive.passwordmanager.database;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkdList;

public class FileWriter {
    public static void writeToFile(String fileName, ArrayList<LogIn> logIns) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        for (LogIn log : logIns) {
            outputStream.writeObject(log);
        }
    }

    public static void writeToFile(String fileName, LinkedList<Login> logins) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        for (LogIn log : logIns) {
            outputStream.writeObject(log);
        }
    }

    public static void writeToFile(String fileName, ObservableList<LogIn> logIns) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        for (LogIn log : logIns) {
            outputStream.writeObject(log);
        }
    }
}
