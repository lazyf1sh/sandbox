package com.github.lazyf1sh.sandbox.java;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ivan Kopylov
 */
public class ReadToByteArray
{

	public static void main(String[] args) throws IOException
	{
		String sourcePath = "C:\\DEV\\dailyPlan\\091ae78176f242b28824125c96bfed1b_Ärztliche Anamnese.pdf";
		InputStream inputStream = null;
		try
		{
			inputStream = new FileInputStream(sourcePath);
			byte[] b = readFully(inputStream);
			System.out.println(b.length);
		} finally
		{
			if (inputStream != null)
			{
				inputStream.close();
			}
		}
	}

	public static byte[] readFully(InputStream stream) throws IOException
	{
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = stream.read(buffer)) != -1)
		{
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}
}
