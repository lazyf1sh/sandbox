package com.github.lazyf1sh.sandbox.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Purpose: to have convenient ways to done various standart operations.
 *
 * @author Ivan Kopylov
 */
public class MyStaticUtils
{
    public static Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime)
    {
        return new Timestamp(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
