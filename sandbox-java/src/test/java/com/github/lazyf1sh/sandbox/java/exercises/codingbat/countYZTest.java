package com.github.lazyf1sh.sandbox.java.exercises.codingbat;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.exercises.solutions.countYZ;

/**
 * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy"
 * and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say
 * that a y or z is at the end of a word if there is not an alphabetic letter immediately following
 * it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
 * https://codingbat.com/prob/p199171
 */
public class countYZTest
{
    @Test
    public void run()
    {
        Assert.assertEquals(2, countYZ.countYZ("fez day"));
        Assert.assertEquals(2, countYZ.countYZ("day fez"));
        Assert.assertEquals(2, countYZ.countYZ("day fyyyz"));
        Assert.assertEquals(2, countYZ.countYZ("!!day--yaz!!"));
    }
}
