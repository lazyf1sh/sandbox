package com.github.lazyf1sh.sandbox.java.dozermapper;


import org.apache.commons.text.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class StringEscapeUtilsTests
{
    @Test
    public void html3()
    {
        String input = "\u0394"; // greek capital letter delta,U+0394 ISOgrk3 -->
        String result = StringEscapeUtils.escapeHtml3(input);
        Assert.assertEquals(input, result);
    }

    @Test
    public void html4()
    {
        String input = "\u0394";
        String result = StringEscapeUtils.escapeHtml4(input);
        Assert.assertEquals("&Delta;", result);
    }

    @Test
    public void unescapeHtml3Normal()
    {
        String input = "&gt;";
        String result = StringEscapeUtils.unescapeHtml3(input);
        Assert.assertEquals(">", result);
    }

    @Test
    public void unescapeHtml3WithoutSemicolon()
    {
        String input = "&gt";
        String result = StringEscapeUtils.unescapeHtml3(input);
        Assert.assertEquals("&gt", result);
    }


    @Test
    public void ltGt()
    {
        String input = "<a>";
        String result = StringEscapeUtils.escapeHtml4(input);
        Assert.assertEquals("&lt;a&gt;", result);
    }

}
