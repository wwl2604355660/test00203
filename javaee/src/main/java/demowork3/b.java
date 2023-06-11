package demowork3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/demo2")
public class b extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("hhhhhh");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        Random random = new Random();
        int randomValue = random.nextInt(30) + 1;
        PrintWriter out = response.getWriter();
        int[][] arr = new int[randomValue][randomValue];
        out.print(randomValue + "*" + randomValue + "二维数组:");
        out.print("<br>");
        arr[0][0] = 1;
        int num = 1;
        int m,n;
        for(int i = 1;i<randomValue;i++){
            if(i %2 != 0){
                m = 0;
                n = i;
                while(m <= i){
                    arr[m++][n] = ++num;
                }
                m--;
                while(--n >= 0){
                    arr[m][n] = ++num;
                }

            }else{
                m = i;
                n = 0;
                while(n <= i){
                    arr[m][n++] = ++num;
                }
                n--;
                while(--m >= 0){
                    arr[m][n] = ++num;
                }
            }
        }
        out.println("<table>");
        for (int i = 0;i<randomValue;i++){
            out.println("<tr align='center'>");
            for (int j=0;j<randomValue;j++){
                out.printf("<td width='30px'>");
                out.println(arr[i][j]);
                out.printf("</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.flush();
        out.close();
    }
}
