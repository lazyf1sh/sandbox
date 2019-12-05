package com.github.lazyf1sh.sandbox.java.jcl.lang.util;

import java.util.Scanner;

public class ScannerExample
{
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(str1.replace("a","b"));
        System.out.println(str2.replace("a","b"));
    }
}
