package com.patademacaco.ferramentas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// @autor Mariana

public class SenhaHashing {

    public static String doHashing(String senha) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(senha.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
