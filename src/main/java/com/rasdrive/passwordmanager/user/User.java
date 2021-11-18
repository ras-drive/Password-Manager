package com.rasdrive.passwordmanager.user;

import com.rasdrive.passwordmanager.encryption.user.UserPasswordEncryptor;

//TODO: Make sure to test this class
public class User {
    private final String userName;
    private final String userPassword;

    public User(String unHashedPassword) {
        this.userName = System.getProperty("user.name");
        // TODO: Make sure to warn the user that this will not be recoverable
        this.userPassword = UserPasswordEncryptor.encrypt(unHashedPassword);
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

}
