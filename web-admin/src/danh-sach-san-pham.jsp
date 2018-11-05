<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%!
	int soDongTrang = 5, tongSoTrang, trang = 1, viTriDau;
%>
<c:forEach items="${dssp}" var="sp">
	<tr class="even">
	    <td>${sp.ma_san_pham}</td>
	    <td class="docSP"><a href="DocCTSanPham?id=${sp.ma_san_pham}">${sp.tenSanPham}</a></td>
	    <td>${sp.hangSanXuat }</td>
	    <td><f:formatNumber type="number" value="${sp.giaSanPham}"/>đ   </td>
	    <td>${sp.tinhTrang }</td>
	    <td>${sp.camera_truoc }</td>
	    <td>${sp.camera_sau }</td>
	    <td>${sp.dung_luong_pin }</td>
	    <td>${sp.mau_sac }</td>
	    <td>${sp.bao_mat }</td>
	    <td class="SX">
	        <a href="#">Sửa</a>
	    </td>
	    <td class="SX">
	        <a href="#">Xóa</a>
	    </td>
	</tr>
</c:forEach>
