package com.github.lazyf1sh.sandbox.algorithms.revertedIfCondition;

/**
 * @author Ivan Kopylov
 */
public class RevertedIfCondition
{
    /**
     * @param a e.g.: should be done
     * @param b e.g.: but not done
     * @return true if should be done, but not done. otherwise false
     */
    public static boolean run(boolean a, boolean b)
    {
        if (a && !b)
        {
            return true;
        }
        return false;
    }

    /**
     * @param a e.g.: should be done
     * @param b e.g.: but not done
     * @return true if should be done, but not done. otherwise false
     */
    public static boolean run2(boolean a, boolean b)
    {
        if (!a || b)
        {
            return false;
        }
        return true;
    }
}
