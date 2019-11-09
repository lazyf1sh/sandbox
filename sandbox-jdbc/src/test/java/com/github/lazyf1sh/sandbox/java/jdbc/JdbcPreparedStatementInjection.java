package com.github.lazyf1sh.sandbox.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Reproduces 1+1 attack
 */
public class JdbcPreparedStatementInjection
{
    private static final String CREATE_PARENTTABLE  = "CREATE TABLE GEMS (GEM_KEY INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (GEM_KEY))";
    private static final String SQL_INSERT_TEMPLATE = "INSERT INTO GEMS (GEM_KEY, NAME) VALUES (?,?)";

    @BeforeClass
    public static void create_table_populate() throws SQLException
    {
        Connection conn = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:p6spy:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            statement = conn.createStatement();

            int lines = statement.executeUpdate(CREATE_PARENTTABLE);
            Assert.assertEquals(0, lines);

            preparedStatement = conn.prepareStatement(SQL_INSERT_TEMPLATE);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, "Diamond");
            preparedStatement.executeUpdate();

            preparedStatement = conn.prepareStatement(SQL_INSERT_TEMPLATE);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Opal");
            preparedStatement.executeUpdate();
        }
        finally
        {
            if (statement != null)
            {
                statement.close();
            }
            if (conn != null)
            {
                conn.close();
            }
            if (preparedStatement != null)
            {
                preparedStatement.close();
            }
        }
    }

    @Test
    public void injection_sucess() throws SQLException
    {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:p6spy:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            statement = conn.createStatement();

            //            String name_to_find = "Diamond";
            String name_to_find = "Diamond' OR 1+1 OR '";

            int count = 0;
            rs = statement.executeQuery("SELECT * FROM GEMS WHERE NAME like '" + name_to_find + "';");
            while (rs.next())
            {
                count++;
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(String.format("id: %s, name: %s", id, name));
            }

            Assert.assertEquals(2, count);

            statement.close();
            conn.close();
        }
        finally
        {
            if (statement != null)
            {
                statement.close();
            }
            if (conn != null)
            {
                conn.close();
            }
            if (rs != null)
            {
                rs.close();
            }
        }
    }

    /**
     * PreparedStatement are:<br/>
     * 1. Precompiled.<br/>
     * 2. Injection-safe.<br/>
     */
    @Test
    public void injection_prevented() throws SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:p6spy:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            preparedStatement = conn.prepareStatement("SELECT * FROM GEMS WHERE NAME like ?");

            //            String name_to_find = "Diamond";
            String name_to_find = "Diamond' OR 1+1 OR '";
            //            String name_to_find = "Diamond OR 1+1";
            preparedStatement.setString(1, name_to_find);

            rs = preparedStatement.executeQuery();
            int count = 0;
            while (rs.next())
            {
                count++;
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(String.format("id: %s, name: %s", id, name));
            }
            Assert.assertEquals(0, count);

            preparedStatement.close();
            conn.close();
        }
        finally
        {
            if (preparedStatement != null)
            {
                preparedStatement.close();
            }
            if (conn != null)
            {
                conn.close();
            }
            if (rs != null)
            {
                rs.close();
            }
        }
    }
}
