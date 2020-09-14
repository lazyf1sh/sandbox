package com.github.lazyf1sh.sandbox.java.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Ivan Kopylov
 */
public class Util
{
    public static String calculateFileSha256(byte[] bytes) throws NoSuchAlgorithmException, IOException
    {
        byte[] buffer = new byte[8192];
        int count;
        MessageDigest digest;
        digest = MessageDigest.getInstance("SHA-256");
        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bytes));
        while ((count = bis.read(buffer)) > 0)
        {
            digest.update(buffer, 0, count);
        }
        bis.close();

        byte[] hash = digest.digest();
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
