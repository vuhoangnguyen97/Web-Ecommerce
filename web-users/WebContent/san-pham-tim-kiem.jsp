<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.gioHang != null}">
	<jsp:include page="/gioHangServlet"></jsp:include>
</c:if>
<c:if test="${sessionScope.gioHang == null}">
	<jsp:include page="/Views/trang-dau.jsp"></jsp:include>
</c:if>
<c:if test="${size == 0 }">
	<script>
		alert("Không tìm thấy sản phẩm!");
	</script>
</c:if>
<div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <jsp:include page="/Views/menu-ben-trai.jsp"></jsp:include>
            <div class="col-md-9">
              <div class="banner">
                <div class="bannerslide" id="bannerslide">
                  
                <div class="flex-viewport" style="overflow: hidden; position: relative;"><ul class="slides" style="width: 800%; transition-duration: 0s; transform: translate3d(-1396px, 0px, 0px);"><li class="clone" style="width: 698px; float: left; display: block;">
                      <a href="#">
                        <img src="images/banner-02.png" alt="" draggable="false">
                      </a>
                    </li><li class="clone" aria-hidden="true" style="width: 698px; float: left; display: block;">
                      <a href="#">
                        <img src="images/banner-02.png" alt="" draggable="false">
                      </a>
                    </li>
                    <li class="" style="width: 698px; float: left; display: block;">
                      <a href="#">
                        <img src="images/banner-01.png" alt="" draggable="false">
                      </a>
                    </li>
                    <li class="flex-active-slide" style="width: 698px; float: left; display: block;">
                      <a href="#">
                        <img src="images/banner-02.png" alt="" draggable="false">
                      </a>
                    </li>
                    
                  <li class="clone" aria-hidden="true" style="width: 698px; float: left; display: block;">
                      <a href="#">
                        <img src="images/banner-01.png" alt="" draggable="false">
                      </a>
                    </li><li class="clone" style="width: 698px; float: left; display: block;">
                      <a href="#">
                        <img src="images/banner-01.png" alt="" draggable="false">
                      </a>
                    </li></ul></div></div>
              </div>
              <div class="clearfix">
              </div>
              <div class="products-grid">
                <div class="toolbar">
                  
                    <div class="sort-by">
                      Sắp xếp theo : 
                      <select name="">
                        <option value="Default" selected="">
                          Chọn
                        </option>
                        <option value="Name">
                          Tên
                        </option>
                        <option value="Price">
                          Giá
                        </option>
                      </select>
                    </div>
                    <div class="limiter">
                      Hiện: 
                      <select name="">
                        <option value="3" selected="">
                          3
                        </option>
                        <option value="6">
                          6
                        </option>
                        <option value="9">
                          9
                        </option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="clearfix">
                </div>
                <div class="row">
                	<c:forEach items="${dssp_ten}" var="dst">
   	                  <form action="themGioHang?id=${dst.ma_san_pham}" method="post">    
		                  <div class="col-md-4 col-sm-6">
		                    	<div class="products">
	                                <div class="offer">Trả Góp 0%</div>
	                                <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${dst.ma_san_pham}"><img src="data:image/jpeg;base64,${dst.hinh_anh}" alt="Product Name"></a></div>
	                                <div class="productname">${dst.tenSanPham}</div>
	                                <h4 class="price"><f:formatNumber type="number" value="${dst.giaSanPham}" /> ₫</h4>
	                                <div class="button_group"><button class="button add-cart" type="submit">Mua</button><button class="button compare" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
	                           	</div>
		                  </div>
		              </form>    
                  </c:forEach>
                  </div>
                </div>
                <div class="clearfix">
                </div>
                
            </div>
            </div>
            </div>
            </div>
          <div class="clearfix">
          </div>
          
        </div>
      
<jsp:include page="Views/trang-cuoi.jsp"></jsp:include>