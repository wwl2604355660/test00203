<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>输入区间和过滤条件</title>
</head>
<body>
<h2>请输入起止区间和过滤条件：</h2>
<form action="${pageContext.request.contextPath}/filter" method="post">
    <table>
        <tr>
            <td>起始数：</td>
            <td><input type="number" name="start"></td>
        </tr>
        <tr>
            <td>结束数：</td>
            <td><input type="number" name="end"></td>
        </tr>
        <tr>
            <td>过滤条件：</td>
            <td><input type="number" name="condition" min="2" max="9"></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="查询">
</form>
</body>
</html>

