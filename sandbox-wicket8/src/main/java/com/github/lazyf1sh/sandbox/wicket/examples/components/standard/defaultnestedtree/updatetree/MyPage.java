package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.defaultnestedtree.updatetree;

import java.io.File;
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.extensions.markup.html.repeater.util.TreeModelProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;

/**
 * https://i.imgur.com/Wh82sDX.gif
 *
 */
public class MyPage extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        DefaultTreeModel model = null;
        try
        {
            model = new DefaultTreeModel(getDemoStruct2());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }

        final TreeModelProvider<DefaultMutableTreeNode> modelProvider = new TreeModelProvider<DefaultMutableTreeNode>(model)
        {
            @Override
            public IModel<DefaultMutableTreeNode> model(DefaultMutableTreeNode object)
            {
                return Model.of(object);
            }
        };

        final DefaultNestedTree tree = new DefaultNestedTree("tree", modelProvider);
        tree.setOutputMarkupId(true);
        add(tree);

        AjaxLink<String> trigger2 = new AjaxLink<String>("updateTree", Model.of("button text"))
        {

            @Override
            public void onClick(final AjaxRequestTarget target)
            {
                target.add(tree);
            }
        };
        add(trigger2);
    }

    private TreeNode getDemoStruct()
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("my_root_string");
        root.add(new DefaultMutableTreeNode("my_string"));
        return root;
    }

    public static TreeNode getDemoStruct2() throws IOException, ParserConfigurationException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File("C:\\1\\apache-tomcat-7.0.42\\conf\\server.xml");
        Document doc = builder.parse(f);
        Node root = doc.getDocumentElement();
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode(root.getNodeName());
        TreeNode result = getStruct(treeRoot, root);

        return result;
    }

    private static DefaultMutableTreeNode getStruct(DefaultMutableTreeNode treeNode, Node node)
    {
        if(node.hasChildNodes())
        {
            NodeList list = node.getChildNodes();
            for(int i = 0; i < node.getChildNodes().getLength(); i++)
            {
                Node subNode = list.item(i);
                if(subNode instanceof DeferredElementImpl)
                {
                    DefaultMutableTreeNode child = new DefaultMutableTreeNode(subNode.getNodeName());
                    treeNode.add(getStruct(child, subNode));
                }
            }
        }
        else
        {
            treeNode.add(new DefaultMutableTreeNode(node.getNodeName()));
        }

        return treeNode;
    }
}
