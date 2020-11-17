package com.github.lazyf1sh.sandbox.java.jcl.java.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * @author Ivan Kopylov
 */
public class LocalDateTimeExamplesPain
{
    @Test
    public void uuuu()
    {
        DateTimeFormatter uuuu = DateTimeFormatter
                .ofPattern("ddMMuuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate.parse("28022020", uuuu);
    }

    @Test(expected = DateTimeParseException.class)
    public void yyyy()
    {
        DateTimeFormatter yyyy = DateTimeFormatter
                .ofPattern("ddMMyyyy")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate.parse("28022020", yyyy);
    }


    @Test
    public void uuuuDateTime()
    {
        DateTimeFormatter yyyy = DateTimeFormatter
                .ofPattern("ddMMuuuu HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDateTime.parse("28022020 15:23", yyyy);
    }


}
