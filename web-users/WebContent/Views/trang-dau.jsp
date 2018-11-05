<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <html>
   <head>
      <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
      <meta name="description" content="Hệ Thống bàn hàng trực tuyến hàng đầu VN hay đến với chúng tôi để sở hữu những sản phẩm chất lượng với giá hấp dẫn">
      <meta name="author" content="Nhóm phát triển, Back-End: Nguyên">
      <meta name="keywords" content="apple, iphone, samsung, dien thoai, gia re, mua hang, phu kien">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="shortcut icon" href="images/favicon.png">
      <title>Welcome to Dienthoaionline.com - Hệ thống bán điện thoại trực tuyến toàn quốc</title>
      <meta name="keywords" content="dienthoaionline , dien thoai sach tay , hang free cho khong">
      <link href="css/bootstrap.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
      <link href="css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
      <link href="css/sequence-looptheme.css" rel="stylesheet" media="all"/>
      <link href="css/style.css" rel="stylesheet">
      <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script><![endif]-->
   <script type="text/javascript" src="http://gc.kis.scr.kaspersky-labs.com/1B74BD89-2A22-4B93-B451-1C9E1052A0EC/main.js" charset="UTF-8"></script></head>
<body id="home">
<div class="wrapper">    
<div class="header" style="position: fixed;">
            <div class="container">
               <div class="row">
                  <div class="col-md-2 col-sm-2">
                     <div class="logo"><a href="trang-chu"><img src="images/logo2.png" alt="DTO" "=""></a></div>
                  </div>
                  <div class="col-md-10 col-sm-10">
                     <div class="header_top">
                        <div class="row">
                           <div class="col-md-3">
                             
                           </div>
                           <div class="col-md-6">
                              <ul class="topmenu">
                                 <li><a href="contact">Giới Thiệu</a></li>
                                 <li><a href="contact">Góp Ý</a></li>
                                 <li><a href="#">Xin chào ${sessionScope.member.ten_user}</a></li>

                              </ul>
                           </div>
                           <div class="col-md-3">
                              <ul class="usermenu">
                              	<c:if test="${sessionScope.member == null}">
                              		<li><a href='dang-nhap' class='log'>Đăng Nhập</a></li>
           	                        <li><a href='dang-ky' class='reg'>Đăng Ký</a></li>
                              	</c:if>
                              	<c:if test="${sessionScope.member != null}">
                                	<li><a href='dangXuatServlet' class='reg'>Đăng xuất</a></li>
                                </c:if>	
                              </ul>
                           </div>
                        </div>
                     </div>
                     <div class="clearfix"></div>
                     <div class="header_bottom">
                        <ul class="option">
                           <li id="search" class="search">
                              <form name="formTimKiem" action="timKiemSanPham" method="POST" onsubmit="return xacThucTimKiem()">
                              	<input class="search-submit" type="submit" value="">
                              	<input class="search-input" placeholder="Nhập sản phẩm bạn muốn tìm?" type="text" value="" name="txtTen">
                              </form>
                              <script text="text/javascript">
									function xacThucTimKiem() {
									    var san_pham = document.forms["formTimKiem"]["txtTen"].value;
									    if (san_pham == "") {
									        alert("Không được để trống");
									        return false;
									    }
									}
							 </script>
                           </li>
                           <li class="option-cart">
                              <a 
                              		<c:if test='${sessionScope.member == null}'>onclick="alert('Bạn chưa đăng nhập'); return false;"</c:if>
	                              	<c:if test='${sessionScope.gioHang.countSoLuongMua() == 0}' > onclick="alert('Không có sản phẩm trong giỏ'); return false;" </c:if>
	                              	<c:if test='${sessionScope.gioHang == null}' > onclick="alert('Không có sản phẩm trong giỏ'); return false;" </c:if>	
                           		 href="<c:if test='${sessionScope.gioHang != null}'>xemGioHangServlet</c:if>" class="cart-icon">cart <span class="cart_no">${sessionScope.gioHang.countSoLuongMua()}</span></a>
                              <ul class="option-cart-item">
                              <c:forEach items="${spm}" var="spham_mua">
                                 <li>
                                 
	                                    <div class="cart-item">
	                                       <div class="image"><img src="data:image/jpeg;base64,${spham_mua.hinh_anh}" alt=""></div>
			                                       <div class="item-description">
			                                          <p class="name">${spham_mua.tenSanPham}</p>
			                                          <p>Số Lượng: <span class="light-red">${spham_mua.soLuongMua}</span></p>
			                                       </div>
			                                       <div class="right">
			                                          <p class="price"><f:formatNumber type="number" value="${spham_mua.getThanhTien()}" /> ₫</p>
			                                          <a onclick="return xacNhanDelete();" href="xoaDonHang?id=${spham_mua.ma_san_pham}" class="remove"><img src="images/remove.png" alt="remove"></a>
			                                          <script type="text/javascript">
															function xacNhanDelete() {
																var x = confirm("Bạn có muốn xóa sản phẩm này ?");
																  if (x)
																      return true;
																  else
																    return false;
															}
			                                          </script>
			                                       </div>
		                                       
	                                    </div>
                                  
                                 </li>
                               </c:forEach>
                                 <li><span class="total">Tổng cộng <strong><f:formatNumber type="number" value="${sessionScope.gioHang.tongTien()}"/>₫</strong></span><button class="checkout" onclick="location.href='<c:if test='${sessionScope.gioHang != null}'>xemGioHangServlet</c:if>'">Thanh Toán</button></li>
                              </ul>
                           </li>
                        </ul>
                        <div class="navbar-header"><button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                           <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
                           <span class="icon-bar"></span>
                           <span class="icon-bar"></span></button></div>
                        <div class="navbar-collapse collapse">
                           <ul class="nav navbar-nav">
                              <li class="active dropdown">
                                 <a href="trang-chu.jsp">Home</a>
                                 
                              </li>
                              <li><a href="timTheoHangSanPham?hang=Apple">Apple</a></li>
                              <li><a href="timTheoHangSanPham?hang=Sony">Sony</a></li>
                              <li class="dropdown">
                                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Phụ Kiện</a>
                                 <div class="dropdown-menu mega-menu">
                                    <div class="row">
                                       <div class="col-md-6 col-sm-6">
                                          <ul class="mega-menu-links">
                                             <li><a href="phuKien?loaiPK=1">Bao da &amp; ốp lưng</a></li>
                                             <li><a href="phuKien?loaiPK=2"> Sạc dự phòng </a></li>
                                             <li><a href="phuKien?loaiPK=3">Tai nghe</a></li>
                                             
                                          </ul>
                                       </div>
                                    </div>
                                 </div>
                              </li>
                              <li><a href="timTheoHangSanPham?hang=Oppo">Oppo</a></li>
                              <li><a href="timTheoHangSanPham?hang=Nokia">Nokia</a></li> 
                              <li><a href="timTheoHangSanPham?hang=Samsung">Samsung</a></li>
                              <li><a href="contact">Liên hệ chúng tôi</a></li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>