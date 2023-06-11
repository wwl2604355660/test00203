package diyi;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class a extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取用户输入的自然数
        int n = Integer.parseInt(request.getParameter("n"));
        out.println(n+"*"+n+"矩阵");
        out.println("<html><head><title>Triangle Data</title></head>");
        out.println("<body>");


        out.println("<table>");
        for (int i = 1; i <= n; i++) {
            out.print("<tr bgcolor=\"" + ((i % 2 == 0) ? "#dddddd" : "#ffffff") + "\">");
            for (int j = 1; j <= i; j++) {
                out.print("<td>" + calcTriangle(i, j) + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</body></html>");
        out.close();
    }

    // 计算三角形数据
    private int calcTriangle(int row, int col) {
        if (col == 1 || col == row) {
            return 1;
        } else {
            return calcTriangle(row - 1, col - 1) + calcTriangle(row - 1, col);
        }
    }
}