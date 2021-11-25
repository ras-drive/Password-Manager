package com.rasdrive.passwordmanager.database;

import java.io.*;
import java.util.LinkedList;


public class FileReader {
    public static LinkedList<LogIn> readFromFile(String fileName) throws IOException {
        FileInputStream fileStream = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileStream);

        LinkedList<LogIn> returnList = new LinkedList<>();
        LogIn logIn = null;

        while (true) {
            try {
                logIn = (LogIn) inputStream.readObject();
                if (logIn != null) {
                    returnList.add(logIn);
                } else {
                    break;
                }
            } catch (EOFException e) {
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return returnList;
    }
}
