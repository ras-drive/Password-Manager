package com.rasdrive.passwordmanager.database;

import java.io.*;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<LogIn> readFromFile(String fileName) throws IOException {
        FileInputStream fileStream = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileStream);

        ArrayList<LogIn> returnList = new ArrayList<>();
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
