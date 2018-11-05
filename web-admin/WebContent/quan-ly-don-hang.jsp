<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff == null}">
		<jsp:include page="trang-nhan-vien"/>
	</c:if>
	<c:if test="${sessionScope.staff != null}">
		<!DOCTYPE html>
		<html>
		<head>
		    <meta charset="utf-8" />
		    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		    <title>Quản Lý Đơn Hàng</title>
			<link rel="icon" href="images/Logo.png" type="image/png" sizes="16x16">
		    
		    <meta name="viewport" content="width=device-width, initial-scale=1">
		    <link rel="stylesheet" type="text/css" media="screen" href="QLDH.css" />
		    <script src="QLDH.js"></script>
		    <script src="http://code.jquery.com/jquery-latest.js"></script>
		    
		</head>
		<body>
		    <div class="top">
		        <div class="container">
		            <div id="logo">
		                <h3>Quản Lý Đơn Hàng</h3>
		            </div>
		
		            <div id="nameNV"> 
		                <p>Xin chào </p>
		                <!--Tên nhân viên lấy từ CSDL-->
		                <p>${sessionScope.staff.ten_nhan_vien}</p>
		                <div class="dangxuat">
		                    <a href="DangXuat" class="logout">Đăng xuất</a>
		                </div>
		
		            </div>
		        </div>
		    </div>
		
		    <div class="trangkhac">
		        <div class="container">
		            
		        <div class="dieuhuong">
		            <a href="quan-ly-thanh-vien.jsp" target="blank">
		                <input type="button" class="QLTV" value="Quản Lý Thành Viên">
		            </a>
		        </div>
		
		        <div class="dieuhuong">
		            <a href="quan-ly-san-pham" target="blank">
		                <input type="button" class="QLSP" value="Quản Lý Sản Phẩm">
		            </a>
		        </div>
		        
		        <div class="dieuhuong">
		            <a href="quan-ly-nhan-vien" target="blank">
		                <input type="button" class="QLNV" value="Quản Lý Nhân Viên">
		            </a>
		        </div>
		
		        </div>
		
		
		
		
		    </div>
		
		    <div class="main">
		        <div class="container">
		            <div class="table">
		                <p class="title">
		                    DANH SÁCH ĐƠN HÀNG - Hiện có: ${sessionScope.size} đơn hàng.
		                	<br/><input type="button" onclick="location.href='thong-ke';" value="Xem thống kê" />
		
		                </p>
		                <table id="sp">
		                    <thead>
		                        <tr>
		                            <th>Mã đơn hàng</th>
		                            <th>Mã khách hàng</th>
		                            <th>Email</th>
		                            <th>Họ khách hàng</th>
		                            <th>Tên khách hàng</th>
		                            <th>Số điện thoại</th>
		                            <th>Địa chỉ</th>
		                            <th>Phường</th>
		                            <th>Quận</th>
		                            <th>Chi tiết đơn hàng</th>
		                        </tr>
		                    </thead>
		
		                    <tbody>
		                    	<jsp:include page="DocDonHang"/>                        
		                    </tbody>
		                </table>
		            </div>
		        </div>
		    </div>
		    <script>
			    setTimeout(function () {
			       window.location.reload();
			    }, 3000);
			</script>
		</body>
		</html>
	</c:if>
</c:if>