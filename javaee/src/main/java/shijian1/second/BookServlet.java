package shijian1.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/shopping")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("<h2>欢迎来到书店：</h2><br>");
        Collection<Book> books = BookDB.getAll();
        out.write("本站提供的书本有：<br>");
        for (Book book : books) {
            String url = "purchase?id=" + book.getId();
            out.write(book.getName() + "<a href='" + url
                    + "'>点击购买</a><br>");
        }
    }

}

