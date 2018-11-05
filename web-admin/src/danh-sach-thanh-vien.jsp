<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items = "${dstv}" var = "tv">
	<tr class="even">
	    <td>${tv.iduser}</td>
	    <td>${tv.username}</td>
	    <td>${tv.password}</td>
	    <td><a href="DocCTThanhVien?id=${tv.iduser}">${tv.ten_user}</a></td>
	    <td>${tv.sdt}</td>
	    <td>${tv.email}</td>
	    <td>${tv.dia_chi}</td>
	    <td>${tv.phuong}</td>
	    <td>${tv.quan}</td>
	    <td>${tv.thanh_pho}</td>
	    <td>${tv.nuoc}</td>
	    <td>${tv.zip_code}</td>
	    <td class="SX">
	        <a href="quan-ly-thanh-vien.jsp">Sửa</a>
	    </td>
	    <td class="SX">
	            <a href='XoaThanhVien?id=${tv.iduser}'>Xóa</a>
	    </td>
	</tr>
</c:forEach>