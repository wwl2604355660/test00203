package demowork5;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
public class b extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {

        Random random = new Random();
        JspWriter out = getJspContext().getOut();
        int n = random.nextInt(30) + 1;
        int[] arr = new int[n];
        out.print("原始随机数组(" + n + "个元素) :");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100) + 1;
            out.print(arr[i] + " ");
        }
        Arrays.sort(arr);
        out.println("<br>");
        out.print("排序后的数组(" + n + "个元素) :");
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        return;
    }
}
