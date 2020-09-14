package com.github.lazyf1sh.sandbox.java.jcl.java.io;

import java.io.File;
import java.io.IOException;

/**
 * @author Ivan Kopylov
 */
public class FileExample
{
    public static void main(String[] args) throws IOException
    {
        File f = new File("1.txt");
        System.out.println(f);
        System.out.println(f.getAbsolutePath());
        System.out.println(f.toString());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getAbsoluteFile());
    }
}

