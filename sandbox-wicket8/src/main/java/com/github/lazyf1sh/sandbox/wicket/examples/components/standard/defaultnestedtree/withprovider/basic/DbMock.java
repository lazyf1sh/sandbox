package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.defaultnestedtree.withprovider.basic;

import java.util.ArrayList;
import java.util.List;

public class DbMock
{
    public static List<MyStruct> loadFromDb()
    {
        List<MyStruct> myStructList = new ArrayList<>();

        MyStruct root = new MyStruct("A");
        MyStruct a = new MyStruct(root, "AA");
        root.addChild(a);

        MyStruct root2 = new MyStruct("B");
        myStructList.add(root);
        myStructList.add(root2);

        return myStructList;
    }

    public static List<MyStruct> loadFromDbRemoveThisMethod()
    {
        List<MyStruct> myStructList = new ArrayList<>();

        MyStruct root = new MyStruct("Q");
        MyStruct a = new MyStruct(root, "QQ");
        root.addChild(a);

        MyStruct root2 = new MyStruct("W");
        myStructList.add(root);
        myStructList.add(root2);

        return myStructList;
    }


    public static MyStruct findMyStruct(List<MyStruct> MyStructs, String id)
    {
        for (MyStruct MyStruct : MyStructs)
        {
            if (MyStruct.getId().equals(id))
            {
                return MyStruct;
            }

            MyStruct temp = findMyStruct(MyStruct.getSiblings(), id);
            if (temp != null)
            {
                return temp;
            }
        }

        return null;
    }
}
