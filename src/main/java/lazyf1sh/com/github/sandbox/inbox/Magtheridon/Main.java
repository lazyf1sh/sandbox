package Magtheridon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main
{
    public static void main(String[] args)
    {
        String[] arr1 = {"1", "2"};
        String[] arr2 = {"1", "2"};
        String[] arr3 = arr2;

        Set<String[]> arrStrSet = new HashSet<String[]>();
        arrStrSet.add(arr1);
        arrStrSet.add(arr2);
        arrStrSet.add(arr3);


        List<String> listStr1 = new ArrayList<String>();
        listStr1.add("1");
        listStr1.add("2");

        List<String> listStr2 = new ArrayList<String>();
        listStr2.add("1");
        listStr2.add("2");


        Set<List<String>> arrListSet = new HashSet<List<String>>();
        arrListSet.add(listStr1);
        arrListSet.add(listStr2);











        int i = 0;
    }
}
