<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
</head>
<body>
<div class="container" style="max-width: 400px; margin-top: 100px;">
    <h2 class="text-center">Quên mật khẩu</h2>

    <c:if test="${alert != null}">
        <h4 class="alert alert-info text-center">${alert}</h4>
    </c:if>

    <form action="forgot-password" method="post">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" class="form-control" placeholder="Nhập email của bạn">
        </div>
        <button type="submit" class="btn btn-primary btn-block">Lấy lại mật khẩu</button>
    </form>

    <p class="text-center"><a href="login">Quay lại đăng nhập</a></p>
</div>
</body>
</html>
