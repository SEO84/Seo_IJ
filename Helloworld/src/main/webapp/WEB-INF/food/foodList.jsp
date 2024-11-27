<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 사용하기 준비 단계--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>foodList 목록화면. </h1>
    <a href="/food/register">글쓰기 폼이동</a>
  <h2>foodRead 하나 조회 더미 </h2>
  <a href="/food/read?fno=5">하나 조회</a>

  <h2>JSTL 연습장</h2>
  <h3>반복문, forEach 이용, var=변수명, items="데이터 목록" , 더 많이 사용함</h3>
  <ul>
    <c:forEach var="dto" items="${list}">
      <li>
        <span>${dto.fno}</span>
        <span><a href="/food/read?fno=${dto.fno}">${dto.title}</a></span>
        <span>${dto.dueDate}</span>
        <span>${dto.finished? "완료": "미완료"}</span>
      </li>
    </c:forEach>
  </ul>
</body>
</html>
