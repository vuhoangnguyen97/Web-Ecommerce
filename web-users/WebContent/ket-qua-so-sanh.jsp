<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
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
      <script type="text/javascript" src="http://gc.kis.scr.kaspersky-labs.com/1B74BD89-2A22-4B93-B451-1C9E1052A0EC/main.js" charset="UTF-8"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" type="text/css" href="sosanh.css">
    </head>
<body id="home">
<div class="wrapper">    
<div class="header navbar navbar-fixed-top" >
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
                                 <li><a href="#">Xin chào Minh Hậu</a></li>

                              </ul>
                           </div>
                           <div class="col-md-3">
                              <ul class="usermenu">
                              	
                              	
                                	<li><a href='dangXuatServlet' class='reg'>Đăng xuất</a></li>
                                	
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
	                              	
	                              		
                           		 href="xemGioHangServlet" class="cart-icon">cart <span class="cart_no"></span></a>
                              <ul class="option-cart-item">
                              
                                 <li>
                                 
	                                    <div class="cart-item">
	                                       <div class="image"><img src="data:image/jpeg;base64," alt=""></div>
			                                       <div class="item-description">
			                                          <p class="name"></p>
			                                          <p><span class="light-red"></span></p>
			                                       </div>
			                                       <div class="right">
			                                          <p class="price"></p>
			                                          <a onclick="return xacNhanDelete();" href="xoaDonHang?id=1" class="remove"><img src="images/remove.png" alt="remove"></a>
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
                               
                                 <li><span class="total">Tổng cộng <strong></strong></span><button class="checkout" onclick="location.href='xemGioHangServlet'">Thanh Toán</button></li>
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



<div class="clearfix">
</div>
<div class="page-index">
        <div class="container">
            <p>
              <a style="color:white;" href="trang-chu.jsp">Trang chủ</a> - <a style="color:white;" href="#"> Chi Tiết Đơn Hàng</a> - <a style="color:white;" href="#">So Sánh Sản Phẩm</a>
            </p>
          </div>
    </div>



    <div class="container-fluid">
              <div class="row">
                    <div class="col-md-12">
                        <div class="xacnhan">
                            <table class="table custom-border custom-color-white-bold">
                                <tbody>
                                    <tr>
                                        <td></td>
                                        <td><img src="data:image/jpeg;base64,${sp.hinh_anh}" alt="Hình sản phẩm 1"></td>
                                        <td><img src="data:image/jpeg;base64,${spSoSanh.hinh_anh}" alt="Hình sản phẩm 2"></td>
                                    </tr>

                                    <tr>
                                        <td>Tên Sản Phẩm: </td>
                                        <td>${sp.tenSanPham}</td>
                                        <td>${spSoSanh.tenSanPham}</td>
                                    </tr>

                                    <tr>
                                        <td>Hãng Sản Xuất: </td>
                                        <td>${sp.hangSanXuat}</td>
                                        <td>${spSoSanh.hangSanXuat}</td>
                                    </tr>

                                    <tr>
                                        <td>Giá Sản Phẩm: </td>
                                        <td> <f:formatNumber type="number" value="${sp.giaSanPham}" /> </td>
                                        <td><f:formatNumber type="number" value="${spSoSanh.giaSanPham}" /></td>
                                    </tr>

                                    <tr>
                                        <td>Tình Trạng: </td>
                                        <td>Mới 100% chính hãng fullbox</td>
                                        <td>Mới 100% chính hãng fullbox</td>
                                    </tr>

                                    <tr>
                                        <td>Camera Trước: </td>
                                        <td>${sp.camera_truoc}</td>
                                        <td>${sp.camera_truoc}</td>
                                    </tr>

                                    <tr>
                                        <td>Camera Sau: </td>
                                        <td>${sp.camera_sau}</td>
                                        <td>${spSoSanh.camera_sau}</td>
                                    </tr>

                                    <tr>
                                        <td>Dung Lượng Pin: </td>
                                        <td>${sp.dung_luong_pin}</td>
                                        <td>${spSoSanh.dung_luong_pin}</td>
                                    </tr>

                                    <tr>
                                        <td>Màu Sắc: </td>
                                        <td>${sp.mau_sac}</td>
                                        <td>${spSoSanh.mau_sac}</td>
                                    </tr>

                                    <tr>
                                        <td>Bảo Mật: </td>
                                        <td>${sp.bao_mat}</td>
                                        <td>${spSoSanh.bao_mat}<</td>
                                    </td>
                                </tbody>
                            </table>
                        </div>
                    </div>        
              </div>
              <div class="clearfix">
              </div>
          <div class="clearfix">
          </div>
    </div>
    

