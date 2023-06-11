package shijian1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame {

    private JTextField textField1, textField2, textField3, textField4;
    private JTextArea textArea;
    private JButton btn;
    private JLabel jLabel1,jLabel2,jLabel3,jLabel4;

    public MyFrame() {
        setTitle("My Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 500));
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);

        jLabel1 = new JLabel("图书名称中包含:");
        jLabel2 = new JLabel("作者姓名中包含:");
        jLabel3 = new JLabel("图书ISBN中包含:");
        jLabel4 = new JLabel("出版社名称中包含:");

        btn = new JButton("确定!");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                String text3 = textField3.getText();
                String text4 = textField4.getText();
                File inputFile = new File("book.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                Document doc = null;
                try {
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    doc = dBuilder.parse(inputFile);
                    NodeList nList = doc.getElementsByTagName("图书");

                    //按图书名查询
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            if (eElement.getElementsByTagName("名称").item(0).getTextContent().contains(text1)
                                    && !text1.isEmpty()
                            || eElement.getElementsByTagName("作者").item(0).getTextContent().contains(text2)
                                    && !text2.isEmpty()
                            || eElement.getAttribute("ISBN").contains(text3)
                                    && !text3.isEmpty()
                            || eElement.getElementsByTagName("出版社").item(0).getTextContent().contains(text4)
                                    && !text4.isEmpty()) {
                                textArea.append("名称 : " + eElement.getElementsByTagName("名称").item(0).getTextContent()+"\n");
                                textArea.append("作者 : " + eElement.getElementsByTagName("作者").item(0).getTextContent()+"\n");
                                textArea.append("价格: " + eElement.getElementsByTagName("价格").item(0).getTextContent()+"\n");
                                textArea.append("出版时间 : " + eElement.getElementsByTagName("出版时间").item(0).getTextContent()+"\n");
                                textArea.append("出版社: " + eElement.getElementsByTagName("出版社").item(0).getTextContent()+"\n\n");
                            }
                        }
                    }
                } catch (Exception e1) {
                   e1.printStackTrace();
                }
            }
        });

        panel.add(jLabel1);
        panel.add(textField1);
        panel.add(jLabel2);
        panel.add(textField2);
        panel.add(jLabel3);
        panel.add(textField3);
        panel.add(jLabel4);
        panel.add(textField4);
        panel.add(btn);
        panel.add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException {
        MyFrame frame = new MyFrame();
    }


}