package com.rasdrive.passwordmanager.encryption.user;

import org.mindrot.jbcrypt.BCrypt;



public class UserPasswordEncryptor {
    public static String encrypt(String preHashedPassword) {
        return BCrypt.hashpw(preHashedPassword, BCrypt.gensalt(10));
    }


}
