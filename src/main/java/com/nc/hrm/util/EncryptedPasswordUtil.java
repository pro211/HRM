package com.nc.hrm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtil {

    /**
     * Encrypt Password with BCryptPasswordEncoder
     */
    private static String encryptedPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        System.out.println("Encrypted Password: " + encryptedPassword(password));
    }
}
