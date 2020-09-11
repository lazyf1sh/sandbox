package com.github.lazyf1sh.sandbox.java.mechanics.serializable;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ivan Kopylov
 */
public class SerializableExamples
{
    @Test
    public void serializable1()
    {
        String q = readAllBytesJava7("C:\\Windows\\System32\\drivers\\etc\\hosts");
        try
        {
            int i = sizeof(q);
            System.out.println(i);
        }
        catch (IOException e)
        {
            System.out.println("error " + e);
            Assert.fail();
        }
    }

    public static int sizeof(Object obj) throws IOException
    {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);

        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();

        return byteOutputStream.toByteArray().length;
    }

    private static String readAllBytesJava7(String filePath)
    {
        String content = "";
        try
        {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
