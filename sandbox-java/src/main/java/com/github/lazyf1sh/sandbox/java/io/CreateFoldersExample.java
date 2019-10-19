package com.github.lazyf1sh.sandbox.java.io;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ivan Kopylov
 */
public class CreateFoldersExample
{


    public static void main(String[] args)
    {
        String path =  "C:\\qwe/qwe\\123";
        String path2 = "C:\\qwe//qwe\\123";
        String path3 = "C:\\qwe/qwe\\\\123";

        try
        {
            Path p = Files.createDirectories(Paths.get(path3));
        }
        catch (AccessDeniedException e)
        {

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
