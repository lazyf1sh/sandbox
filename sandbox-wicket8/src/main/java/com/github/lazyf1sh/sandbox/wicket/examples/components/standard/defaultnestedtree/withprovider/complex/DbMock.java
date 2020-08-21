package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.defaultnestedtree.withprovider.complex;

import java.io.File;
import java.util.List;

public class DbMock
{
    public static MyNode loadFromDb()
    {

        return XmlToMyStructConverter.convert(new File("C:\\1\\Beispieldokumente_2.06.2\\ELGA-043-Laborbefund_EIS-FullSupport_RAST_PDF_attached.xml")).get();
    }

    public static MyNode findMyStruct(List<MyNode> myStructs, String id)
    {
        for (MyNode myStruct : myStructs)
        {
            if (myStruct.getId().equals(id))
            {
                return myStruct;
            }

            MyNode temp = findMyStruct(myStructs, id);
            if (temp != null)
            {
                return temp;
            }
        }

        return null;
    }
}
