<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>jdbcex - todo의 글쓰기 폼 화면</h1>
<form action="/todo/register2" method="post">
    <div>
        <input type="text" name="title" placeholder="제목 입력 해주세요.">
    </div>
    <div>
        <input type="date" name="dueDate">
    </div>
    <button type="reset">초기화</button>
    <button type="submit">등록</button>
</form>
</body>
</html>
