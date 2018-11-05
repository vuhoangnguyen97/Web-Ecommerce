<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="special-deal leftbar">
                <h4 class="title">
                  Sản Phẩm 
                  <strong>
                    Đặc Biệt
                  </strong>
                </h4>
                <c:forEach items="${spnoibat}" var="sp_noibat">
	                <div class="special-item">
	                  <div class="product-image">
	                    <a href="xemChiTietSanPhamServlet?id=${sp_noibat.ma_san_pham}">
	                      <img src="data:image/jpeg;base64,${sp_noibat.hinh_anh}" alt="">
	                    </a>
	                  </div>
	                  <div class="product-info">
	                    <p>
	                        ${sp_noibat.tenSanPham}
	                    </p>
	                    <h5 class="price">
	                     <f:formatNumber type="number" value="${sp_noibat.giaSanPham }" /> ₫
	                    </h5>
	                  </div>
	                </div>
                </c:forEach>
               
              </div>