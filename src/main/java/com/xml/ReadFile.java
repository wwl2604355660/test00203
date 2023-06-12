package com.xml;

/**
 * @author wwl
 * @create 2023-06-12 10:54
 */
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class ReadFile extends DefaultHandler {
    private String content;
    private String tag;
    private int level;

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        level++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tag = "";
        level--;
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (tag.equals("url") || tag.equals("user") || tag.equals("password")) {
            // 解析到指定标签时，获取其文本内容
            content = new String(ch, start, length).trim();
            // 输出文本内容
            System.out.println("<" + tag + ">" + content);
        }
    }

    public static void main(String argv[]) {
        try {
            // 创建解析器工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 创建解析器对象
            SAXParser parser = factory.newSAXParser();
            // 创建解析类实例
            ReadFile reader = new ReadFile();
            // 开始解析 XML 文档
            parser.parse(new File("aa.xml"), reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

