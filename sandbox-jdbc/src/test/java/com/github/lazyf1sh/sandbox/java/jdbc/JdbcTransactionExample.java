package com.github.lazyf1sh.sandbox.java.jdbc;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class JdbcTransactionExample
{
    private static final String CREATE_PARENTTABLE = "CREATE TABLE GEMS (GEM_KEY INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (GEM_KEY))";
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
        } finally
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
    public void transaction_run() throws SQLException
    {
        Connection conn = null;
        Statement statement = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:p6spy:h2:mem:myDb;DB_CLOSE_DELAY=-1");
            conn.setAutoCommit(false);
            statement = conn.createStatement();

            String update = "UPDATE GEMS SET NAME = 'Agate' WHERE GEM_KEY = 0";
            statement.executeUpdate(update);
            statement.executeUpdate(update);

            conn.commit();
            statement.close();
            conn.close();

        } finally
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
