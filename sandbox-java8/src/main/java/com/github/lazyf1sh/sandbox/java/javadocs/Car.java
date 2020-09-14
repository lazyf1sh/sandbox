package com.github.lazyf1sh.sandbox.java.javadocs;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;



@Documented
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
@Vehicle
public @interface Car
{

}
