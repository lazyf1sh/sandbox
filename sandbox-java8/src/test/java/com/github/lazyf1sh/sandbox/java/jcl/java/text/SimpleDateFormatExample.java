package com.github.lazyf1sh.sandbox.java.jcl.java.text;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ivan Kopylov
 */
public class SimpleDateFormatExample
{
    @Test
    public void main() throws ParseException
    {
        String strDT = "2017-02-14T00:02:18".replaceAll("Z$", "+0000");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = format.parse(strDT);

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String result = format2.format(date);

        Assert.assertEquals("2017-02-14", result);
    }

    @Test
    public void happyPath01() throws ParseException
    {
        String input = "23.12.2020";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date result = format.parse(input);

        Assert.assertEquals(23, result.getDate());
        Assert.assertEquals(11, result.getMonth());
    }

    @Test
    public void happyPath02() throws ParseException
    {
        String input = "23:59";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date result = format.parse(input);

        Assert.assertNotNull(result);
    }
}
