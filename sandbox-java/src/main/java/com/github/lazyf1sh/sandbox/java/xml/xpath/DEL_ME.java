package com.github.lazyf1sh.sandbox.java.xml.xpath;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Ivan Kopylov
 */
public class DEL_ME
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("C:\\1\\Beispieldokumente_2.06.2\\ELGA-023-Entlassungsbrief_aerztlich_EIS-FullSupport.xml"));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("/ClinicalDocument/recordTarget/patientRole/addr/streetAddressLine");
        xpath.compile("/*[name()='ClinicalDocument']/*[name()='recordTarget']/*[name()='patientRole']/*[name()='addr']/*[name()='streetAddressLine']").evaluate(doc);

        expr.evaluate(doc);
    }
}
