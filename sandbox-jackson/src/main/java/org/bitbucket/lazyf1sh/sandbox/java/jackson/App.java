package org.bitbucket.lazyf1sh.sandbox.java.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App
{
    public static void main(String[] args) throws JsonProcessingException
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

        String s = new ObjectMapper().writeValueAsString(list);
        System.out.println(s);
    }
}
