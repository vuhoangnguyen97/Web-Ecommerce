<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>DANH SÁCH SẢN PHẨM</title>
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
				DANH SÁCH SẢN PHẨM
			</caption>
			<thead>
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Hãng sản phẩm</th>
				<th>Giá sản phẩm</th>
				<th>Tình trạng</th>
				<th>Camera trước</th>
				<th>Camera sau</th>
				<th>Dung lượng pin</th>
				<th>Màu sắc</th>
				<th>Bảo mật</th>
				<th><img alt="" src=""></th>
				<th><img src=""></th>
			</thead>
			<tbody>
				<c:forEach items="${danhSachSanPham}" var="sp">
					<tr>
						<td>${sp.ma_san_pham}</td>
						<td>${sp.tenSanPham}</td>
						<td>${sp.hangSanXuat}</td>
						<td><f:formatNumber type="number" value="${sp.giaSanPham}" /> </td>
						<td>${sp.tinhTrang}	</td>
						<td>${sp.camera_truoc}</td>
						<td>${sp.camera_sau}</td>
						<td>${sp.dung_luong_pin}</td>
						<td>${sp.mau_sac}</td>
						<td>${sp.bao_mat}</td>
						<td><a href="#">Sửa</a></td>
						<td><a href="#">Xóa</a></td>
	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>