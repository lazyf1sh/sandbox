package com.github.lazyf1sh.sandbox.java.jcl.java.lang.functionalinterface;

import org.junit.Assert;

/**
 * @author Ivan Kopylov
 */
public class Test
{
    @org.junit.Test
    public void run()
    {
        LambdaInterface lambdaInterface = (str, num) -> {
            System.out.println("Lambda function");
            return 2L;
        };

        Assert.assertEquals(2L, lambdaInterface.doSomething("str", 5));
    }

    @org.junit.Test
    public void run01()
    {
        LambdaInterface lambdaInterface = (str, num) -> {
            System.out.println("Lambda function");
            return 2L;
        };

        Assert.assertEquals(0, lambdaInterface.someDefaultMethod());
    }

    @org.junit.Test
    public void run02()
    {

        LambdaInterface lambdaInterface = new LambdaInterface2Impl();

        Assert.assertEquals(1, lambdaInterface.someDefaultMethod());
    }

}
