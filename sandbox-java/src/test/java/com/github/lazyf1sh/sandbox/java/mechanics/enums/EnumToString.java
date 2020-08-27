package com.github.lazyf1sh.sandbox.java.mechanics.enums;

public enum EnumToString
{
    MY_VALUE("QWERTY");


    private String enumValue;

    EnumToString(final String enumValue)
    {
        this.enumValue = enumValue;
    }


    public String getEnumValue()
    {
        return enumValue;
    }
}
