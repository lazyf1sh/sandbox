package com.github.lazyf1sh.sandbox;

import com.github.lazyf1sh.sandbox.domain.case2.CustomClass;
import org.junit.Test;

/**
 * JEP 286: Local-Variable Type Inference
 */
public class LocalVariableTypeInference
{
    @Test
    public void run()
    {
        var a = 10;
    }

    @Test
    public void run2()
    {
        var puma = new CustomClass();
    }
}
