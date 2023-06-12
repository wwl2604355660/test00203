package com.xml;

import java.sql.*;

/**
 * @author wwl
 * @create 2023-06-12 10:59
 */
public class OperDB {

    // 数据库连接信息
    private static final String URL = "jdbc:mysql://localhost:3306/test_tb_char";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "07798958wwl";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        System.out.println("插入前");
        query(conn);
        insert(conn, "110","user1","女" ,20,"哈尔滨理工大学");
        System.out.println("插入后");
        query(conn);
        conn.close();
    }


    public static void insert(Connection conn, String id,String name,String sex, int age,String address) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tb_emp(id,Name,sex,age,address) VALUES(?,?,?,?,?)");
        pstmt.setString(1,id);
        pstmt.setString(2, name);
        pstmt.setString(3,sex);
        pstmt.setInt(4, age);
        pstmt.setString(5,address);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public static void query(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM tb_emp");
        while (rs.next()) {
            String name = rs.getString("Name");
            String sex = rs.getString("sex");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            System.out.println("name: " + name + ", age: " + age);
        }
        rs.close();
        stmt.close();
    }

}
