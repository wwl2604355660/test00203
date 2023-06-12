<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>过滤结果</title>
</head>
<body>
<h2>符合条件的数：</h2>
<ul>
    <c:forEach items="${filteredNumbers}" var="num">
        <li>${num}</li>
    </c:forEach>
</ul>
</body>
</html>
