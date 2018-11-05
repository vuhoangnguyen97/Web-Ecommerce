<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
	<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
	<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
	<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
	<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
	    <head>
	        <meta charset="utf-8">
	        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	        <title>Trang nhân viên</title>
	
	        <meta name="description" content="">
	        <meta name="viewport" content="width=device-width, initial-scale=1">
	        <link rel="apple-touch-icon" href="apple-touch-icon.png">
	
	        <link rel="stylesheet" href="staff-main/css/bootstrap.min.css">
	        <link rel="stylesheet" href="staff-main/css/bootstrap-theme.min.css">
	        <link rel="stylesheet" href="staff-main/css/style.css">
	
	        <script src="staff-main/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
	    </head>
	    <body>
	        <!--[if lt IE 8]>
	            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	        <![endif]-->
	        <nav class="nav">
	          <div class="burger">
	            <div class="burger__patty"></div>
	          </div>
	
	          <ul class="nav__list">
	            <li class="nav__item">
	              <a href="#1" class="nav__link c-blue"><img src="staff-main/img/home-icon.png" alt=""></a>
	            </li>
	            
	            <li class="nav__item">
	              <a href="#3" class="nav__link c-red"><img src="staff-main/img/about-icon.png" alt=""></a>
	            </li>
	            <li class="nav__item">
	              <a href="#4" class="nav__link c-green"><img src="staff-main/img/contact-icon.png" alt=""></a>
	            </li>
	          </ul>
	        </nav>
	
	        <section class="panel b-blue" id="1">
	          <article class="panel__wrapper">
	            <div class="panel__content">
	              <div class="container">
	                <div class="row">
	                  <div class="col-md-8 col-md-offset-2">
	                    <div class="home-content">
	                      <div class="home-heading">
	                        <h1><em>staff</em></h1>
	                      </div>
	                      <div class="row">
	                        <div class="col-md-12">
	                          <div class="home-box-content">
	                            <div class="left-text">
	                              <h4><em>xin chào </em>${sessionScope.staff.ten_nhan_vien}</h4>
	                              <p>&nbsp;</p>
	                              <div class="primary-button">
	                                <a href="#3">BẮT ĐẦU CÔNG VIỆC</a>
	                              </div>
	                            </div>
	                            <div class="right-image">
	                              <img src="staff-main/img/right-home-image.png" alt="">
	                            </div>
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </article>
	        </section>
	        <section class="panel b-red" id="3">
	          <article class="panel__wrapper">
	            <div class="panel__content">
	              <div class="container">
	                <div class="row">
	                  <div class="col-md-8 col-md-offset-2">
	                    <div class="projects-content">
	                      <div class="heading">
	                        <h4>CÔNG VIỆC</h4>
	                      </div>
	                      <div class="row">
	                        <div class="col-md-12">
	                          <div class="owl-carousel owl-theme projects-container">
	                            <div>
	                              <div class="project-item">
	                                <a href="#" data-lightbox="image-1"><img src="staff-main/img/project-item-01.jpg" alt=""></a>
	                                <div class="text-content">
	                                  <h4>Quản lý thành viên</h4>
	                                  <p>Quản lý các thành viên hiện có.</p>
	                                  <div class="primary-button">
	                                    <a href="danhSachThanhVien"> Quản lý thành viên </a>
	                                  </div>
	                                </div>
	                              </div>
	                            </div>
	                            <div>
	                              <div class="project-item">
	                                <a href="#" data-lightbox="image-1"><img src="staff-main/img/project-item-02.jpg" alt=""></a>
	                                <div class="text-content">
	                                  <h4>Quản lý sản phẩm </h4>
	                                  <p>Quản lý sản phẩm hiện có.</p>
	                                  <div class="primary-button">
	                                    <a href="danhSachSanPham">Tới trang quản lý sản phẩm</a>
	                                  </div>
	                                </div>
	                              </div>
	                            </div>
	                            <div>
	                              <div class="project-item">
	                                <a href="#" data-lightbox="image-1"><img src="staff-main/img/project-item-03.jpg" alt=""></a>
	                                <div class="text-content">
	                                  <h4>Quản lý đơn hàng</h4>
	                                  <p>Các đơn hàng khách đặt hàng sản phẩm.</p>
	                                  <div class="primary-button">
	                                    <a href="danhSachHoaDon">Xem đơn hàng</a>
	                                  </div>
	                                </div>
	                              </div>
	                            </div>
	                            
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </article>
	        </section>
	        <section class="panel b-green" id="4">
	          <article class="panel__wrapper">
	            <div class="panel__content">
	              <div class="container">
	                <div class="row">
	                  <div class="col-md-8 col-md-offset-2">
	                    <div class="contact-content">
	                      <div class="heading">
	                        <h4>Liên hệ với quản trị viên</h4>
	                      </div>
	                      <div class="row">
	                        <div class="col-md-8">
	                          <div class="contat-form">
	                            <form id="contact" action="phanHoiNhanVien" method="post">
	                              <fieldset>
	                                <input name="name" type="text" class="form-control" id="name" placeholder="Tên của bạn" required>
	                              </fieldset>
	                              <fieldset>
	                                <input name="email" type="email" class="form-control" id="email" placeholder="Email" required>
	                              </fieldset>
	                              <fieldset>
	                                <textarea name="message" rows="6" class="form-control" id="message" placeholder="Lời nhắn" required></textarea>
	                              </fieldset>
	                              <fieldset>
	                                <button type="submit" id="form-submit" class="btn">Gửi góp ý</button>
	                              </fieldset>
	                            </form>
	                          </div>
	                        </div>
	                        <div class="col-md-4">
	                          <div class="more-info">
	                            <p>Cửa hàng bán điện thoại online<br><br>
	                            <em>
									<br>123 Quang Trung Gò Vấp, TPHCM</em></p>
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-md-12">
	                    <div class="footer">
	                      <p>Copyright &copy; 2017 Cửa hàng bán điện thoại 
	                      | Designed by <a href="#" target="_parent">Nguyên</a></p>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </article>
	        </section>
	      
	
	        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
	
	        <script src="staff-main/js/vendor/bootstrap.min.js"></script>
	
	        <script src="staff-main/js/plugins.js"></script>
	        <script src="staff-main/js/main.js"></script>
	
	        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
	        <script>
	            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
	            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
	            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
	            e.src='//www.google-analytics.com/analytics.js';
	            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
	            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
	        </script>
	    </body>
	</html>