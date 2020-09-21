package com.github.lazyf1sh.sandbox.java.mechanics.serialversionuid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

/**
 *
 *
 * @author Ivan Kopylov
 */

public class SerialVersionUid
{
    private static final String FILE_NAME  = System.getProperty("java.io.tmpdir") + "SerialVersionUid-sandbox-java-test.dat";
    private static final String TEST_VALUE = "test value";

    @Before
    public void writeThenChangeSerialVersionUidManually() throws IOException
    {
        File file = new File(FILE_NAME);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        os.writeObject(new SerializableClass(TEST_VALUE));
        os.flush();
        os.close();

        Assert.assertTrue(file.exists());
    }


    @Test
    public void readWrittenFile() throws IOException, ClassNotFoundException
    {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableClass result = (SerializableClass) objectInputStream.readObject();

        objectInputStream.close();

        Assert.assertEquals(TEST_VALUE, result.getValue());
    }
}
