package com.github.lazyf1sh.sandbox.java.common.tasks;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File("39c2223d7f144335bc8dd10287caa984.ds2.xml");

        Document doc = builder.parse(f);

        Node root = doc.getDocumentElement();

        DocumentNode treeRoot = new DocumentNode(String.valueOf(new Random().nextInt(500000)), root.getNodeName());

        DocumentNode result = getStruct(treeRoot, root);
        System.out.println("12");
    }

    private static DocumentNode getStruct(DocumentNode treeNode, Node node)
    {

        if (node.hasChildNodes())
        {
            NodeList list = node.getChildNodes();
            for (int i = 0; i < node.getChildNodes().getLength(); i++)
            {
                Node subNode = list.item(i);
                if (subNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    DocumentNode child = new DocumentNode(String.valueOf(new Random().nextInt(500000)), subNode.getNodeName(),
                            treeNode);
                    treeNode.addChild(getStruct(child, subNode));
                }
            }
        }
        else
        {
            treeNode.addChild(new DocumentNode(String.valueOf(new Random().nextInt(500000)), node.getNodeName(), true));
        }

        return treeNode;
    }

}
