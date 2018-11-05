<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.member != null}">
	<h1> Bạn không có quyền truy cập trang này!</h1>
</c:if>
<c:if test="${sessionScope.member == null}">
	<c:if test="${sessionScope.staff != null}">
		<jsp:include page="cong-viec.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.staff == null}">
		<h1> Chưa đăng nhập</h1>
		<a href="log-in-staff.jsp"> Tới trang đăng nhập </a> <br/>
	</c:if>
</c:if>
