<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>jdbcex 작업 중. tno 번호로 수정화면 역할. </h1>
    <form action="/todo/update?tno=${dto.tno}" method="post">
    <div>
        <input type="text" name="tno" value="${dto.tno}" readonly>
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}" placeholder="제목 입력 해주세요." >
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} >
    </div>
<div>
    <button type="submit">수정하기</button>
    <br>
    <a href="/todo/delete?tno=${dto.tno}">삭제</a>
    <a href="/todo/list2">목록가기</a>
</div>
    </form>
</body>
</html>
