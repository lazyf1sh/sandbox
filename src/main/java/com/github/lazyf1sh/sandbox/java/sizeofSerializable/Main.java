package com.github.lazyf1sh.sandbox.java.sizeofSerializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author Ivan Kopylov
 */
public class Main
{
	public static void main(String[] args)
	{
		System.out.println(new Date().getTime());
		String q = readAllBytesJava7("C:\\Windows\\System32\\drivers\\etc\\hosts");
		try
		{
			int i = sizeof(q);
			System.out.println(i);
		} catch (IOException e)
		{
			System.out.println("error " + e);
		}
		System.out.println(new Date().getTime());
		
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
	        content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return content;
	}
}