<div class="footer navbar navbar-fixed-bottom">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://arrow.scrolltotop.com/arrow92.js"></script>
	
            <div class="footer-info">
               <div class="container">
                  <div class="row">
                     <div class="col-md-3">
                        <div class="footer-logo"><a href="#"><img src="images/logo2.png" alt=""></a></div>
                     </div>
                     <div class="col-md-3 col-sm-6">
                        <h4 class="title">Địa <strong> Chỉ</strong></h4>
                        <p>Số 123, Quang Trung, HoChiMinh , Vietnam</p>
                        <p>Số Điện Thoại : 0909.113.911</p>
                        <p>Email :<a href='mailto:testmailbaitap@gmail.com'>testmailbaitap@gmail.com</a> </p>
                     </div>
                     <div class="col-md-3 col-sm-6">
                        <h4 class="title">Hỗ<strong> Trợ</strong></h4>
                        <ul class="support">
                           <li><a href="cau-hoi">Các câu hỏi thường gặp ?</a></li>
                           <li><a href="phuong-thuc-thanh-toan">Phương thức thanh toán</a></li>
                           <li><a href="doi-tra">Thông Tin Đặt Cọc</a></li>
                           <li><a href="contact">Thông tin về chúng tôi</a></li>
                        </ul>
                     </div>
                     <div class="col-md-3">
                        <h4 class="title">Nhận Tin Tức Từ <strong>Email </strong></h4>
                        <p>Để nhận được thêm nhiều khuyến mãi</p>
                        <form name="formEmail" action="ThanksServlet" method="post" class="newsletter" onsubmit="return xacThuc()">
							<input type="email" name="email" placeholder="Nhập email....">
							<input type="submit" value="Gửi" class="button">
						</form>
						<script>
							function xacThuc() {
							    var email_input = document.forms["formEmail"]["email"].value;
							    var check_email = email_input.indexOf("@");
							    var check_email_dot = email_input.lastIndexOf(".");
							    if (email_input == null) {
							        alert("Không được để trống");
							        return false;
							    }
							    else if (check_email<1 || check_email_dot<check_email+2 || check_email_dot+2 >= email_input.length) {
							        alert("Email bạn không hợp lệ");
							        return false;
							    }
							    
							}
						</script>
                     </div>
                  </div>
               </div>
            </div>
            <div class="copyright-info">
               <div class="container">
                  <div class="row">
                     <div class="col-md-6">
                        <p>Copyright © 2017. All rights reseved</p>
                     </div>
                     <div class="col-md-6">
                        <ul class="social-icon">
                           <li><a href="https://www.linkedin.com/shareArticle?mini=true&url=http%3A//localhost%3A8080/web-mobile/trang-chu.jsp&title=&summary=&source=" class="linkedin"></a></li>
                           <li><a href="https://plus.google.com/share?url=http://localhost:8080/web-mobile/trang-chu.jsp" class="google-plus"></a></li>
                           <li><a href="http://www.twitter.com/share?url=http://localhost:8080/web-mobile/trang-chu.jsp" class="twitter"></a></li>
                           <li><a href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8080%2Fweb-mobile%2Ftrang-chu.jsp&amp;src=sdkpreparse" class="facebook"></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      
      <!-- Bootstrap core JavaScript==================================================-->
	  <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	  <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	  <script type="text/javascript" src="js/bootstrap.min.js"></script>
	  <script type="text/javascript" src="js/jquery.sequence-min.js"></script>
	  <script type="text/javascript" src="js/jquery.carouFredSel-6.2.1-packed.js"></script>
	  <script defer src="js/jquery.flexslider.js"></script>
	  <script type="text/javascript" src="js/script.min.js" ></script>
   </body>
</html>