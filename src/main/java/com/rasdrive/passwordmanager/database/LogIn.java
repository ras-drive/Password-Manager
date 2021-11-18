package com.rasdrive.passwordmanager.database;

import java.io.*;

public class LogIn implements Serializable {

    private String website;
    private String password;
    private String username;

    public LogIn(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
