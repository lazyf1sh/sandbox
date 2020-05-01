package com.github.lazyf1sh.sandbox.algorithms.revertedIfCondition;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */

public class RevertedIfConditionTest
{

    @SuppressWarnings("ConstantConditions")
    @Test
    public void run()
    {
        Assert.assertTrue(RevertedIfCondition.run(true, false));
        Assert.assertFalse(RevertedIfCondition.run(true, true));
        Assert.assertFalse(RevertedIfCondition.run(false, true));
        Assert.assertFalse(RevertedIfCondition.run(false, false));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void run2()
    {
        Assert.assertTrue(RevertedIfCondition.run2(true, false));
        Assert.assertFalse(RevertedIfCondition.run2(true, true));
        Assert.assertFalse(RevertedIfCondition.run2(false, true));
        Assert.assertFalse(RevertedIfCondition.run2(false, false));
    }
}
