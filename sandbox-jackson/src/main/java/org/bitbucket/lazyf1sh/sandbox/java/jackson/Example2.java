package org.bitbucket.lazyf1sh.sandbox.java.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Example2
{
    public static void main(String[] args) throws JsonProcessingException
    {
        List<MyDto> list = new ArrayList<MyDto>();
        list.add(new MyDto("k1", "v1", "cv1"));
        list.add(new MyDto("k2", "v2", "cv2"));
        list.add(new MyDto("k3", "v3", "cv3"));

        String s = new ObjectMapper().writeValueAsString(list);
        System.out.println(s);
    }
}
