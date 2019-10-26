package com.github.lazyf1sh.sandbox.java.db.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class InmemoryExample
{
    private static final String DB_FILE_NAME = "myFileName001";

    /**
     * By default, when a connection to the database is closed, the database is closed as well. If we want the database to last for as long as the JVM is running, we can specify the property DB_CLOSE_DELAY=-1
     *
     * @throws SQLException
     */
    @Test
    public void inmemory() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
        Statement stat = conn.createStatement();

        stat.execute("create table test(id int primary key, name varchar(255))");
        stat.execute("insert into test values(1, 'Hello')");

        ResultSet rs;
        rs = stat.executeQuery("select * from test");
        while (rs.next())
        {
            Assert.assertEquals("Hello", rs.getString("name"));
        }
        stat.close();
        conn.close();
    }

    @Test
    public void file() throws SQLException
    {
        // delete the database named 'test' in the user home directory
        DeleteDbFiles.execute("~", DB_FILE_NAME, true);

        Connection conn = DriverManager.getConnection("jdbc:h2:~/" + DB_FILE_NAME);
        Statement stat = conn.createStatement();

        stat.execute("create table test(id int primary key, name varchar(255))");
        stat.execute("insert into test values(1, 'Hello')");
        ResultSet rs;
        rs = stat.executeQuery("select * from test");
        while (rs.next())
        {
            Assert.assertEquals("Hello", rs.getString("name"));
        }
        stat.close();
        conn.close();

    }

    @After
    public void run()
    {
        DeleteDbFiles.execute("~", DB_FILE_NAME, true);
    }

}
