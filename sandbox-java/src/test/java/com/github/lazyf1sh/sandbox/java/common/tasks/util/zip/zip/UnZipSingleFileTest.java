package com.github.lazyf1sh.sandbox.java.common.tasks.util.zip.zip;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class UnZipSingleFileTest extends TestCase
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
            String fileZip = "files/compressed.zip";
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
            ZipEntry unzipEntry = zis.getNextEntry();
            while (unzipEntry != null)
            {
                File newFile = new File(unzipEntry.getName());
                FileOutputStream unzipfos = new FileOutputStream("files/" + newFile + ".unzipped");
                int len;
                while ((len = zis.read(buffer)) > 0)
                {
                    unzipfos.write(buffer, 0, len);
                }
                unzipfos.close();
                unzipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();

            compressed.delete();
            assertTrue(true);
        }
        else
        {
            assertTrue(false);
        }

    }
}