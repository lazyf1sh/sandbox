package com.github.lazyf1sh.sandbox.java.exercises.solutions;

/**
 * Given a string, return a string made of the first 2 chars (if present), however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
 */
public class startOz {

    /**
     * @param str
     * @return null if input is incorrect
     */
    public String startOz(String str) {
        if (str.length() == 0) {
            System.out.println("input is incorrect");
            return "";
        }
        if (str.length() == 1) {
            if (str.equals("o")) {
                System.out.println("found required char");
                return str;
            }
        }
        if (str.length() > 1) {
            if (str.charAt(0) == 'o' & str.charAt(1) == 'z') {
                return "oz";
            }
            if (str.charAt(1) == 'z') {
                return "z";
            }
            if (str.charAt(0) == 'o') {
                return "o";
            }
        }
        return "";
    }

}
