package com.github.lazyf1sh.sandbox.selenium.util;

import java.io.File;
import java.net.URL;

import javax.annotation.Nullable;

/**
 * @author Ivan Kopylov
 */
public class Utils
{
    @Nullable
    public static String convertClassPathToAbsolutePath(String path)
    {
        URL resource = Utils.class.getClassLoader().getResource("FindElementsRelevantToAnother.html");
        if (resource != null)
        {
            File file = new File(resource.getFile());
            String absolutePath = file.getAbsolutePath();
            String prefix = "file:///";
            return prefix += absolutePath;
        }
        else
        {
            return null;
        }
    }
}
