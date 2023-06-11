package demowork5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class a extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String[] arr1;
        String fenge = " ";
        arr1 = a.split(fenge);
        int[] arr2 = new int[arr1.length];
        int sum = Integer.parseInt(req.getParameter("sum"));
        int num = Integer.parseInt(req.getParameter("num"));
        int[] arr3 = new int[sum];
        int str = 0;
        System.out.println(a);

        if (arr2.length < 2){
            str = 1;
        }else if(arr2.length ==2 &&arr1[0].matches("[0-9]+") && arr1[1].matches("[0-9]+")){
            for (int i=0;i<arr1.length;i++){
                arr2[i] = Integer.parseInt(arr1[i]);
            }
            int d = arr2[1] - arr2[0];
            for (int i = 0; i < sum; i++) {
                arr3[i] = arr2[0] + i * d;
            }
            str = 2;
        } else {
            str = 3;
        }

        req.setAttribute("arr3",arr3);
        req.setAttribute("sum",sum);
        req.setAttribute("num",num);
        req.setAttribute("str",str);
        req.getRequestDispatcher("demo5_a2.jsp").forward(req,resp);

    }
}

