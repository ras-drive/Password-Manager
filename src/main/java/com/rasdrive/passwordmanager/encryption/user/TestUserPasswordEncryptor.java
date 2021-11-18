package com.rasdrive.passwordmanager.encryption.user;

import org.mindrot.jbcrypt.BCrypt;

import static com.rasdrive.passwordmanager.encryption.user.UserPasswordEncryptor.encrypt;

public class TestUserPasswordEncryptor {

    protected static void timedEncrypt(int logRounds) {
        final long startTime = System.currentTimeMillis();

        BCrypt.hashpw("Password01", BCrypt.gensalt(logRounds));

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    protected static void testEncryption() {
        if (BCrypt.checkpw("Password01", encrypt("Password01"))) {
            System.out.println("encryption test passed!\n");
        } else {
            System.out.println("error, encryption test failed\n");
        }
    }

    protected static void testLogRounds() {
        try {
            for (int i = 4; i < 20; i++) {
                System.out.println(i + " rounds:");
                timedEncrypt(i);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid starting log round, please use a number >= 4");
        }
    }

    public static void main(String[] args) {
        testEncryption();
        testLogRounds();
    }
}
