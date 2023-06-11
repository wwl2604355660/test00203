package shiyan2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XMLParser {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("input.xml");

            Element root = document.getDocumentElement();
            String rootTagName = root.getTagName();
            System.out.println("rootTagName:" + rootTagName);

            NodeList children = root.getChildNodes();
            int childCount = children.getLength();
            System.out.println("rootchildCount:" + childCount);

            for (int i = 0; i < childCount; i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    String nodeName = child.getNodeName();
                    System.out.println("item" + i + ":getNodeName:" + nodeName);

                    int nodeType = child.getNodeType();
                    String nodeValue = child.getNodeValue();
                    System.out.println("getNodeType:" + nodeType);
                    System.out.println("getNodeValue:" + nodeValue);

                    String textContent = child.getTextContent();
                    System.out.println("getTextContent:" + textContent);

                    Element element = (Element)child;
                    String attributeValue = element.getAttribute("学号");
                    System.out.println("node" + i + ":学号=" + attributeValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}