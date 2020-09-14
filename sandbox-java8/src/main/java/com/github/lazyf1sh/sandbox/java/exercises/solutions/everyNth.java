package com.github.lazyf1sh.sandbox.java.exercises.solutions;

public class everyNth {
    public static String everyNth(String str, int n) {
        String result = "";

        // Look at every nth char
        for (int i = 0; i < str.length(); i = i + n) {
            result = result + str.charAt(i);
        }
        return result;


    }

}
