package com.rasdrive.passwordmanager.database;

import java.io.*;
import java.util.ArrayList;

import com.rasdrive.passwordmanager.database.LogIn;

public class FileWriter {
    FileOutputStream fileOut;
    ObjectOutputStream outputStream;

    public FileWriter(String fileName) throws IOException {
        this.fileOut = new FileOutputStream(fileName);
        this.outputStream = new ObjectOutputStream(fileOut);
    }

    public FileWriter() throws IOException {
        this.fileOut = new FileOutputStream("data");
        this.outputStream = new ObjectOutputStream(fileOut);
    }

    public void WriteToFile(ArrayList<LogIn> logIns) throws IOException {
        for (LogIn log : logIns) {
            outputStream.writeObject(log);
        }
    }

    public static void main(String[] args) throws IOException {
        LogIn logIn1 = new LogIn("test", "test", "test");
        LogIn logIn2 = new LogIn("cum", "example", "example");
        ArrayList<LogIn> logIns = new ArrayList<>();
        logIns.add(logIn1);
        logIns.add(logIn2);

        FileWriter fileWriter = new FileWriter("test");
        fileWriter.WriteToFile(logIns);
    }
}
