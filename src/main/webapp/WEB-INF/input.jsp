
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>传递数据到Out</title></head>
<body>

<form action="add" method="get">
    第一个数：<input type="text" name="input1"><br/>
    第二个数：<input type="text" name="input2"><br/>
    第三个数：<input type="text" name="input3"><br/>
    <input type="submit" value="计算">
</form>
两个复数运算结果:(${a1},${a2}i) (${b1},${b2}i) (${c1},${c2}i) (${d1},${d2}i)
</body>
</html>
