<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items = "${dsnv}" var = "nv">	
	<tr>
        <td>${nv.idnhan_vien}</td>
        <td>${nv.username}</td>
        <td>${nv.password}</td>
        <td>${nv.ho_nhan_vien}</td>
        <td>${nv.ten_nhan_vien}</td>
        <td>${nv.chuc_vu}</td>
        <td>${nv.email}</td>
        <td>${nv.sdt}</td>
        <td class="SX">
            <a href="chiTietNhanVien?id=${nv.idnhan_vien}">
            	<input type="button" value="Sửa" class="xoa">
            </a>
        </td>
        <td class="SX">
           	<input type="button" value="Xóa" class="xoa" onclick="xoa()">
            <!--<a href="#" onclick="xoa()">Xóa</a>  -->
        </td>
    </tr>
    
    
    
</c:forEach>