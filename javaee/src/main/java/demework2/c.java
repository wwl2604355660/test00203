package demework2;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;


public class c {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory fact1 = DocumentBuilderFactory.newInstance();
            fact1.setValidating(true);
            fact1.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder1 = fact1.newDocumentBuilder();
            String XpathList = "Xpath.xml";
            Document Doc = builder1.parse(new File(XpathList));
            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();
            XPathExpression exp = xPath.compile("//重量/text()");
            Object result = exp.evaluate(Doc, XPathConstants.NODESET);
            NodeList nodeList = (NodeList) result;
            float sum = 0;
            for (int i=0;i<nodeList.getLength();i++){
               sum += Float.parseFloat(nodeList.item(i).getNodeValue());
            }
            System.out.println("所有货物加起来的重量为: " + sum);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }
}



