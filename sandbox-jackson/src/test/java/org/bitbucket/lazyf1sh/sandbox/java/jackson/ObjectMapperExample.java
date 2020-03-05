package org.bitbucket.lazyf1sh.sandbox.java.jackson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperExample
{
    @Test
    public void main() throws JsonProcessingException
    {
        List<MyDto> list = new ArrayList<MyDto>();
        list.add(new MyDto("k1", "v1", "cv1"));
        list.add(new MyDto("k2", "v2", "cv2"));
        list.add(new MyDto("k3", "v3", "cv3"));

        String result = new ObjectMapper().writeValueAsString(list);
        System.out.println(result);
        Assert.assertEquals("[{\"key\":\"k1\",\"value\":\"v1\",\"myCustomValue\":\"cv1\"},{\"key\":\"k2\",\"value\":\"v2\",\"myCustomValue\":\"cv2\"},{\"key\":\"k3\",\"value\":\"v3\",\"myCustomValue\":\"cv3\"}]", result);
    }

    @Test
    public void run() throws JsonProcessingException
    {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        Map<String, String> m = new HashMap<String, String>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        list.add(m);

        m = new HashMap<String, String>();
        m.put("k3", "v3");
        m.put("k4", "v4");
        list.add(m);

        String result = new ObjectMapper().writeValueAsString(list);
        System.out.println(result);
        Assert.assertEquals("[{\"k1\":\"v1\",\"k2\":\"v2\"},{\"k3\":\"v3\",\"k4\":\"v4\"}]", result);

    }
}