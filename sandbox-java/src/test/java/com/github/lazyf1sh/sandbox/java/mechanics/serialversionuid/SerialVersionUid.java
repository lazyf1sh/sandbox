package com.github.lazyf1sh.sandbox.java.mechanics.serialversionuid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * The default implementation.
 *
 * @author Ivan Kopylov
 */

public class SerialVersionUid
{


    @Before
    public void writeToTempThenChangeSerialVersionUid() throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream("1.dat");

        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        os.writeObject(new SerializableClass());
        os.flush();
        os.close();
    }


    @Test
    public void readWrittenFile() throws IOException, ClassNotFoundException
    {
        FileInputStream fileInputStream = new FileInputStream("1.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableClass p2 = (SerializableClass) objectInputStream.readObject();
        System.out.println(p2.getValue());
        objectInputStream.close();
    }


    @After
    public void changeUidAndRead() throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException
    {
        Field serialVersionUID = SerializableClass.class.getDeclaredField("serialVersionUID");
        setField(serialVersionUID, 10L);


        FileInputStream fileInputStream = new FileInputStream("1.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerializableClass p2 = (SerializableClass) objectInputStream.readObject();
        System.out.println(p2.getValue());
        objectInputStream.close();

    }

    private void setField(Field field, long l) throws NoSuchFieldException, IllegalAccessException
    {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.setLong(null, l);
    }

}
