package com.github.lazyf1sh.sandbox.java.libs;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSinglePdfTest
{
    @Test
    public void a()
    {
        byte[] result = new byte[0];

        byte[] pdf = readPdf();

        final PDFMergerUtility ut = new PDFMergerUtility();

        ut.addSource(new ByteArrayInputStream(pdf));
        final ByteArrayOutputStream mergedData = new ByteArrayOutputStream();
        ut.setDestinationStream(mergedData);
        try
        {
            ut.mergeDocuments(null);
            result = mergedData.toByteArray();
            Files.write(Paths.get("src\\main\\resources\\1.4 (acrobat 5.x) medium-merged.pdf"), result);
            System.out.println("1");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        assertArrayEquals(pdf, result);
    }


    private static byte[] readPdf()
    {
        try
        {
            return Files.readAllBytes(Paths.get("src\\main\\resources\\1.4 (acrobat 5.x) medium.pdf"));
        }
        catch (IOException e)
        {
            return new byte[0];
        }
    }
}