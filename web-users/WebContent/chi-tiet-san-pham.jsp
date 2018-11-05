<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.gioHang != null}">
	<jsp:include page="/gioHangServlet"></jsp:include>
</c:if>
<c:if test="${sessionScope.gioHang == null}">
	<jsp:include page="/Views/trang-dau.jsp"></jsp:include>
</c:if>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.10';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <div class="col-md-9">
              <div class="products-details">
                <div class="preview_image">
                  <div class="preview-small">
                    <div style="height:378px;width:328px;" class="zoomWrapper"><img id="zoom_03" src="data:image/jpeg;base64,${chitiet.hinh_anh}" data-zoom-image="images/products/Large/products-01.png" alt="" style="position: absolute; width: 328px; height: 378px;"><div style="background: url(&quot;images/loading.gif&quot;) center center no-repeat; height: 378px; width: 328px; z-index: 2000; position: absolute; display: none;"></div><div style="background: url(&quot;images/loading.gif&quot;) center center no-repeat; height: 378px; width: 328px; z-index: 2000; position: absolute; display: none;"></div><div style="background: url(&quot;images/loading.gif&quot;) center center no-repeat; height: 378px; width: 328px; z-index: 2000; position: absolute; display: none;"></div><div style="background: url(&quot;images/loading.gif&quot;) center center no-repeat; height: 378px; width: 328px; z-index: 2000; position: absolute; display: none;"></div></div>
                  </div>
                  
                </div>
                <div class="products-description">
                  <h5 class="name">
                    ${chitiet.tenSanPham}
                  </h5>
                  <p>
                    <img alt="" src="images/star.png">
                    
                  </p>
                  <br/>	<br/><br/>
                  <p style="font-size: 16px;">
                    Tình trạng:
                    <span class=" light-red">
                      ${chitiet.tinhTrang}
                    </span>
                  </p>
                  <br/>	<br/>
                  <p style="font-size: 16px;">
                    Hãng:  ${chitiet.hangSanXuat}
                  </p>
                  <hr class="border">
                  <div class="price">
                    Giá: 
                    <span class="new_price">
                      <f:formatNumber type="number" value="${chitiet.giaSanPham}" /> 
                      <sup>
                        ₫
                      </sup>
                    </span>
                    
                  </div>
                  <hr class="border">
                  <div class="wided">
                    <div class="qty">
                      SL: 
                      <select>
                        <option>
                          1
                        </option>
                      </select>
                    </div>
                    <div class="button_group">
                    	<form action='themGioHang?id=${chitiet.ma_san_pham}' method="post">
	                      <button  class="button" type="submit">
	                        Mua
	                      </button>
                      </form>
                      <button class="button compare">
                        <i class="fa fa-exchange">
                        </i>
                      </button>
                      <button class="button favorite">
                        <i class="fa fa-heart-o">
                        </i>
                      </button>
                      <button class="button favorite">
                        <i class="fa fa-envelope-o">
                        </i>
                      </button>
                    </div>
                  </div>
                  <div class="clearfix">
                  </div>
                  <hr class="border">
                  <img src="images/share.png" alt="" class="pull-right">
                </div>
              </div>
              <div class="clearfix">
              </div>
              <div class="tab-box">
                <div id="tabnav">
                  <ul>
                    <li class="active">
                      <a href="#Descraption">
                        Giới Thiệu Sản Phẩm
                      </a>
                    </li>
                   
                </ul></div>
                <div class="tab-content-wrap">
                  <div class="tab-content" id="Descraption" style="display: block;">
                    <p style="font-size: 16px;">
                      ${chitiet.tinh_nang}
                    </p>
                    <p>
                    </p>
                  </div>
                  <div class="tab-content" id="Reviews" style="display: none;">   
                      <div class="row">
                        <div class="col-md-6 col-sm-6">                       
                          <div class="form-row">
                          </div>
                          <div class="form-row">
                          </div>
                        </div>
                      </div>                   
                  </div>             
                </div>
              </div>
              <div class="clearfix">
              </div>
              <div style=""  class="fb-comments" data-href="http://localhost:8080/web-mobile/xemChiTietSanPhamServlet?id=${chitiet.ma_san_pham}omments#configurator" data-numposts="10"></div>
              <jsp:include page="sanPhamHot"/>
              <div class="clearfix">
              </div>
            </div>
            <div class="col-md-3">
              
              <div class="clearfix">
              </div>
              <div class="product-tag leftbar">
                <h3 class="title">
                  Sản Phẩm
                  <strong>
                    Tags
                  </strong>
                </h3>
                 <ul>
                  <li>
                    <a href="timTheoGiaSanPhamServlet?options=1">
                      Dưới 1 triệu
                    </a>
                  </li>
                  <li>
                    <a href="timTheoGiaSanPhamServlet?options=2">
                      Từ 1 - 3 triệu
                    </a>
                  </li>
                  <li>
                    <a href="timTheoGiaSanPhamServlet?options=3">
                      Từ 3 - 7 triệu
                    </a>
                  </li>
                  <li>
                    <a href="timTheoGiaSanPhamServlet?options=4">
                      Từ 7 - 10 triệu
                    </a>
                  </li>
                  <li>
                    <a href="timTheoHangSanPham?hang=Apple">
                      iPhone (Apple)
                    </a>
                  </li>
                  <li>
                    <a href="timTheoHangSanPham?hang=Samsung">
                      Samsung
                    </a>
                  </li>
                  <li>
                    <a href="timTheoHangSanPham?hang=Sony">
                      Sony
                    </a>
                  </li>
                  <li>
                    <a href="timTheoHangSanPham?hang=Oppo">
                      OPPO
                    </a>
                  </li>
                </ul>
              </div>
              <jsp:include page="sanPhamNoiBat"/>
              <div class="clearfix">
              </div>
              <div class="get-newsletter leftbar">
                <h3 class="title">
                  Nhận 
                  <strong>
                    Tin Tức
                  </strong>
                </h3>
                
                <form name="formEmail" onsubmit="return xacThuc()" action="ThanksServlet" method="post">
                  <input class="email" type="text" name="email" placeholder=" Email của bạn">

                  <input class="submit" type="submit" value="Submit">
                </form>
              </div>
              <div class="clearfix">
              </div>
              <div class="fbl-box leftbar">
                <h3 class="title">
                  Facebook
                </h3>
                <div class="fb-like" data-href="http://localhost:8080/web-mobile/xemChiTietSanPhamServlet?id=1" data-layout="standard" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div>
                <p>
                  69k Người like Dienthoaionline
                </p>
                <ul>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                  <li>
                    <a href="#">
                    </a>
                  </li>
                </ul>
                <div class="fbplug">
                  <a href="https://www.facebook.com/groups/181413709094833/">
                    <span>
                      <img src="images/fbicon.png" alt="">
                    </span>
                    Facebook 
                  </a>
                </div>
              </div>
              <div class="clearfix">
              </div>
            </div>
          </div>
          <div class="clearfix">
          </div>
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
<jsp:include page="Views/trang-cuoi.jsp"></jsp:include>