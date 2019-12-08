package com.github.lazyf1sh.sandbox.servlets;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ivan Kopylov
 */
public class Util
{
    public static void print(HttpServletRequest req)
    {
        System.out.println(String.format("%s : %s", "ServletPath", req.getServletPath()));
        System.out.println(String.format("%s : %s", "getMethod", req.getMethod()));
        System.out.println("ParameterMap: ");
        req.getParameterMap().forEach((key, value) -> System.out.println(key + " " + value[0]));

        System.out.println("----------");
    }
}
