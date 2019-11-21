package com.github.lazyf1sh.sandbox.java.mechanics.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class ExceptionsExampleFinally
{
    @Test
    public void basic_exception()
    {

        BufferedReader br = null;
        try
        {
            File file = new File("test.txt");

            br = new BufferedReader(new FileReader(file));
            br.read();
        }
        catch (Exception e)
        {
            System.out.println("Something bad happened.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try
            {
                System.out.println("Closing resource.");
                br.close();
                System.out.println("Closed resource.");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
