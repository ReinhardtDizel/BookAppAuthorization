package com.example.bookappauthorization.Tools;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Crypto {
    static public String encrypt(String str) {
        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(utf8);
    }
    static public String decrypt(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str);
        return new String(decodedBytes);
    }
}
