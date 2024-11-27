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
<h1>미니실습 작업 중. fno 번호로 하나 조회하는 화면, 상세보기와 같은 역할. </h1>
<div>
    <input type="text" name="fno" value="${dto.fno}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" placeholder="제목 입력 해주세요." readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
</div>
<div>
    <a href="/food/update?fno=${dto.fno}">수정/삭제</a>
    <a href="/food/list">목록가기</a>
</div>
</body>
</html>
