package com.github.lazyf1sh.sandbox.java.mechanics.exceptions;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Ivan Kopylov
 */
public class ExceptionsExampleFinally
{
    @Test
    public void basicException()
    {

        BufferedReader br = null;
        try
        {
            File file = new File("non-existing file.");

            br = new BufferedReader(new FileReader(file));
            br.read();
        }
        catch (Exception e)
        {
            Assert.assertTrue(true);
            System.out.println("Something bad happened.");
        }
        finally
        {
            Assert.assertTrue(true);

            Assert.assertTrue(true);
            System.out.println("Closing resource.");
            if (br != null)
            {
                System.out.println("Closed resource.");
                Assert.fail();
            }
            else
            {
                Assert.assertTrue(true);
                System.out.println("resource is null.");
            }
        }
    }
}
