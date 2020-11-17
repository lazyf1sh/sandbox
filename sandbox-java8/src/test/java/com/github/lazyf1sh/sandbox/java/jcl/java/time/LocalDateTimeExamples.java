package com.github.lazyf1sh.sandbox.java.jcl.java.time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

/**
 * @author Ivan Kopylov
 */
public class LocalDateTimeExamples
{
    @Test
    public void happyPathLocalDateTime()
    {
        LocalDateTime result = LocalDateTime.parse("24.12.2020 14:58", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        Assert.assertEquals("2020-12-24T14:58", result.toString());
    }

    @Test
    public void happyPathLocalDate()
    {
        LocalDate result = LocalDate.parse("24.12.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Assert.assertEquals("2020-12-24", result.toString());
    }

    @Test
    public void localDateLenientBasicExample()
    {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy")
                .withResolverStyle(ResolverStyle.LENIENT);

        LocalDate result = LocalDate.parse("31.02.2020", formatter);

        Assert.assertEquals("2020-03-02", result.toString());
    }

    @Test
    public void localDateTimeLenient()
    {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm")
                .withResolverStyle(ResolverStyle.LENIENT);

        LocalDateTime result = LocalDateTime.parse("18.02.2020 15:23", formatter);

        Assert.assertEquals("2020-02-18T15:23", result.toString());
    }

    @Test(expected = DateTimeParseException.class)
    public void localDateTimeStrict()
    {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDateTime.parse("18.02.2020 15:23", formatter);
    }

    /**
     * {@link ResolverStyle.LENIENT} overflows result.
     */
    @Test
    public void localDateTimeLenientIncorrectDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm")
                .withResolverStyle(ResolverStyle.LENIENT);

        LocalDateTime result = LocalDateTime.parse("31.02.2020 15:23", formatter);

        Assert.assertEquals(2, result.getDayOfMonth());
        Assert.assertEquals(3, result.getMonthValue());
    }

    /**
     * {@link ResolverStyle.SMART} fixes result to maximum available date.
     */
    @Test
    public void localDateTimeSmartIncorrectDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm")
                .withResolverStyle(ResolverStyle.SMART);

        LocalDateTime result = LocalDateTime.parse("31.02.2020 15:23", formatter);

        Assert.assertEquals(29, result.getDayOfMonth());
        Assert.assertEquals(2, result.getMonthValue());
    }

    @Test(expected = DateTimeParseException.class)
    public void localDateStrict()
    {
        String input = "31.02.2020";
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate.parse(input, formatter);
    }

    @Test
    public void happyPathLocalTime()
    {
        LocalTime result = LocalTime.parse("23:55", DateTimeFormatter.ofPattern("HH:mm"));
        Assert.assertEquals("23:55", result.toString());
    }

    /**
     * Purpose: to show that java.util.Date differs from java.time.LocalDateTime .
     */
    @Test
    public void dateDiffersFromLocalDateTime()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 15, 15, 15);
        long a = localDateTime.atZone(ZoneId.of("UTC+03:00")).toInstant().toEpochMilli();
        long b = localDateTime.atZone(ZoneId.of("UTC+02:00")).toInstant().toEpochMilli();

        Assert.assertEquals(3600000L, b - a);
        Assert.assertEquals(1592223300000L, a);
        Assert.assertEquals(1592226900000L, b);
    }

    /**
     * This example shows how to convert LocalDateTime to epoch milliseconds
     */
    @Test
    public void localDateTimeToMillis()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        long a = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long b = new Date().getTime();

        if (b - a > 15)
        {
            Assert.fail();
        }
        Assert.assertTrue(true);
    }

    @Test(expected = DateTimeParseException.class)
    public void unableToParse()
    {
        DateTimeFormatter.ofPattern("YY").format(LocalDateTime.now());
        LocalDateTime.parse("24.12.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    /**
     * LocalDate is not suited to parse Date and time. Only date.
     */
    @Test(expected = DateTimeParseException.class)
    public void unableToParseDateTime()
    {
        LocalDate.parse("24.12.2020 14:58", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void zonedDateTimeExample()
    {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2011-12-03T10:15:30+01:00");
    }

    @Test
    public void noErrorIfUseLocalDateTime()
    {
        LocalDateTime.parse("24.12.2020 14:58", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }

    @Test
    public void dle()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("d/m/yyyy HH:MM"));

        long a = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long b = new Date().getTime();

        if (b - a > 5)
        {
            Assert.assertTrue(false);
        }
        Assert.assertTrue(true);
    }

    /**
     * To show that same timezone has many aliases.
     */
    @Test
    public void timeZoneHasAliases()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 15, 15, 15);
        long a = localDateTime.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        long b = localDateTime.atZone(ZoneId.of("Europe/Helsinki")).toInstant().toEpochMilli();
        long c = localDateTime.atZone(ZoneId.of("Asia/Beirut")).toInstant().toEpochMilli();
        Assert.assertEquals(a, b);
        Assert.assertEquals(a, c);
    }

    @Test
    public void test3()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 15, 15, 15);
        long a = localDateTime.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        long b = localDateTime.atZone(ZoneId.of("Africa/Cairo")).toInstant().toEpochMilli();

        Assert.assertEquals(3600000L, b - a);
    }

}
