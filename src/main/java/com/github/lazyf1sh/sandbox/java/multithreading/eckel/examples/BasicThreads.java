package com.github.lazyf1sh.sandbox.java.multithreading.eckel.examples;

/**
 * @author Ivan Kopylov
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
