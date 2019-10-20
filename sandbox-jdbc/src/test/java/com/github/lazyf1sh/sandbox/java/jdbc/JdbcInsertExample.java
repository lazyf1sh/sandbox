package com.github.lazyf1sh.sandbox.java.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class JdbcInsertExample
{
    private static final String SQL_INSERT = "INSERT INTO PARENTTABLE (PARENTTABLE_KEY, PARENTTABLE_NAME) VALUES (?,?)";

    @Test
    public void run()
    {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sandbox_hibernate?serverTimezone=UTC", "hibernate", "hibernate");
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT))
        {
            Random random = new Random();
            preparedStatement.setInt(1, random.nextInt());
            preparedStatement.setBigDecimal(2, new BigDecimal(799.88));

            int row = preparedStatement.executeUpdate();

            // rows affected
            Assert.assertEquals(1, row);
        }
        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
