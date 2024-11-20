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
<%--쿼리 스트링으로 전달된 데이터의 타입은 항상 문자열, --%>
<%--처리시, 중간에서 변환 작업이 필요함. --%>
<%--화면에서, 자바 코드를 주입해서 작업하기 보다는, --%>
<%--서블릿 파일에서 작업하고, html 코드와, 자바 코드를 분리하자. 최대한. --%>
<%--유지보수, 가독성. --%>
<%--<form action="calc_result.jsp" method="post">--%>
<form action="/calc/result" method="post">
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit">전송</button>
</form>

</body>
</html>
