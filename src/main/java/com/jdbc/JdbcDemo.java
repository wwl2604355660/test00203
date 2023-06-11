package com.jdbc;

import java.sql.*;

public class JdbcDemo {
    // 数据库连接信息
    private static final String URL = "jdbc:mysql://localhost:3306/kaoshi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "07798958wwl";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载 JDBC 驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取数据库连接
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 插入操作
//        insert(conn, "user1", 20);

        // 查询操作
        query(conn);

        // 更新操作
//        update(conn, "user1", 25);

        // 删除操作
//        delete(conn, "user1");

        // 关闭数据库连接
        conn.close();
    }

    // 插入操作
    public static void insert(Connection conn, String name, int age) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user(name, age) VALUES(?, ?)");
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.executeUpdate();
        pstmt.close();
    }

    // 查询操作
    public static void query(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("name: " + name + ", age: " + age);
        }
        rs.close();
        stmt.close();
    }

    // 更新操作
    public static void update(Connection conn, String name, int age) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET age = ? WHERE name = ?");
        pstmt.setInt(1, age);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        pstmt.close();
    }

    // 删除操作
    public static void delete(Connection conn, String name) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE name = ?");
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        pstmt.close();
    }
}

