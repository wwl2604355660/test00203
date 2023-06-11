<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/29
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <c:if test="${str == 1}">
        前两个元素不足!
    </c:if>
    <c:if test="${str == 2}">
        <table>
            <tr>
            <c:forEach begin="0" end="${sum}" step="1" var="i">
                <td width="30px" style="text-align: right">${arr3[i]}</td>
                <c:if test="${ (i + 1) % num == 0}">
                </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${str == 3}">
        给定的前两个元素的数据格式不正确!
    </c:if>
</head>
<body>

</body>
</html>
