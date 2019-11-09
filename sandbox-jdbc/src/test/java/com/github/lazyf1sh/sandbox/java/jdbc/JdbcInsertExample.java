package com.github.lazyf1sh.sandbox.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JdbcInsertExample
{
    private static final String CREATE_PARENTTABLE = "CREATE TABLE PARENTTABLE (PARENTTABLE_KEY INTEGER NOT NULL, PARENTTABLE_NAME VARCHAR(255), PRIMARY KEY (PARENTTABLE_KEY))";
    private static final String SQL_INSERT         = "INSERT INTO PARENTTABLE (PARENTTABLE_KEY, PARENTTABLE_NAME) VALUES (?,?)";

    @BeforeClass
    public static void create_table() throws SQLException
    {
        Connection conn = null;
        Statement preparedStatement = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            preparedStatement = conn.createStatement();

            int i = preparedStatement.executeUpdate(CREATE_PARENTTABLE);
            Assert.assertEquals(0, i);
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
        }
    }

    /**
     * PreparedStatement are:<br/>
     * 1. Precompiled.<br/>
     * 2. Injection-safe.<br/>
     */
    @Test
    public void run() throws SQLException
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try
        {
            conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            Random random = new Random();
            preparedStatement.setInt(1, random.nextInt());
            preparedStatement.setString(2, "string value");

            int row = preparedStatement.executeUpdate();

            // rows affected
            Assert.assertEquals(1, row);

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
        }
    }
}
