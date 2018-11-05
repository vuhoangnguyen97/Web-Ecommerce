<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>DANH SÁCH THÀNH VIÊN</title>
		<style type="text/css">
			table {
				width: auto;		
			}
			th{
				width: 200px;
			}
			td{
				width: 200px;
				
			}
			tr{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<table>
			<caption>
				DANH SÁCH THÀNH VIÊN
			</caption>
			<thead>
				<th>Mã khách hàng</th>
				<th>Username</th>
				<th>Password</th>
				<th>Tên khách hàng</th>
				<th>Số điện thoại</th>
				<th>Email</th>
				<th>Địa chỉ</th>
				<th>Quận</th>
				<th>Phường</th>
				<th>Thành phố</th>
				<th>Nước</th>
				<th>Zip code</th>
				<th><img alt="" src=""></th>
				<th><img src=""></th>
			</thead>
			<tbody>
				<c:forEach items="${danhSachThanhVien}" var="kh">
					<tr>
						<td>${kh.iduser}</td>
						<td>${kh.username}</td>
						<td>${kh.password}</td>
						<td>${kh.ho_user}  ${kh.ten_user}</td>
						<td>${kh.sdt}</td>
						<td>${kh.email}</td>
						<td>${kh.dia_chi}</td>
						<td>${kh.quan}</td>
						<td>${kh.phuong}</td>
						<td>${kh.thanh_pho}</td>
						<td>${kh.nuoc}</td>
						<td>${kh.zip_code}</td>
						<td><a href="#">Sửa</a></td>
						<td><a href="#">Xóa</a></td>
	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>