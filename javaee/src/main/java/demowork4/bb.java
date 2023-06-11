package demowork4;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class bb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8") ;
        PrintWriter out = resp.getWriter();
        int sum =  Integer.parseInt(req.getParameter("sum"));
        if(sum%2 == 0){
            sum++;
            out.println("图案菱形(" + sum + ") <br>");
        }else{
            out.println("图案菱形(" + sum + ") <br>");
        }
        sum =  sum/2 + 1;
        for (int i=1;i<=sum;i++){
            for (int j=1;j<=sum-i;j++){
                out.println("&nbsp;");
            }
            for (int k=1;k<=i;k++){
                out.println("*");
            }
            for (int n=i-1;n>=1;n--){
                out.println("*");
            }
           out.println("<br>");
        }

        for (int i=1;i<sum;i++){

            for (int j=1;j<=i;j++){
                out.println("&nbsp;");
            }
            for (int k=1;k<=sum-i;k++){
                out.println("*");
            }
            for (int n=sum-1-i;n>0;n--){
                out.println("*");
            }
            out.println("<br>");
        }

    }
}
