package com.github.lazyf1sh.sandbox.java.tomcat;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Ivan Kopylov
 */
public class MyCustomFilter implements Filter
{
    @Override
    public void init(final FilterConfig filterConfig)
    {
//        System.out.println("1");
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException
    {
//        System.out.println("2");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {
//        System.out.println("3");
    }
}
