<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 등록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles4.css">
</head>
<body>
<div class="container">
    <header>
        <h1>회원 등록</h1>
    </header>

    <!-- 회원 등록 폼 -->
    <div class="member-form">
        <form action="/member/register" method="post">
            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" name="name" placeholder="이름을 입력해 주세요.">
            </div>
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" name="email" placeholder="이메일을 입력해 주세요.">
            </div>
            <div class="form-group">
                <label for="birthDate">생일:</label>
                <input type="date" name="birthDate">
            </div>
            <div class="form-group btn-group">
                <button type="reset" class="btn-reset">초기화</button>
                <button type="submit" class="btn-submit">등록하기</button>
            </div>
        </form>
    </div>

    <!-- 회원 목록으로 돌아가기 -->
    <div class="back-link">
        <a href="/member/list" class="btn-back">회원 목록으로 돌아가기</a>
    </div>
</div>
</body>
</html>
