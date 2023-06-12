<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>过滤结果</title>
</head>
<body>
<h2>符合条件的数：</h2>
<%-- 使用 JSP 标签库将结果列表以直角三角形的形式输出 --%>
<c:forEach items="${filteredNumbers}" var="num" varStatus="status">
    <c:out value="${num} "/>
    <c:if test="${status.index % 10 == 9}">
        <br>
    </c:if>
    <c:if test="${status.count % 100 == 0}">
        <br>
    </c:if>
</c:forEach>
</body>
</html>
