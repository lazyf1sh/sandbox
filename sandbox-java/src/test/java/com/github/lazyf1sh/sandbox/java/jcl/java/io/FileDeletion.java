package com.github.lazyf1sh.sandbox.java.jcl.java.io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class FileDeletion
{
    public static void main(String[] args)
    {
        File catalog = new File("src/main/resources/");
        File[] files = catalog.listFiles();
        List<File> listFiles = Arrays.asList(files);
        listFiles.forEach(File::delete);
    }
}
