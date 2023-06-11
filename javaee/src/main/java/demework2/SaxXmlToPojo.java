package demework2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SaxXmlToPojo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // SAX解析
        // 1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        // 3.得到解读器
        XMLReader reader = parse.getXMLReader();
        // 4.设置内容处理器
        LuDengHandler LuDengHandler = new LuDengHandler();
        reader.setContentHandler(LuDengHandler);
        // 5.读取xml的文档内容
        reader.parse("ludeng.xml");

        List<LuDeng> LuDengs = LuDengHandler.getLuDengs();
        for (LuDeng LuDeng : LuDengs) {
            System.out.println("编号：" + LuDeng.getId() + " 位置：" + LuDeng.getAddress() + "  状态: " + LuDeng.getLudeng());
        }
    }

    static class LuDengHandler extends DefaultHandler {
        private List<LuDeng> LuDengs;
        private LuDeng LuDeng;
        private String tag; // 存储操作标签

        /**
         * @author lastwhisper
         * @desc 文档解析开始时调用，该方法只会调用一次
         * @param
         * @return void
         */
        @Override
        public void startDocument() throws SAXException {
            LuDengs = new ArrayList<LuDeng>();
        }

        /**
         * @author lastwhisper
         * @desc 标签（节点）解析开始时调用
         * @param uri xml文档的命名空间
         * @param localName 标签的名字
         * @param qName 带命名空间的标签的名字
         * @param attributes 标签的属性集
         * @return void
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tag = qName;

            if ("路灯".equals(tag)) {
                LuDeng = new LuDeng();
                LuDeng.setLudeng(attributes.getValue(0));
            }
        }

        /**
         * @author lastwhisper
         * @desc 解析标签的内容的时候调用
         * @param ch  字符
         * @param start 字符数组中的起始位置
         * @param length 要从字符数组使用的字符数
         * @return void
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String contents = new String(ch, start, length).trim();
            if ("编号".equals(tag)) {
                LuDeng.setId(contents);
            } else if ("位置".equals(tag)) {
                if (contents.length() > 0) {
                    LuDeng.setAddress(contents);
                }
            }
        }

        /**
         * @author lastwhisper
         * @desc 标签（节点）解析结束后调用
         * @param uri xml文档的命名空间
         * @param localName 标签的名字
         * @param qName 带命名空间的标签的名字
         * @return void
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("路灯".equals(qName)) {
                LuDengs.add(LuDeng);
            }
            tag = null;
        }

        public List<LuDeng> getLuDengs() {
            return LuDengs;
        }
    }
}
