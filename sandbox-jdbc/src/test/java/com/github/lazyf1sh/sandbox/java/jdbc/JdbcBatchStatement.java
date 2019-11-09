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
public class JdbcBatchStatement
{
    private static final String CREATE_PARENTTABLE  = "CREATE TABLE GEMS (GEM_KEY INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (GEM_KEY))";
    private static final String SQL_INSERT_TEMPLATE = "";

    @BeforeClass
    public static void create_table_populate() throws SQLException
    {
        Connection conn = null;
        Statement statement = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            statement = conn.createStatement();

            int lines = statement.executeUpdate(CREATE_PARENTTABLE);
            Assert.assertEquals(0, lines);
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
        }
    }

    @Test
    public void run() throws SQLException
    {
        Connection conn = null;
        Statement statement = null;

        try
        {
            conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            statement = conn.createStatement();

            statement.addBatch("INSERT INTO GEMS (GEM_KEY, NAME) VALUES (1000, 'Citrine')");
            statement.addBatch("INSERT INTO GEMS (GEM_KEY, NAME) VALUES (1001, 'Quartz')");
            statement.addBatch("INSERT INTO GEMS (GEM_KEY, NAME) VALUES (1002, 'Amber')");

            int[] recordsAffected = statement.executeBatch();


            Assert.assertEquals(1, recordsAffected[0]);
            Assert.assertEquals(2, recordsAffected[1]);
            Assert.assertEquals(3, recordsAffected[2]);

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
        }
    }


}
