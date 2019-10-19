package com.github.lazyf1sh.sandbox.spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Purpose of this example: to practice MultiValueMap usage<br/>
 * Multimap has a usual key and {@link List} as of values a value.
 */
public class MultiValueMapExample
{
    @Test
    public void test1()
    {
        final MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.put("key1", Collections.singletonList("1"));
        multiValueMap.put("key1", Arrays.asList("2", "3")); //overwrites previous value
        multiValueMap.put("key2", Collections.singletonList("1"));
        multiValueMap.put("key2", Arrays.asList("2", "3")); //overwrites previous value

        Assert.assertEquals("2", multiValueMap.get("key1").get(0));
        Assert.assertEquals("3", multiValueMap.get("key1").get(1));
    }

    /**
     * Demonstates that multivalue map does not appends to the values
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test2()
    {
        final MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.put("key1", Collections.singletonList("1"));
        multiValueMap.put("key1", Arrays.asList("2", "3")); //overwrites previous value
        multiValueMap.put("key2", Collections.singletonList("1"));
        multiValueMap.put("key2", Arrays.asList("2", "3")); //overwrites previous value

        Assert.assertNotEquals("1", multiValueMap.get("key1").get(0));
        Assert.assertNotEquals("1", multiValueMap.get("key1").get(1));
        Assert.assertNotEquals("1", multiValueMap.get("key1").get(2));
    }

}
