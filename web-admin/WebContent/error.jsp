<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        	<c:if test = '${id_loi==1}'>
            	<p class="p" id="p1"><strong><div style='font-size: 60px;' class="animated infinite bounce faster delay-2s" >Lỗi trùng tên hoặc mã loại thẻ!</div></strong></p>
            </c:if>
            <c:if test='${id_loi==2}'>
        	    <p class="p" id="p1"><strong><div style='font-size: 60px;' class="animated infinite bounce faster delay-2s" >Lỗi hệ thống, thử lại sau!</div></strong></p>            	
            </c:if>
             <c:if test='${id_loi==3}'>
        	    <p class="p" id="p1"><strong><div style='font-size: 60px;' class="animated infinite bounce faster delay-2s" >Lỗi server cơ sở dữ liệu!</div></strong></p>            	
            </c:if>
        </div>

        <div class="main">
            <form action="#" method="POST" name="login">

                <a href="thongKeThe">
                    <input type="button" value="Trở về trang thống kê thẻ" class="chuyentrang">
                </a>


            </form>
        </div>
    </div>
</body>
</html>