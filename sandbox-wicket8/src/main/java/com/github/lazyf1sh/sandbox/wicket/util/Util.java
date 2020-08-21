package com.github.lazyf1sh.sandbox.wicket.util;

import java.io.File;
import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class Util
{
    public static List<File> listf(String directoryName, List<File> files)
    {
        File directory = new File(directoryName);

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if (fList != null)
        {
            for (File file : fList)
            {
                if (file.isFile())
                {
                    files.add(file);
                }
                else if (file.isDirectory())
                {
                    listf(file.getAbsolutePath(), files);
                }
            }
        }

        return files;
    }
}