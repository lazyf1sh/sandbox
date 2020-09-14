package com.github.lazyf1sh.sandbox.patterns.listener.two;

import org.junit.Test;

/**
 * https://stackoverflow.com/questions/6270132/create-a-custom-event-in-java
 */
public class ObserverPatternExample
{
    @Test
    public void run()
    {
        Initiater initiater = new Initiater();
        Responder responder = new Responder();

        initiater.addListener(responder);

        initiater.sayHello();  // Prints "Hello!!!" and "Hello there..."
    }
}