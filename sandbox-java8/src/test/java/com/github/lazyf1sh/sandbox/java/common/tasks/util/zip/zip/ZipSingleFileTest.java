package com.github.lazyf1sh.sandbox.java.common.tasks.util.zip.zip;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipSingleFileTest extends TestCase
{
    public void test() throws IOException
    {
        String sourceFile = "files/1.txt";
        FileOutputStream fos = new FileOutputStream("files/compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0)
        {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();

        File compressed = new File("files/compressed.zip");
        if (compressed.exists())
        {
            compressed.delete();
            assertTrue(true);
        }
        else
        {
            assertTrue(false);
        }

    }
}