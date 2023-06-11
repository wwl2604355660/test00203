package shijian1.second;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    private static Map<String, Book> book = new LinkedHashMap<String, Book>();
    static {
        book.put("1001", new Book("1001", "JAVA程序与设计","20"));
        book.put("1002", new Book("1002", "C语言","30"));
        book.put("1003", new Book("1003", "C++程序与设计","40"));
        book.put("1004", new Book("1004", "Python程序与设计","50"));
        book.put("1005", new Book("1005", "C#","60"));
        book.put("1006", new Book("1006", "Go语言","70"));
        book.put("1007", new Book("1007", "汇编语言","80"));
    }

    public static Collection<Book> getAll() {
        return book.values();
    }

    public static Book getbook(String id) {
        return book.get(id);
    }
}

