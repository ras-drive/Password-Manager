package com.rasdrive.passwordmanager.user;

import com.rasdrive.passwordmanager.encryption.PasswordEncryptor;

public class User {
    private final String userName;
    private final String userPassword;

    public User(String preHashedPassword) {
        this.userName = System.getProperty("user.name");
        this.userPassword = PasswordEncryptor.encrypt(preHashedPassword);
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public static void main(String[] args) {

    }
}
