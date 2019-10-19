package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.withprovider.complex;


import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlToMyStructConverter
{
    public static Optional<MyNode> convert(File xml)
    {
        //check if xml

        DocumentBuilder builder;
        try
        {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            return Optional.empty();
        }

        Document doc;
        try
        {
            doc = builder.parse(xml);
        }
        catch (SAXException e)
        {
 
            return Optional.empty();
        }
        catch (IOException e)
        {
            return Optional.empty();
        }

        Node root = doc.getDocumentElement();
        MyNode treeRoot = new MyNode(UUID.randomUUID().toString(), root.getNodeName());

        MyNode struct = getStruct(treeRoot, root);
        return Optional.of(struct);
    }

    private static MyNode getStruct(MyNode treeNode, Node node)
    {
        if (node.hasChildNodes())
        {
            NodeList list = node.getChildNodes();
            for (int i = 0; i < node.getChildNodes().getLength(); i++)
            {
                Node subNode = list.item(i);
                if (subNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    MyNode child = new MyNode(UUID.randomUUID().toString(), subNode.getNodeName(), treeNode);
                    treeNode.addChild(getStruct(child, subNode));
                }
            }
        }
        else
        {
            treeNode.addChild(new MyNode(UUID.randomUUID().toString(), node.getNodeName(), true));
        }

        return treeNode;
    }

    private XmlToMyStructConverter()
    {
    }
}
