<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="productsDetails" class="hot-products">
                <h3 class="title">
                  <strong>
                    Sản Phẩm Hot
                  </strong>
                </h3>
                <div class="control">
                  <a id="prev_hot" class="prev" href="#" style="display: block;">
                   &lt;
                 </a>
                 <a id="next_hot" class="next" href="#" style="display: block;">
                   &gt;
                 </a>
               </div>
               <div class="caroufredsel_wrapper" style="display: block; text-align: start; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 698px; height: 475px; margin: 0px; overflow: hidden;"><ul id="hot" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 4886px; height: 475px; z-index: auto;">
                 
                 
                 
               <li style="width: 698px;">
                   <div class="row">
                   	<c:forEach items="${dssp_hot}" var="sp">
	                     <div class="col-md-4 col-sm-4">
	                       <div class="products">
	                                <div class="offer">Trả góp 0%</div>
	                                <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${sp.ma_san_pham}"><img src="data:image/jpeg;base64,${sp.hinh_anh}" alt="Product Name"></a></div>
	                                <div class="productname">${sp.tenSanPham }</div>
	                                <h4 class="price"><f:formatNumber type="number" value="${sp.giaSanPham}"/>₫</h4>
	                                <div class="button_group"><button onclick="javascript:location.href='themGioHang?id=${sp.ma_san_pham}'" formmethod="post" class="button add-cart" type="submit">Mua</button><button class="button compare" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
	                             </div>
	                     </div>
                     </c:forEach>
                   </div>
                 </li><li style="width: 698px;">
                   <div class="row">
                     <c:forEach items="${dssp_hot2}" var="sphot">
	                     <div class="col-md-4 col-sm-4">
	                       <div class="products">
	                                <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${sphot.ma_san_pham}"><img src="data:image/jpeg;base64,${sphot.hinh_anh}" alt="Product Name"></a></div>
	                                <div class="productname">${sphot.tenSanPham }</div>
	                                <h4 class="price"><f:formatNumber type="number" value="${sphot.giaSanPham}"/>₫</h4>
	                                <div class="button_group"><button onclick="javascript:location.href='themGioHang?id=${sphot.ma_san_pham}'" class="button add-cart" type="submit">Mua</button><button class="button compare" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
	                             </div>
	                     </div>
                     </c:forEach>
                   </div>
                 </li></ul></div>
             </div>