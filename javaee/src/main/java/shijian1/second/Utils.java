package shijian1.second;

import java.sql.Connection;
import java.sql.DriverManager;

//数据库链接的工具类型

public class Utils {

    //8.0版本获取数据库链接
    public static Connection getConnection2(){
        Connection con=null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库的链接
            String url="jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8&serverTimezone=UTC";
            String name="root";
            String pwd="07798958wwl";
            con=DriverManager.getConnection(url,name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
