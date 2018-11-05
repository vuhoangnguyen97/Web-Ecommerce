<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${dsdh}" var="dh"> 
	<tr class="even">
	    <td>${dh.ma_don_hang}</td>
	    <td>${dh.ma_khach_hang}</td> 
	    <td>${dh.email}</td>
	    <td>${dh.ho_user}</td>
	    <td>${dh.ten_user}</td>
	    <td>${dh.sdt}</td>
	    <td>${dh.diaChi}</td>
	    <td>${dh.phuong}</td>
	    <td>${dh.quan}</td>
	    <td>${dh.chi_tiet}</td>
	</tr>
</c:forEach>   