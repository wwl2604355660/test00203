package demowork3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/demo1")
public class a extends HttpServlet
{
    public void quicksort(int[] a, int low, int high) {
        int i,j;
        if (low>high) {
            return;
        }
        i=low;
        j=high;
        int temp=a[low];
        while(i<j){
            while ( temp<=a[j] && i<j) {
                j--;
            }
            while ( temp>=a[i] && i<j) {
                i++;
            }
            if (i<j) {
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        a[low]=a[i];
        a[i]=temp;
        quicksort(a, low, j-1);
        quicksort(a, j+1, high);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8") ;
        Random random=new Random();
        int randomValue=random.nextInt(30)+1;
        PrintWriter out = response.getWriter();
        int [] arr = new int[randomValue];
        out.print("原始随机数组(" + randomValue + "个元素) :");
        for (int i = 0; i < randomValue; i++){
            arr[i] = random.nextInt(100) + 1;
            out.print(arr[i] + " ");
        }
        out.println("<br>");
        out.print("排序后的数组(" + randomValue + "个元素) :");
        quicksort(arr,0,arr.length-1);
        for (int i = 0; i < randomValue; i++){
            out.print(arr[i] + " ");
        }
        out.flush();
        out.close();
    }



}

