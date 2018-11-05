<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" media="screen" href="MoiLogin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <title>Yêu cầu đăng nhập</title>
</head>
<body>
    <div class="container">
        <div class="top">
            <p class="p" id="p1"><strong><div style='font-size: 60px;' class="animated infinite bounce faster delay-2s" >Nhân viên chưa đăng nhập!</div></strong></p>
            
        </div>

        <div class="main">
            <form action="#" method="POST" name="login">
	            <c:if test="${sessionScope.member != null}">
					<h1> Bạn không có quyền truy cập trang này!</h1>
				</c:if>
				<c:if test="${sessionScope.member == null}">
					<c:if test="${sessionScope.staff != null}">
						<jsp:include page="cong-viec.jsp"></jsp:include>
					</c:if>
					<c:if test="${sessionScope.staff == null}">
						<a href="log-in-staff.jsp">
							<input type="button" value="Tới trang đăng nhập" class="chuyentrang">
						</a>
					</c:if>
				</c:if>
                <a href="index.jsp">
                    <input type="button" value="Trở về trang mua sắm" class="chuyentrang" id="back">
                </a>
            </form>
        </div>
    </div>
</body>
</html>



