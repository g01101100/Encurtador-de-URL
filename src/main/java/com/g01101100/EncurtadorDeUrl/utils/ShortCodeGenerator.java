package com.g01101100.EncurtadorDeUrl.utils;

import java.security.SecureRandom;

public final class ShortCodeGenerator {

    private static final String BASE62 = 
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int DEFAULT_LENGTH = 6;

    private static final SecureRandom random = new SecureRandom();

    private ShortCodeGenerator() {
        // impede instanciação
    }

    public static String generate() {
        StringBuilder sb = new StringBuilder(DEFAULT_LENGTH);

        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            sb.append(BASE62.charAt(random.nextInt(BASE62.length())));
        }

        return sb.toString();
    }
}
