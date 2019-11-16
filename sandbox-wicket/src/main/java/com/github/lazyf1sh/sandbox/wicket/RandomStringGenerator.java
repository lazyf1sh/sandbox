package com.github.lazyf1sh.sandbox.wicket;

import java.util.Random;

import org.apache.wicket.markup.html.WebPage;

public class RandomStringGenerator extends WebPage
{
    public static String getNext()
    {
        return String.valueOf(new Random().nextInt(5000));
    }
}