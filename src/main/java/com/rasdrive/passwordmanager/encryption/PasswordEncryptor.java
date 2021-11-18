package com.rasdrive.passwordmanager.encryption;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptor {
    public static String encrypt(String preHashedPassword) {
        return BCrypt.hashpw(preHashedPassword, BCrypt.gensalt(10));
    }
}
