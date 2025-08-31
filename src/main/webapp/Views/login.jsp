<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="max-width: 400px; margin-top: 100px;">
        <h2 class="text-center">Đăng nhập</h2>

        <!-- Hiển thị thông báo nếu có -->
        <c:if test="${alert != null}">
            <h4 class="alert alert-danger text-center">${alert}</h4>
        </c:if>
        <% String successMsg = (String) session.getAttribute("success");
	   if(successMsg != null) { %>
	   <div class="alert alert-success"><%= successMsg %></div>
	   <% session.removeAttribute("success"); } %>
        
        <!-- Form đăng nhập -->
        <form action="login" method="post">
            <div class="form-group">
                <label>Tài khoản</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" name="username" class="form-control" placeholder="Nhập tài khoản">
                </div>
            </div>

            <div class="form-group">
                <label>Mật khẩu</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu">
                </div>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
            <br>
            <p class="text-center">
    			Chưa có tài khoản? <a href="Views/register.jsp">Đăng ký ngay</a>
			</p>
        </form>
    </div>
</body>
</html>