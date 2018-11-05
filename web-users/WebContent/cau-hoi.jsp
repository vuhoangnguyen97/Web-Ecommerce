<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.gioHang != null}">
	<jsp:include page="/gioHangServlet"></jsp:include>
</c:if>
<c:if test="${sessionScope.gioHang == null}">
	<jsp:include page="/Views/trang-dau.jsp"></jsp:include>
</c:if>
<jsp:include page="Views/noi-dung-cau-hoi.jsp"></jsp:include>

<jsp:include page="Views/trang-cuoi.jsp"></jsp:include>