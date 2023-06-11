
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>购物车</title>
</head>
<body>
<h1>购物车</h1>
<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  <c:forEach items="${carts}" var="crat">
    <tr align="center">
      <td>${crat.id}</td>
      <td>${crat.name}</td>
      <td>${crat.price}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
