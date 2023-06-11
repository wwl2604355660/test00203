<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/27
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="aaa.User" %>
<%
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    User user = new User(name, age);
    user.processData();
%>
