<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member Detail</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles2.css">
</head>
<body>
<div class="container">
    <header>
        <h1>멤버 상세보기</h1>
    </header>

    <div class="member-detail">
        <form>
            <div class="form-group">
                <label for="mno">Member Number</label>
                <input type="text" id="mno" value="${dto.mno}" readonly>
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" value="${dto.name}" readonly>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" id="email" value="${dto.email}" readonly>
            </div>
            <div class="form-group">
                <label for="birthDate">Birth Date</label>
                <input type="date" id="birthDate" value="${dto.birthDate}" readonly>
            </div>
            <div class="form-group">
                <label for="active">Active Status</label>
                <input type="checkbox" id="active" ${dto.active ? "checked" : ""} disabled>
            </div>
        </form>
        <div class="action-buttons">
            <a href="/member/update?mno=${dto.mno}" class="btn-edit">수정/삭제</a>
            <a href="/member/list" class="btn-back">목록</a>
        </div>
    </div>
</div>
</body>
</html>
