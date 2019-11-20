package com.github.lazyf1sh.sandbox.patterns.listener.two;

import java.util.ArrayList;
import java.util.List;

// Someone who says "Hello"
class Initiater {
    private List<HelloListener> listeners = new ArrayList<>();

    public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners)
            hl.someoneSaidHello();
    }
}