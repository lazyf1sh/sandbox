package com.github.lazyf1sh.sandbox.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ivan Kopylov
 */
public class SimpleDateFormatExample {
    public static void main(String[] args) throws ParseException {
        String strDT = "2017-02-14T00:02:18".replaceAll("Z$", "+0000");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = format.parse(strDT);


        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String s = format2.format(date);

        System.out.println(s);

//        System.out.println(String.format("%1$tD %1$tT", date));
    }
}
