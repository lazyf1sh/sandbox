package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;

import java.util.Date;


public class ComparableObject
{

    private String str;
    private Date   date;
    private int    num;

    public ComparableObject(final String str, final Date date, final int num)
    {
        this.str = str;
        this.date = date;
        this.num = num;
    }

    public String getStr()
    {
        return str;
    }

    public void setStr(final String str)
    {
        this.str = str;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(final Date date)
    {
        this.date = date;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(final int num)
    {
        this.num = num;
    }
}
