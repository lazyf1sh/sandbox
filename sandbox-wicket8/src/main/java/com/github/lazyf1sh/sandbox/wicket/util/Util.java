package com.github.lazyf1sh.sandbox.wicket.util;

import org.apache.wicket.Component;

import java.io.File;
import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class Util
{
    public static void showComponentMessage(Component component)
    {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        showComponentMessageInner(component, methodName, "");
    }

    public static void showComponentMessage(Component component, String other)
    {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        showComponentMessageInner(component, methodName, other);
    }

    public static void showComponentMessageInner(Component component, String methodName, String other)
    {
        String format = String.format("%-17s | %-12s | %s", component.getId(), methodName, other);
        System.out.println(format);
    }

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