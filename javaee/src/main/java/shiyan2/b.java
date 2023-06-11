package shiyan2;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class b {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            root.getChildNodes();
            System.out.println("rootTagName: " + root.getTagName());
            System.out.println("rootchildCount: " + root.getChildNodes().getLength());
            System.out.println("&&&&&&&&&&&&&&&");
            printNode(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printNode(Node node) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("getNodeName: " + childNode.getNodeName());
                printNode(childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("getNodeName: #text");
            }
        }
    }
}