package com.github.lazyf1sh.sandbox.java.tomcat;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;


public class MyCustomServletListener implements ServletContextListener
{
    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        System.out.println("web.xml - ServletContextListener destroyed");
    }

    //Run this before web application is started
    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        System.out.println("web.xml - ServletContextListener started");
    }
}
