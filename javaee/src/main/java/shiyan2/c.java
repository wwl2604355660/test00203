package shiyan2;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class c {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("input.xml");

            Element root = document.getDocumentElement();
            String rootTagName = root.getTagName();
            System.out.println("rootTagName:" + rootTagName);

            NodeList list1 = document.getElementsByTagName("姓名");
            NodeList list2 = document.getElementsByTagName("性别");
            NodeList list3 = document.getElementsByTagName("男");

            NodeList children = root.getChildNodes();
            int childCount = children.getLength();
            System.out.println("rootchildCount:" + childCount);

            for (int i = 0; i < list1.getLength(); i++) {
                Node child1 = list1.item(i);
                Node child2 = list2.item(i);
                Node child3 = list3.item(i);
                if (child1.getNodeType() == Node.ELEMENT_NODE) {
                    String nodeName = child1.getNodeName();
                    System.out.println("item" + i + ":getNodeName:" + nodeName);

                    int nodeType1 = child1.getNodeType();
                    String nodeValue1 = child1.getNodeValue();
                    System.out.println("getNodeType:" + nodeType1);
                    System.out.println("getNodeValue:" + nodeValue1);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}