package com.github.lazyf1sh.sandbox.java.tomcat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivan Kopylov
 */
@WebServlet(name = "UserServlet", urlPatterns = { "/myServletPath" })
public class MyServlet extends HttpServlet
{
    private static final long serialVersionUID = -3104703117388448520L;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
        String paramValue = req.getServletContext().getInitParameter("myCustomParamName");
        System.out.println(String.format("%s : %s", "myCustomParamName", paramValue));
    }
}
