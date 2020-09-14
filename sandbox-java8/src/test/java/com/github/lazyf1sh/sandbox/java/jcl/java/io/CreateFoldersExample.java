package com.github.lazyf1sh.sandbox.java.jcl.java.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ivan Kopylov
 */
public class CreateFoldersExample
{
    @Test
    public void main()
    {
        String property = System.getProperty("java.io.tmpdir");

        String path1 = property + "\\some_dir/subdir1\\123";
        String path2 = property + "\\some_dir//subdir2\\123";
        String path3 = property + "\\some_dir/subdir3\\\\123";

        try
        {
            Path p1 = Files.createDirectories(Paths.get(path1));
            Path p2 = Files.createDirectories(Paths.get(path2));
            Path p3 = Files.createDirectories(Paths.get(path3));
            Assert.assertTrue(p1.toFile().exists());
            Assert.assertTrue(p2.toFile().exists());
            Assert.assertTrue(p3.toFile().exists());
        }
        catch (IOException e)
        {
            Assert.fail();
            e.printStackTrace();
        }
    }
}
