package shijian1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

@WebServlet("/shijian1_1")
public class a extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8") ;
            PrintWriter out = resp.getWriter();
            String str1 = req.getParameter("a");
            str1 = new String(str1.getBytes("ISO-8859-1"),"UTF-8");
            String str2 = req.getParameter("XMLParser");
            str2 = new String(str2.getBytes("ISO-8859-1"),"UTF-8");
            String str3 = req.getParameter("c");
            str3 = new String(str3.getBytes("ISO-8859-1"),"UTF-8");
            String str4 = req.getParameter("d");
            str4 = new String(str4.getBytes("ISO-8859-1"),"UTF-8");
            File inputFile = new File("book.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            NodeList nList = doc.getElementsByTagName("图书");

            //按图书名查询
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getElementsByTagName("名称").item(0).getTextContent().contains(str1)
                            && !str1.isEmpty()) {
                        out.println("名称 : " + eElement.getElementsByTagName("名称").item(0).getTextContent()+ "<br>");
                        out.println("作者 : " + eElement.getElementsByTagName("作者").item(0).getTextContent()+ "<br>");
                        out.println("价格: " + eElement.getElementsByTagName("价格").item(0).getTextContent()+ "<br>");
                        out.println("出版时间 : " + eElement.getElementsByTagName("出版时间").item(0).getTextContent()+ "<br>");
                        out.println("出版社: " + eElement.getElementsByTagName("出版社").item(0).getTextContent()+ "<br>");
                    }
                }
            }

            //按作者名查询
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getElementsByTagName("作者").item(0).getTextContent().startsWith(str2)
                            && !str2.isEmpty()){
                        out.println("名称 : " + eElement.getElementsByTagName("名称").item(0).getTextContent() + "<br>");
                        out.println("作者 : " + eElement.getElementsByTagName("作者").item(0).getTextContent() + "<br>");
                        out.println("价格: " + eElement.getElementsByTagName("价格").item(0).getTextContent() + "<br>");
                        out.println("出版时间 : " + eElement.getElementsByTagName("出版时间").item(0).getTextContent() + "<br>");
                        out.println("出版社: " + eElement.getElementsByTagName("出版社").item(0).getTextContent() + "<br>");
                    }
                }
            }

            //按出版社名查询
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getElementsByTagName("出版社").item(0).getTextContent().contains(str4)
                            && !str4.isEmpty()){
                        out.println("名称 : " + eElement.getElementsByTagName("名称").item(0).getTextContent()+ "<br>");
                        out.println("作者 : " + eElement.getElementsByTagName("作者").item(0).getTextContent()+ "<br>");
                        out.println("价格: " + eElement.getElementsByTagName("价格").item(0).getTextContent()+ "<br>");
                        out.println("出版时间 : " + eElement.getElementsByTagName("出版时间").item(0).getTextContent()+ "<br>");
                        out.println("出版社: " + eElement.getElementsByTagName("出版社").item(0).getTextContent()+ "<br>");
                        out.println("***********************");
                    }
                }
            }

            //按ISBN查询
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("ISBN").contains(str3)
                            &&!str3.isEmpty()){
                        out.println("名称 : " + eElement.getElementsByTagName("名称").item(0).getTextContent()+ "<br>");
                        out.println("作者 : " + eElement.getElementsByTagName("作者").item(0).getTextContent()+ "<br>");
                        out.println("价格: " + eElement.getElementsByTagName("价格").item(0).getTextContent()+ "<br>");
                        out.println("出版时间 : " + eElement.getElementsByTagName("出版时间").item(0).getTextContent()+ "<br>");
                        out.println("出版社: " + eElement.getElementsByTagName("出版社").item(0).getTextContent()+ "<br>");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}