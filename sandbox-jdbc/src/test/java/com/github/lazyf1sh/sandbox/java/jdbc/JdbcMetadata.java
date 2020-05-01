package com.github.lazyf1sh.sandbox.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class JdbcMetadata
{
    @Test
    public void run() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
        Statement stat = conn.createStatement();

        stat.execute("create table test(id int primary key, name varchar(255))");
        stat.execute("insert into test values(1, 'Hello')");

        ResultSet rs;
        rs = stat.executeQuery("select 'someValue', myTest.id myId, myTest.name myname from test myTest");
        while (rs.next())
        {
            Assert.assertEquals("Hello", rs.getString("name"));
        }

        ResultSetMetaData metaData = rs.getMetaData();
        for(int i = 1; i <= metaData.getColumnCount(); i++)
        {
            String alias = metaData.getColumnLabel(i);
            String columnClassName = metaData.getColumnClassName(i);
            int columnType = metaData.getColumnType(i);
            String columnName = metaData.getColumnName(i);
            String tableName = metaData.getTableName(i);
            int columnDisplaySize = metaData.getColumnDisplaySize(i);
            int precision = metaData.getPrecision(i);
            int scale = metaData.getScale(i);
            System.out.println("column: ");
        }


        stat.close();
        conn.close();
    }

}
