package shiyan2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class a {

    public static void main(String[] args) {

        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("rootTagName: " + root.getTagName());

            NodeList children = root.getChildNodes();
            System.out.println("root child Count: " + children.getLength());

            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("item " + i + ": getNodeName: " + node.getNodeName());
                }else if(node.getNodeType() == Node.TEXT_NODE){
                    System.out.println("item " + i + ": getNodeName: " + node.getNodeName());
                }
            }

            System.out.println("------------NodeType and Value----------------");
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("getNodeType: " + node.getNodeType() + " , getNodeValue: " + node.getNodeValue());
                } else if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("getNodeType: " + node.getNodeType() + " , getNodeValue: " + node.getNodeValue());
                }
            }

            System.out.println("-----------getTextContent----------------");
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(" " + element.getElementsByTagName("姓名").item(0).getTextContent());
                    System.out.println(" " + element.getElementsByTagName("性别").item(0).getTextContent());
                    System.out.println(" " + element.getElementsByTagName("年龄").item(0).getTextContent());
                }
            }

            System.out.println("-------------属性测试----------------");
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("node " + i + ": " + element.getAttribute("学号"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}