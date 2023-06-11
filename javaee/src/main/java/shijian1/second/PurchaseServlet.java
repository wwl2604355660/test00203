package shijian1.second;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id == null) {
            // 如果id为null，重定向到ListBookServlet页面
            String url = "shopping";
            resp.sendRedirect(url);
            return;
        }
        Book book = BookDB.getbook(id);
        HttpSession session = req.getSession();
        List<Book> cart = (List) session.getAttribute("carts");
        if (cart == null) {
            cart = new ArrayList<Book>();
            session.setAttribute("carts", cart);
        }
        cart.add(book);
        String url = "shijian1_2.jsp";
        resp.sendRedirect(url);
    }
}

