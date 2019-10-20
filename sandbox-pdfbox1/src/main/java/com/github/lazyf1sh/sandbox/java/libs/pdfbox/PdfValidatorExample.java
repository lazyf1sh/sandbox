package com.github.lazyf1sh.sandbox.java.libs.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.*;

/**
 * Hello world!
 *
 */
public class PdfValidatorExample
{
    public static void main(String[] args) {
       String path = args[0];
        File folder = new File(path);
        for(File file : folder.listFiles())
        {
            if(file.isFile()) {
                byte[] barray = new byte[0];
                try {
                    InputStream is = new FileInputStream(file);
                    barray = readFully(is);
                    if (!validatePDF(barray)) {
                        System.out.println(String.format("[FAILED] %s", file));
                    } else {
                        System.out.println(String.format("[OK] %s", file));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] readFully(InputStream stream) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }

    /**
     * Check if provided file is PDF
     *
     * @param data - file as byte array
     * @return true in case of provided file data is PDF
     */
    public static boolean validatePDF(byte[] data) {
        try {
            PDDocument.load(data).close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
