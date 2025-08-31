<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <h2 class="mb-4">Tạo tài khoản mới</h2>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="mb-3">
            <label class="form-label">Tài khoản</label>
            <input type="text" name="username" class="form-control" placeholder="Nhập tài khoản" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" placeholder="Nhập email" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" name="phone" class="form-control" placeholder="Nhập số điện thoại" required>
        </div>

        <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
    </form>

</body>
</html>
