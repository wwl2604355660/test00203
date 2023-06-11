package demework2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class a {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory fact1 = DocumentBuilderFactory.newInstance();
            fact1.setValidating(true);
            fact1.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder1= fact1.newDocumentBuilder();
            String MailList = "MailList.xml";
            Document MailDoc = builder1.parse(new File(MailList));
            Element MailEle = MailDoc.getDocumentElement();
            NodeList mailNodes = MailEle.getChildNodes();
            for(int i = 0; i < mailNodes.getLength();i++){
                Element name =(Element) mailNodes.item(i);
                System.out.print("姓名:" + name.getTextContent() + "\t\t");
                System.out.println("电话:" + name.getAttribute("电话") + "\t\t" +
                                   "email:" + name.getAttribute("email") + "\t" +
                                   "住址:" + name.getAttribute("住址"));
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }
}