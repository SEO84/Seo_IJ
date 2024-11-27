<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 수정</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles3.css">
</head>
<body>
<div class="container">
    <header>
        <h1>회원 수정 화면</h1>
    </header>

    <!-- 회원 수정 폼 -->
    <div class="member-form">
        <form action="/member/update" method="post">
            <div class="form-group">
                <input type="hidden" name="mno" value="${dto.mno}">
            </div>
            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" name="name" value="${dto.name}" placeholder="이름을 입력해 주세요.">
            </div>
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" name="email" value="${dto.email}" placeholder="이메일을 입력해 주세요.">
            </div>
            <div class="form-group">
                <label for="birthDate">생일:</label>
                <input type="date" name="birthDate" value="${dto.birthDate}">
            </div>
            <div class="form-group">
                <label for="active">활성화:</label>
                <input type="checkbox" name="active" ${dto.active ? "checked" : ""}>
            </div>
            <div class="form-group">
                <button type="submit" class="btn-submit">수정하기</button>
            </div>
        </form>
    </div>

    <!-- 회원 삭제 폼 -->
    <div class="member-form">
        <form action="/member/delete" method="post">
            <input type="hidden" name="mno" value="${dto.mno}">
            <button type="submit" class="btn-delete">삭제하기</button>
        </form>
    </div>

    <!-- 링크로 목록으로 돌아가기 -->
    <div class="back-link">
        <a href="/member/list" class="btn-back">회원 목록으로 돌아가기</a>
    </div>
</div>
</body>
</html>
