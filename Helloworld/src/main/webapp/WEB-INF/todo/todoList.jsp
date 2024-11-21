<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>todoList 목록화면. </h1>
    <a href="/todo/register">글쓰기 폼이동</a>
<h2>더미 데이터 단순 출력</h2>
  <h3>list 전체 중에서 호출, list[0]</h3>
${list[0]}
  <h3>list 전체 중에서 호출, list[0].tno</h3>
  ${list[0].tno}
  <h3>list 전체 중에서 호출, list[0].title</h3>
  ${list[0].title}
  <h3>list 전체 호출</h3>
  ${list}
</body>
</html>
