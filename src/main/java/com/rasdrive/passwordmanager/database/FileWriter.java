package com.rasdrive.passwordmanager.database;

import java.io.*;
import java.util.ArrayList;

public class FileWriter {
    public static void writeToFile(String fileName, ArrayList<LogIn> logIns) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        for (LogIn log : logIns) {
            outputStream.writeObject(log);
        }
    }
}
