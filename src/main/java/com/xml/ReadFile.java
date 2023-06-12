package com.xml;
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
            content = new String(ch, start, length).trim();
            System.out.println("<" + tag + ">" + content);
        }
    }

    public static void main(String argv[]) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ReadFile reader = new ReadFile();
            parser.parse(new File("aa.xml"), reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

