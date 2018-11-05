<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>DANH SÁCH ĐƠN HÀNG</title>
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
			tr:nth-child(even) {background-color: #f2f2f2}
		</style>
	</head>
	<body>
		<table>
			<caption>
				DANH SÁCH ĐƠN HÀNG
			</caption>
			<thead>
				<th>Mã sản phẩm</th>
				<th>Mã khách hàng</th>
				<th>Email liên lạc </th>
				<th>Tên khách hàng </th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Quận </th>
				<th>Phường</th>
				<th>Chi tiết đơn hàng</th>
				<th><img alt="" src=""></th>
				<th><img src=""></th>
			</thead>
			<tbody>
				<c:forEach items="${dshd}" var="hd">
					<tr>
						<td>${hd.id_giohang}</td>
						<td>${hd.id_user}</td>
						<td>${hd.email}</td>
						<td>${hd.ho_user}  ${hd.ten_user }</td>
						<td>${hd.sdt}	</td>
						<td>${hd.diaChi}</td>
						<td>${hd.quan}</td>
						<td>${hd.phuong}</td>
						<td>${hd.chiTiet}</td>
						<td><a href="#">Sửa</a></td>
						<td><a href="#">Xóa</a></td>
	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>