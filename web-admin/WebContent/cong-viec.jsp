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
	        <title>Trang Quản Lý</title>
	
	        <meta name="description" content="">
	        <meta name="viewport" content="width=device-width, initial-scale=1">
	        <link rel="apple-touch-icon" href="apple-touch-icon.png">
	        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	        <style>
	        .contact-content.custom-contact-content {
			    height: 100%;
			}
	        .custom-bg{
	        	background-color: rgba(45, 58, 75, 0.5);
	        }
	         .mobi-count{
		           color: white;
		           font-weight: bold;
		           text-align: center;
		           padding: 20px;
		           margin: 50% auto;
		           font-size: 50px;
		           border: dashed 1px white;
		           height: 191px;
		       }
	        </style>
	
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
	                                    <a href="quan-ly-thanh-vien.jsp"> Quản lý thành viên </a>
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
	                                    <a href="quan-ly-san-pham.jsp">Tới trang quản lý sản phẩm</a>
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
	                                    <a href="quan-ly-don-hang.jsp">Xem đơn hàng</a>
	                                  </div>
	                                </div>
	                              </div>
	                            </div>
	                            <div>
	                              <div class="project-item">
	                                <a href="#" data-lightbox="image-1"><img src="staff-main/img/project-item-03.jpg" alt=""></a>
	                                <div class="text-content">
	                                  <h4>Quản lý nhân viên</h4>
	                                  <p>Tất cả nhân viên trong công ty.</p>
	                                  <div class="primary-button">
	                                    <a href="quan-ly-nhan-vien.jsp">Xem nhân viên</a>
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
	                    <div class="contact-content custom-contact-content">
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
	                  <!-- Phần Count Up -->
	                  <!-- Muốn Thay đổi số thì thiết lập lại ngay thuộc tính data-count="250" tức là nó chạy đến 250 -->
	        
				        <div class="container custom-bg">
					        <div class="row">
					            <div class="col-md-3 col-xs-6">
					                <div class="mobi-count">
					                    <span class="num-count"><strong class="counter" data-count="${countUser}">0</strong></span>
					                    <i class="fas fa-user"></i><h3>User Hiện Tại</h3>
					                </div>
					            </div>
					            <div class="col-md-3 col-xs-6">
					                <div class="mobi-count">
					                    <span class="num-count"><strong class="counter" data-count="${countDonHang}">0</strong></span>
					                    <i class="fas fa-shopping-cart"></i><h3>Đơn Hàng Hiện Tại</h3>
					                </div>
					            </div>
					            <div class="col-md-3 col-xs-6">
					                <div class="mobi-count">
					                    <span class="num-count"><strong class="counter" data-count="${countUserNow}">0</strong></span>
					                    <i class="fas fa-users"></i><h3>Số người Kết Nối Hiện Tại</h3>
					                </div>
					            </div>
					            <div class="col-md-3 col-xs-6">
					                <div class="mobi-count">
					                    <span class="num-count"><strong class="counter" data-count="${countSanPham}">0</strong></span>
					                    <i class="fas fa-mobile-alt"></i><h3>Sản Phẩm Hiện Tại</h3>
					                </div>
					            </div>
					        </div>
					    </div>
	        
	        <!-- -------------------------------------------------------- -->
	                  <div class="col-md-12">
	                    <div class="footer">
	                      <p>Copyright &copy; 2018 Cửa hàng bán điện thoại</p> 
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
	        
	        <!-- JS của phần COUNT UP -->
	        
	        <script>
            $('.counter').each(function() {
                var $this = $(this),
                    countTo = $this.attr('data-count');
    
                $({
                    countNum: $this.text()
                }).animate({
                        countNum: countTo
                    },
    
                    {
                        duration: 3000,
                        easing: 'linear',
                        step: function() {
                            $this.text(Math.floor(this.countNum));
                        },
                        complete: function() {
                            $this.text(this.countNum);
                            //alert('finished');
                        }
    
                    });
            });
        </script>
	        
	        <!-- -----Google Analyze----- -->
	
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