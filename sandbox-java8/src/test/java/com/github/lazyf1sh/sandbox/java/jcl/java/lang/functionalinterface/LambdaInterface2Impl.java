package com.github.lazyf1sh.sandbox.java.jcl.java.lang.functionalinterface;

/**
 * The default implementation of smth.
 *
 * @author Ivan Kopylov
 */
public class LambdaInterface2Impl implements LambdaInterface
{

    @Override
    public long doSomething(String str, int num)
    {
        return 0;
    }

    /**
     * Default method can be overridden.
     *
     * @return
     */
    @Override
    public int someDefaultMethod()
    {
        return 1;
    }
}
