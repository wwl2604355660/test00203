package demowork4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class aa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8") ;
        PrintWriter out = resp.getWriter();
        long sum =  Long.parseLong(req.getParameter("sum"));
        long num = Long.parseLong(req.getParameter("num"));
        long i,t1 = 1,t2 = 1,m;
        int k = 0;
        out.println("<table>");
        out.println("<tr align='center'>");
        for (i = 1; i <= sum; ++i){
            if(k == 6){
                k = 0;
                out.println("</tr>");
                out.println("<tr align='center'>");
            }
            out.println("<td style='text-align: right'>" + t1 + "</td>");
            m = t1 + t2;
            t1 = t2;
            t2 = m;
            k++;
        }
        out.println("</tr>");
        out.println("</table>");
    }
}
