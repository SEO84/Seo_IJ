<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 20.
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--action : 서버에 전달할 경로, method 형식,--%>
<form action="calc_result.jsp" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit">전송</button>
</form>

</body>
</html>
