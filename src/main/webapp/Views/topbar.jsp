<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<!-- Font Awesome -->
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<!-- Bootstrap -->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <div class="col-sm-6">
        <ul class="list-inline right-topbar pull-right">
            <c:choose>
                <%-- Nếu chưa đăng nhập --%>
                <c:when test="${sessionScope.account == null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/login">Đăng nhập</a> | 
                        <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
                    </li>
                </c:when>

                <%-- Nếu đã đăng nhập --%>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.contextPath}/member/myaccount">
                            ${sessionScope.account.fullName}
                        </a> | 
                        <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <li><i class="search fa fa-search search-button"></i></li>
        </ul>
    </div>
</body>
</html>
