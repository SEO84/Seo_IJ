<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Member List</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
  <header>
    <h1>SEO Sports Center</h1>
    <nav>
      <a href="/member/register" class="btn-primary">멤버 등록</a>
      <a href="/member/read?mno=5" class="btn-secondary">멤버 상세보기</a>
    </nav>
  </header>

  <section class="member-list">
    <h2>Member List</h2>
    <!-- 테이블로 회원 정보 리스트 표시 -->
    <table class="member-table">
      <thead>
      <tr>
        <th>회원 번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>생일</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="dto" items="${list}">
        <tr class="member-item">
          <td class="member-id">${dto.mno}</td>
          <td class="member-name">
            <a href="/member/read?mno=${dto.mno}">${dto.name}</a>
          </td>
          <td class="member-email">${dto.email}</td>
          <td class="member-birth">${dto.birthDate}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>
</div>
</body>
</html>
