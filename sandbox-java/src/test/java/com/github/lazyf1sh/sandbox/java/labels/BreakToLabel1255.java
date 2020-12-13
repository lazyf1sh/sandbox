package com.github.lazyf1sh.sandbox.java.labels;

import org.junit.Test;

/**
 * enthuware.ocpjp.i.v11.2.1255
 */
public class BreakToLabel1255
{
    @Test
    public void run()
    {
        int i = 0;
        loop:
        // 1
        {
            System.out.println("Loop Lable line");
            try
            {
                for (; true; i++)
                {
                    if (i > 5)
                    {
                        break loop;       // 2
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception in loop.");
            }
            finally
            {
                System.out.println("In Finally");      // 3
            }
        }

    }
}
