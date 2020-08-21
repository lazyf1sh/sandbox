package com.github.lazyf1sh.sandbox.wicket.util;

import org.apache.wicket.markup.html.WebPage;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStringGenerator extends WebPage
{
    public static String getNext()
    {
        return String.valueOf(ThreadLocalRandom.current().nextInt(5000));
    }
}