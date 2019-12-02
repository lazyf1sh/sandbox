package com.github.lazyf1sh.sandbox.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivan Kopylov
 */
@WebServlet(name = "UserServlet", urlPatterns = { "/testAnnotated" })
public class MyAnnotatedServlet extends HttpServlet
{
    private static final long serialVersionUID = -2517292163679509370L;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
        Util.print(req);
    }
}
