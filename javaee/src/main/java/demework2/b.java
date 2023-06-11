package demework2;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import javax.xml.parsers.*;

public class b extends DefaultHandler {
    protected boolean id;
    protected boolean address;
    protected StringBuffer suid;
    protected StringBuffer suaddress;
    public static void main(String[] args) {

        try {
            SAXParserFactory fact1 = SAXParserFactory.newInstance();
            fact1.setValidating(true);
            SAXParser build1 = fact1.newSAXParser();
            String ludeng = "ludeng.xml";
            b event = new b();
            build1.parse(new File(ludeng),event);

        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(2);
        }
    }

    public void startElement(String uri,String localName,String qName,Attributes attributes){
        if(qName.compareTo("路灯") ==0){
            suid = null;
            suaddress = null;
        }else if(qName.compareTo("编号") ==0){
            id = true;
            suid = new StringBuffer();
        }else if(qName.compareTo("位置") ==0){
            address = true;
            suaddress = new StringBuffer();
        }
    }

    public void ludengs(char[] cha,int start,int length){
        if(id){
            suid.append(cha,start,length);
        }else if(address){
            suaddress.append(cha,start,length);
        }
    }

    public void endElement(String namespaceURI,String localName,String qName){
        if(qName.equals("路灯")){
            System.out.println("路灯:");
            if(suid != null){
                System.out.print(suid.toString() + " ");
                System.out.println("1111");
            }
            if(suaddress != null){
                System.out.print(suaddress.toString());
            }
            System.out.println();
        }else if(qName.compareTo("编号") ==0){
            id = false;
        }else if(qName.compareTo("位置") ==0){
            address = false;
        }
    }
}