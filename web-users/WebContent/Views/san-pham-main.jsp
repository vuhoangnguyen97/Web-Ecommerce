<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container_fullwidth">
            <div class="container">
               <div class="hot-products">
                  <h3 class="title"><strong>Sản Phẩm Hot</strong></h3>
                  <div class="control"><a id="prev_hot" class="prev" href="#" style="display: block;">&lt;</a><a id="next_hot" class="next" href="#" style="display: block;">&gt;</a></div>
                  <div class="caroufredsel_wrapper" style="display: block; text-align: start; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 940px; height: 533px; margin: 0px; overflow: hidden;"><ul id="hot" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 4700px; height: 533px;">
                     
                     <li style="width: 940px;">
                        <div class="row">
	                        <c:forEach items="${dssp}" var="sp">
	                           <div class="col-md-3 col-sm-6">	                           
	                              <div class="products">
	                              	<form action="themGioHang?id=${sp.ma_san_pham}" method="post">
		                                 <div class="offer">Trả góp 0%</div>
		                                 <div style='visibility: hidden;'>
                             		         <input id="txtMaSanPham" value="${sp.ma_san_pham}" type="text"/>		                                 
		                                 </div>
		                                 <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${sp.ma_san_pham}"><img src="data:image/jpeg;base64,${sp.hinh_anh}" alt="Product Name"></a></div>
		                                 <div class="productname">${sp.tenSanPham }</div>
		                                 <h4 class="price"><f:formatNumber type="number" value="${sp.giaSanPham}"/>₫</h4>
	                                 		
	                                 	<div class="button_group">
		                                 	<button class="button add-cart" type="submit">Mua</button>		                                 	
	                                 		<button class="button compare" onclick="window.open('soSanhServlet?id=${sp.ma_san_pham}','popup','width=450,height=300'); return false;" type="button"><i class="fa fa-exchange"></i></button>
		                                 	<button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button>
	                                 	</div>
	                              	 </form>
	                              </div>
	                           
	                           </div>
	                        </c:forEach>   
                        </div>
                     </li>
                     <li style="width: 940px;">
                        <div class="row">
	                        <c:forEach items="${dssp_bottom}" var="bottom">
	                        	<form action="themGioHang?id=${bottom.ma_san_pham}" method="post">
		                           <div class="col-md-3 col-sm-6">
		                              <div class="products">
		                                 <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${bottom.ma_san_pham}"><img src="data:image/jpeg;base64,${bottom.hinh_anh}" alt="Product Name"></a></div>
		                                 <div class="productname">${bottom.tenSanPham}</div>
		                                 <h4 class="price"><f:formatNumber type="number" value="${bottom.giaSanPham}"/> ₫</h4>
		                                 <div class="button_group"><button class="button add-cart" type="submit">Mua</button><button class="button compare" onclick="window.open('soSanhServlet?id=${bottom.ma_san_pham}','popup','width=450,height=300'); return false;" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
		                              </div>
		                           </div>
		                          </form>
	                         </c:forEach>  
                         </div>
                      </li>
                     
                  </ul></div>
               </div>
               <div class="clearfix"></div>
               <div class="featured-products">
                  <h3 class="title"><strong>Bán Chạy</strong></h3>
                  <div class="control"><a id="prev_featured" class="prev" href="#" style="display: block;">&lt;</a><a id="next_featured" class="next" href="#" style="display: block;">&gt;</a></div>
                  <div class="caroufredsel_wrapper" style="display: block; text-align: start; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 940px; height: 533px; margin: 0px; overflow: hidden;"><ul id="featured" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 4700px; height: 550px;">
                     <li style="width: 940px;">
                        <div class="row">
                        <c:forEach items="${dssp_Re}" var="spre">
	                       <form action="themGioHang?id=${spre.ma_san_pham}" method="post">    
	                           <div class="col-md-3 col-sm-6">
	                              <div class="products">
	                                 <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${spre.ma_san_pham}"><img src="data:image/jpeg;base64,${spre.hinh_anh}" alt="Product Name"></a></div>
	                                 <div class="productname">${spre.tenSanPham}</div>
	                                 <h4 class="price"><f:formatNumber type="number" value="${spre.giaSanPham}"/>₫</h4>
	                                 <div class="button_group"><button class="button add-cart" type="submit">Mua</button><button class="button compare" onclick="window.open('soSanhServlet?id=${spre.ma_san_pham}','popup','width=450,height=300'); return false;" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
	                              </div>
	                           </div>
                           </form>
                         </c:forEach>  
                        </div>
                     </li>
                     <li style="width: 940px;">
                        <div class="row">
	                        <c:forEach items="${dssp_ReTren1Trieu}" var="spre">
		                        <form action="themGioHang?id=${spre.ma_san_pham}" method="post">   
		                           <div class="col-md-3 col-sm-6">
		                              <div class="products">
		                                 <div class="thumbnail"><a href="xemChiTietSanPhamServlet?id=${spre.ma_san_pham}"><img src="data:image/jpeg;base64,${spre.hinh_anh}" alt="Product Name"></a></div>
		                                 <div class="productname">${spre.tenSanPham}</div>
		                                 <h4 class="price"><f:formatNumber type="number" value="${spre.giaSanPham}" />₫</h4>
		                                 <div class="button_group"><button class="button add-cart" type="submit">Mua</button><button class="button compare" onclick="window.open('soSanhServlet?id=${spre.ma_san_pham}','popup','width=450,height=300'); return false;" type="button"><i class="fa fa-exchange"></i></button><button class="button wishlist" type="button"><i class="fa fa-heart-o"></i></button></div>
		                              </div>
		                           </div>
		                        </form>   
	                         </c:forEach>  
                        </div>
                     </li>
                  </ul></div>
               </div>
               <div class="clearfix"></div>
               <div class="our-brand">
                  <h3 class="title"><strong>Liên kết </strong></h3>
                  <div class="control"><a id="prev_brand" class="prev" href="#" style="display: block;">&lt;</a><a id="next_brand" class="next" href="#" style="display: block;">&gt;</a></div>
                  <div class="caroufredsel_wrapper" style="display: block; text-align: start; float: left; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 940px; height: 97px; margin: 0px; overflow: hidden;"><ul id="braldLogo" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 4700px; height: 97px;">
                     <li style="width: 940px;">
                        <ul class="brand_item">
                           <li>
                              <a href="https://www.google.com.vn/">
                                 <div class="brand-logo"><img src="images/google.png" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="https://www.microsoft.com/vi-vn">
                                 <div class="brand-logo"><img src=" images/microsoft.jpg" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="https://www.apple.com/">
                                 <div class="brand-logo"><img src="images/apple.jpg" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="http://www.samsung.com/vn/">
                                 <div class="brand-logo"><img src="images/samsung.jpg" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="http://www.sony.com.vn/">
                                 <div class="brand-logo"><img src="images/sony.png" alt=""></div>
                              </a>
                           </li>
                        </ul>
                     </li>
                     <li style="width: 940px;">
                        <ul class="brand_item">
                           <li>
                              <a href="http://www.mi.com/vn/">
                                 <div class="brand-logo"><img src="images/xiaomi.jpg" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="http://www.htc.com/vn/">
                                 <div class="brand-logo"><img src="images/htc.jpg" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="http://www.lg.com/vn">
                                 <div class="brand-logo"><img src="images/lg.png" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="http://oppomobile.vn/">
                                 <div class="brand-logo"><img src="images/oppo.png" alt=""></div>
                              </a>
                           </li>
                           <li>
                              <a href="https://www3.lenovo.com/vn/vn/">
                                 <div class="brand-logo"><img src="images/lenovo.png" alt=""></div>
                              </a>
                           </li>
                        </ul>
                     </li>
                  </ul></div>
               </div>
            </div>
         </div>